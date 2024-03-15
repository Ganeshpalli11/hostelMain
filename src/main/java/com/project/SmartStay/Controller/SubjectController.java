package com.project.SmartStay.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.SmartStay.Services.SubjectService;
import com.project.SmartStay.entity.Recordings;
import com.project.SmartStay.entity.Subjects;

@Controller
public class SubjectController {
    
    @Autowired
    private SubjectService subjectService;

    @GetMapping("/addSub")
    public String showAddSubjectForm() {
        return "addSubject"; // Return the name of the HTML form template
    }

    @PostMapping("/addSub")
    public String addSubject(@RequestParam("Subname") String Subname) {
        subjectService.addSubject(Subname);
        return "redirect:/"; // Redirect to homepage or any other page after adding the subject
    }
    @GetMapping("/addSubDetails")
    public String showAddSubjectDetailsForm(Model model) {
        List<Subjects> subjects = subjectService.getAllSubjects(); // Assuming you have a method to fetch all subjects
        model.addAttribute("subjects", subjects);
        model.addAttribute("recording", new Recordings());
        return "addSubjectDetails"; // Return the name of the HTML form template
    }


    @PostMapping("/addSubDetails")
    public String addSubjectDetails(@ModelAttribute("recording") Recordings recording) {
        if (recording.getSubject() != null) {
            subjectService.addSubjectDetails(recording.getSubject().getSubname(), recording.getYoutubeUrl(), recording.getTopic(), recording.getDate());
        }
        return "redirect:/"; // Redirect to homepage or any other page after adding subject details
    }


}
