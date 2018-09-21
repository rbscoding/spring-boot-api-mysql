package com.example.springbootapimysql.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "students")
public class Student extends Person{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private Float gpa;
    
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.PERSIST}, 
            mappedBy = "students"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Set<Lecturer> lecturers = new HashSet<>();
    
    // CONSTRUCTORS

    public Student() { }

    public Student(String firstName, String lastName, Float gpa) {
        super(firstName, lastName);
        this.gpa = gpa;
    }
    
    // GETTERS AND SETTERS

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public Float getGpa() {return gpa;}
    public void setGpa(Float gpa) {this.gpa = gpa;}

    public Set<Lecturer> getLecturers() {return lecturers;}
    public void setLecturers(Set<Lecturer> lecturers) {this.lecturers = lecturers;}
    
}
