package com.example.Student.Repository;

import com.example.Student.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject,Long> {


    Subject findByName(String name);

}
