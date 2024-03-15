package com.project.SmartStay.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.SmartStay.Repository.RecordingsRepository;
import com.project.SmartStay.entity.Recordings;

@Service
public class RecordingsService {
	 @Autowired
	    private RecordingsRepository recordingRepository; // Assuming you have a RecordingRepository interface
	    
	    public List<Recordings> getAllRecordings() {
	        return recordingRepository.findAll(); // Assuming you have a method in RecordingRepository to fetch all recordings
	    }
	    public Recordings getRecordingById(Long id) {
	        Optional<Recordings> recordingOptional = recordingRepository.findById(id);
	        return recordingOptional.orElse(null);
	    }
}
