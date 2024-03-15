package com.project.SmartStay.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.SmartStay.Repository.RecordingsRepository;
import com.project.SmartStay.Repository.SubjectRepository;
import com.project.SmartStay.entity.Recordings;
import com.project.SmartStay.entity.Subjects;

@Service
public class SubjectService {
    
    @Autowired
    private SubjectRepository subjectRepository;

    @Transactional
    public void addSubject(String subjectName) {
        Subjects subject = new Subjects();
        subject.setSubname(subjectName);
        subjectRepository.save(subject);
    }
    @Autowired
RecordingsRepository recordingRepository;

    @Transactional
    public void addSubjectDetails(String Subname, String youtubeUrl, String topic, LocalDate date) {
        // Retrieve the subject from the database based on its name
        Subjects subject = subjectRepository.findBySubname(Subname);
        if (subject != null) {
            // Create a new Recording entity and set its properties
            Recordings recording = new Recordings();
            recording.setYoutubeUrl(youtubeUrl);
            recording.setTopic(topic);
            recording.setDate(date);
            recording.setSubject(subject); // Associate the recording with the subject
            
            // Save the recording to the database
            recordingRepository.save(recording);
        } else {
            // Handle the case when subject is not found in the database
            // You can throw an exception, log an error, or handle it based on your application's requirements
        }
    }
    public List<Subjects> getAllSubjects() {
        return subjectRepository.findAll();
    }



}
