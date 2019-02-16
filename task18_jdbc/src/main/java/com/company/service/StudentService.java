package com.company.service;



import com.company.dao.implementation.StudentDAOImpl;
import com.company.model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    public void create(Student student) throws SQLException {
        new StudentDAOImpl().create(student);
    }

    public void delete(Integer id) throws SQLException {
        new StudentDAOImpl().deleteByID(id);
    }

    public List<Student> getAllStudents() throws SQLException {
        return new StudentDAOImpl().getAllStudents();
    }
}
