package com.example.springbootapimysql.controllers;

import com.example.springbootapimysql.exceptions.ResourceNotFoundException;
import com.example.springbootapimysql.models.Lecturer;
import com.example.springbootapimysql.models.Student;
import com.example.springbootapimysql.repositories.LecturerRepository;
import com.example.springbootapimysql.repositories.StudentRepository;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students") // students endpoint
public class StudentController {
    
    @Autowired
    private StudentRepository students;
    
    @Autowired
    private LecturerRepository lecturers;
    
    @PostMapping() // Validates the request body as a Student type
    public Student createStudent(@Valid @RequestBody Student student){
        // Saves and return the new student
        return this.students.save(student);
    }
    
    @GetMapping("/{id}") // Finds a student by id (the variable must be wrapped by "{}" and match the @PathVariable name
    public Student getStudent(@PathVariable Long id){
        // If the record exists by id return it, otherwise throw an exception
        return this.students.findById(id).orElseThrow(() -> 
                new ResourceNotFoundException("Student", id)
        );
    }
    
    @GetMapping() // Finds all stored students in a pageable format
    public Page<Student> getStudents(Pageable pageable){
        return this.students.findAll(pageable);
    }
    
    @PutMapping() // Validates the request body as a Student type
    public Student updateStudent(@Valid @RequestBody Student student){
        // Finds student by id, maps it's content, updates new values and save. Throws an exception if not found.
        return this.students.findById(student.getId()).map((toUpdate) -> {
            toUpdate.setFirstName(student.getFirstName());
            toUpdate.setLastName(student.getLastName());
            toUpdate.setGpa(student.getGpa());
            return this.students.save(toUpdate);
        }).orElseThrow(() -> new ResourceNotFoundException("Student", student.getId()));
    }
    
    @DeleteMapping("/{id}") // Find student by id
    public ResponseEntity deleteStudent(@PathVariable Long id){
        // If id exists, delete the record and return a response message, otherwise throws exception
        return this.students.findById(id).map((toDelete) -> {
            this.students.delete(toDelete);
            return ResponseEntity.ok("Student id " + id + " deleted");
        }).orElseThrow(() -> new ResourceNotFoundException("Student", id));
    }
    
    @GetMapping("/{id}/lecturers")
    public Set<Lecturer> getLecturers(@PathVariable Long id){
        // Finds student by id and returns it's recorded lecturers, otherwise throws exception
        return this.students.findById(id).map((student) -> {
            return student.getLecturers();
        }).orElseThrow(() -> new ResourceNotFoundException("Student", id));
    }
    
}
