package com.example.springbootapimysql.models;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class Person extends ModelAudit{
    
    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String firstName;
    
    @Column(nullable = false)
    @Size(min = 2, max = 50)
    private String lastName;
    
    // CONSTRUCTOR

    public Person() { }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    // GETTERS AND SETTERS

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    
}
