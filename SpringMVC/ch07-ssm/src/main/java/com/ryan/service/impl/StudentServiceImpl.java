package com.ryan.service.impl;

import com.ryan.dao.StudentDao;
import com.ryan.domain.Student;
import com.ryan.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    // 引用类型的自定注入@AutoWired，@Resource
    @Resource
    private StudentDao studentDao;
    @Override
    public int addStudent(Student student) {
        int nums = studentDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> findStudents() {

        return studentDao.selectStudents();
    }
}
