package com.example.Student.Controller;

import com.example.Student.Deto.StudentSubjectDto;
import com.example.Student.Deto.SubjectDTO;
import com.example.Student.Entity.Student;
import com.example.Student.Entity.Subject;
import com.example.Student.Service.StudentService;
import com.example.Student.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/students")
public class StudentController {

@Autowired
private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/addStudentWithSubjects")
    public ResponseEntity<Student> createStudent(@RequestBody StudentSubjectDto dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setAddress(dto.getAddress());

        Set<Subject> subjects = new HashSet<>();
        for (SubjectDTO subjectDTO : dto.getSubjects()) {
            Subject subject = subjectService.findByName(subjectDTO.getName());
            if (subject == null) {
                subject = new Subject();
                subject.setName(subjectDTO.getName());
                subjectService.saveSubject(subject);
            }
            subjects.add(subject);
        }
        student.setSubjects(subjects);

        Student savedStudent = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }


    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }

}
