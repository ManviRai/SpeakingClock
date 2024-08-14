package com.speakingClock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.speakingClock.service.SpeakingClockService;

@RestController
@RequestMapping("/api/time")
public class SpeakingClockController {
    @Autowired
    private SpeakingClockService speakingClockService;

    @GetMapping("/convert")
    public String convertTime(@RequestParam String time) {
        String result = speakingClockService.Conversion(time);
        return result;
    }
}