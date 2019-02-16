package com.company.dao;

import com.company.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    void create(Student student) throws SQLException;
    void deleteByID(Integer id) throws SQLException;
    List<Student> getAllStudents() throws SQLException;
}
