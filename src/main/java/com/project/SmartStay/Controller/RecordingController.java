package com.project.SmartStay.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.SmartStay.Services.RecordingsService;
import com.project.SmartStay.entity.Recordings;

@Controller
public class RecordingController {

    @Autowired
    private RecordingsService recordingService;

    @GetMapping("/allRecordings")
    public String showAllRecordings(Model model) {
        List<Recordings> allRecordings = recordingService.getAllRecordings(); // Assuming you have a method to fetch all recordings
        model.addAttribute("recordings", allRecordings);
        return "ShowRecordings"; // Return the name of the HTML template to display all recordings
    }

    @PostMapping("/showRecording")
    public String showRecording(@RequestParam("videoId") Long videoId, Model model) {
        Recordings recording = recordingService.getRecordingById(videoId);
        model.addAttribute("recording", recording);
        return "ShowRecording"; // Return the name of the HTML template to display the single recording
    }
}
