package com.company.dao.implementation;

import com.company.dao.StudentDAO;
import com.company.model.Student;
import com.company.persistant.ConnectionManager;
import com.company.transformer.StudentTransformer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    private final String INSERT_NEW_STUDENT = "INSERT INTO student (id, firstname, lastname, birthday, sex)" +
            " VALUES (?, ?, ?, ?, ?)";
    private final String UPDATE_STUDENT = "UPDATE student SET lastname = test WHERE id = 1";
    private final String DELETE_STUDENT_BY_ID = "DELETE FROM student WHERE id = ?";
    private final String DELETE_ALL_STUDENTS = "DELETE FROM student";
    private final String GET_ALL_STUDENTS = "SELECT * FROM student";

    public void create(Student student) throws SQLException {
        Connection con = ConnectionManager.getConnection();

        try (PreparedStatement statement = con.prepareStatement(INSERT_NEW_STUDENT)) {
            statement.setInt(1, student.getID());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setDate(4, student.getBirthday());
            statement.setString(5, student.getSex().name());

            statement.executeUpdate();
        }
    }

    public void deleteByID(Integer id) throws SQLException {
        Connection con = ConnectionManager.getConnection();

        try (PreparedStatement statement = con.prepareStatement(DELETE_STUDENT_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }

    }

    public List<Student> getAllStudents() throws SQLException {

        List<Student> students = new ArrayList<>();
        Connection con = ConnectionManager.getConnection();

        try (PreparedStatement statement = con.prepareStatement(GET_ALL_STUDENTS)) {
            ResultSet rs = statement.executeQuery();

            while (!rs.isLast()) {
                students.add(new StudentTransformer().fromResultSetToObject(rs));
            }
        }

        return students;
    }
}
