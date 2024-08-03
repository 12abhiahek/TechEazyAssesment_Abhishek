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
@RequestMapping("/subjects")
public class SubjectController {
  /**  @Autowired
    private SubjectService subjectService;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }
*/

  @Autowired
  private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/addStudentWithSubjects")
    public ResponseEntity<Student> createStudentWithSubjects(@RequestBody StudentSubjectDto dto) {
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
    public ResponseEntity<List<Subject>> getAllSubjects() {
        List<Subject> subjects = subjectService.getAllSubjects();
        return ResponseEntity.ok(subjects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        Subject subject = subjectService.getSubjectById(id);
        if (subject != null) {
            return ResponseEntity.ok(subject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subjectDetails) {
        Subject updatedSubject = subjectService.updateSubject(id, subjectDetails);
        if (updatedSubject != null) {
            return ResponseEntity.ok(updatedSubject);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        if (subjectService.deleteSubject(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
