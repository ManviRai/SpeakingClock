package com.speakingClock.service;

import org.springframework.stereotype.Service;

@Service
public class SpeakingClockService {
    private final String[] hours = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve" };
    private final String[] teens = { "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen" };
    private final String[] tens = { "", "", "twenty", "thirty", "forty", "fifty" };

    public String Conversion(String time) {
        if (time == null || time.isEmpty()) {
            throw new IllegalArgumentException("Time cannot be null or empty");
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        validateHour(hour);
        validateMinute(minute);

        String result;
        if (hour == 0 && minute == 0) {
            result = "It's Midnight";
        } else if (hour == 12 && minute == 0) {
            result = "It's Midday";
        } else {
            hour = hour % 12;
            result = String.format("It's %s %s", getHourInWords(hour), getMinuteInWords(minute));
        }

        return result;
    }

    private void validateHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid hour. Hour must be between 0 and 23.");
        }
    }

    private void validateMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute. Minute must be between 0 and 59.");
        }
    }

    private String getHourInWords(int hour) {
        return hours[hour];
    }

    private String getMinuteInWords(int minute) {
        if (minute == 0) {
            return "o'clock";
        } else if (minute < 10) {
            return hours[minute];
        } else if (minute < 20) {
            return teens[minute - 10];
        } else {
            String tensPart = tens[minute / 10];
            String onesPart = minute % 10 == 0 ? "" : " " + hours[minute % 10];
            return tensPart + onesPart;
        }
    }
}