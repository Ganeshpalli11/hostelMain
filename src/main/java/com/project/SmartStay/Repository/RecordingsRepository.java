package com.project.SmartStay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.SmartStay.entity.Recordings;
import com.project.SmartStay.entity.Subjects;

public interface RecordingsRepository extends JpaRepository<Recordings, Long> {
    // You can add custom query methods here if needed

}
