package com.kostrych.DAO.implementation;

import com.kostrych.DAO.TicketDAO;
import com.kostrych.model.TicketEntity;
import com.kostrych.persistant.ConnectionManager;
import com.kostrych.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDaoImpl implements TicketDAO {
    private static final String FIND_ALL = "SELECT * FROM employee";
    private static final String DELETE = "DELETE FROM employee WHERE emp_no=?";
    private static final String CREATE = "INSERT employee (emp_no, emp_fname, emp_lname, dept_no) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE employee SET emp_fname=?, emp_lname=?, dept_no=? WHERE emp_no=?";
    private static final String FIND_BY_ID = "SELECT * FROM employee WHERE emp_no=?";
    private static final String FIND_BY_FIRST_NAME = "SELECT * FROM employee WHERE emp_fname=?";
    private static final String FIND_BY_DEPT_NO = "SELECT * FROM employee WHERE dept_no=?";

    @Override
    public List<TicketEntity> findAll() throws SQLException {
        List<TicketEntity> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    employees.add((TicketEntity) new Transformer(TicketEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employees;
    }

    @Override
    public TicketEntity findById(Integer id) throws SQLException {
        TicketEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(TicketEntity)new Transformer(TicketEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(TicketEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getPlace());
            ps.setInt(3,entity.getPrice());
            ps.setString(4,entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(TicketEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getPlace());
            ps.setInt(3,entity.getPrice());
            ps.setString(4,entity.getName());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1,id);
            return ps.executeUpdate();
        }
    }

    @Override
    public List<TicketEntity> findByName(String name) throws SQLException {
        List<TicketEntity> employees = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_FIRST_NAME)) {
            ps.setString(1,name);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    employees.add((TicketEntity) new Transformer(TicketEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return employees;
    }

}
