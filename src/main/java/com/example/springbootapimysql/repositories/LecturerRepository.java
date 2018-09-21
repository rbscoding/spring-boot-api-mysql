package com.example.springbootapimysql.repositories;

import com.example.springbootapimysql.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long>{
    
}
