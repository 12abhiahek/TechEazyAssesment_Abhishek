package com.example.Student.Repository;

import com.example.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepsitory extends JpaRepository<Student,Long> {
}
