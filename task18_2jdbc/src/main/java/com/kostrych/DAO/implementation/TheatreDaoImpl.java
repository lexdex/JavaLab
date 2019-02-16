package com.kostrych.DAO.implementation;

import com.kostrych.DAO.TheatreDAO;
import com.kostrych.model.TheatreEntity;
import com.kostrych.persistant.ConnectionManager;
import com.kostrych.transformer.Transformer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheatreDaoImpl implements TheatreDAO {
    private static final String FIND_ALL = "SELECT * FROM theatre";
    private static final String DELETE = "DELETE FROM theatre WHERE id=?";
    private static final String CREATE = "INSERT theatre (id,city) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE theatre SET id=?, city=? WHERE id=?";
    private static final String FIND_BY_ID = "SELECT * FROM theatre WHERE id=?";



    @Override
    public List<TheatreEntity> findAll() throws SQLException {
        List<TheatreEntity> departments = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
                while (resultSet.next()) {
                    departments.add((TheatreEntity)new Transformer(TheatreEntity.class).fromResultSetToEntity(resultSet));
                }
            }
        }
        return departments;
    }

    @Override
    public TheatreEntity findById(String id) throws SQLException {
        TheatreEntity entity=null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
            ps.setString(1,id);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    entity=(TheatreEntity)new Transformer(TheatreEntity.class).fromResultSetToEntity(resultSet);
                    break;
                }
            }
        }
        return entity;
    }

    @Override
    public int create(TheatreEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
            ps.setInt(1,entity.getId());
            ps.setString(2,entity.getAddres());
            return ps.executeUpdate();
        }
    }

    @Override
    public int update(TheatreEntity entity) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setInt(1, entity.getId());
            ps.setString(2, entity.getAddres());
            return ps.executeUpdate();
        }
    }

    @Override
    public int delete(String id) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setString(1,id);
            return ps.executeUpdate();
        }
    }

}
