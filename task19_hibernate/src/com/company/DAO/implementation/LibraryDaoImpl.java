package com.company.DAO.implementation;

import com.company.DAO.LibraryDAO;
import com.company.model.LibraryEntity;
import com.company.persistant.ConnectionManager;
import com.company.transformer.Transformer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryDaoImpl implements LibraryDAO {

  private static final String FIND_ALL = "SELECT * FROM library";
  private static final String DELETE = "DELETE FROM library WHERE id=?";
  private static final String CREATE = "INSERT library (id, name, books) VALUES (?, ?, ?)";
  private static final String UPDATE = "UPDATE library SET name=?, books=? WHERE id=?";
  private static final String FIND_BY_ID = "SELECT * FROM library WHERE id=?";

  @Override
  public List<LibraryEntity> findAll() throws SQLException {
    List<LibraryEntity> libraries = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          libraries.add((LibraryEntity) new Transformer(LibraryEntity.class)
              .fromResultSetToEntity(resultSet));
        }
      }
    }
    return libraries;
  }

  @Override
  public LibraryEntity findById(Integer id) throws SQLException {
    LibraryEntity entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
      ps.setInt(1, id);
      try (ResultSet resultSet = ps.executeQuery()) {
        while (resultSet.next()) {
          entity = (LibraryEntity) new Transformer(LibraryEntity.class)
              .fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(LibraryEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
      ps.setInt(1, entity.getId());
      ps.setString(2, entity.getName());
      ps.setInt(3, entity.getBooks());
      ps.setInt(4, entity.getMagazines());
      ps.setDouble(5, entity.getPopularity());
      ps.setInt(6, entity.getCityId());
      return ps.executeUpdate();
    }
  }

  @Override
  public int update(LibraryEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
      ps.setInt(1, entity.getId());
      ps.setString(2, entity.getName());
      ps.setInt(3, entity.getBooks());
      ps.setInt(4, entity.getMagazines());
      ps.setDouble(5, entity.getPopularity());
      ps.setInt(6, entity.getCityId());
      return ps.executeUpdate();
    }
  }

  @Override
  public int delete(Integer id) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
      ps.setInt(1, id);
      return ps.executeUpdate();
    }
  }

  @Override
  public List<LibraryEntity> findByName(String name) throws SQLException {
    return null;
  }

  @Override
  public List<LibraryEntity> findByCityNo(String cityNo) throws SQLException {
    return null;
  }
}

