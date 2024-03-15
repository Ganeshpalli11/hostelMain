package com.project.SmartStay.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.SmartStay.entity.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {
    Subjects findBySubname(String Subname); // Method name updated to match attribute name

    // You can add custom query methods here if needed
}
