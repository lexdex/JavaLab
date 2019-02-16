package com.company.transformer;

import com.company.model.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentTransformer {

    public Student fromResultSetToObject(ResultSet rs) throws SQLException {

        Student result = null;

        if (rs.next()) {
            result = new Student();
            result.setID(rs.getInt("id"));
            result.setFirstName(rs.getString("firstname"));
            result.setLastName(rs.getString("lastname"));
            result.setBirthday(rs.getDate("birthday"));
            result.setSex(Student.Sex.valueOf(rs.getString("sex")));
        }

        return result;
    }
}
