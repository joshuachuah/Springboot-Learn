package com.example.demo.dao;

import com.example.demo.entity.Instructor;

public interface AppDAO {

    void save(Instructor theInstructor);

    Instructor findById(int theId);

    void deleteInstructorById(int theId);
}
