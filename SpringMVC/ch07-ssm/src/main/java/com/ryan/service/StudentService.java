package com.ryan.service;

import com.ryan.dao.StudentDao;
import com.ryan.domain.Student;

import java.util.List;

public interface StudentService {
    int addStudent(Student student);
    List<Student> findStudents();
}
