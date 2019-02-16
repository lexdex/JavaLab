package com.company.DAO.implementation;

import com.company.DAO.CityDAO;
import com.company.model.CityEntity;
import com.company.persistant.ConnectionManager;
import com.company.transformer.Transformer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CityDaoImpl implements CityDAO {

  private static final String FIND_ALL = "SELECT * FROM city";
  private static final String DELETE = "DELETE FROM city WHERE id=?";
  private static final String CREATE = "INSERT city (id, name) VALUES (?, ?)";
  private static final String UPDATE = "UPDATE city SET id=? WHERE name=?";
  private static final String FIND_BY_ID = "SELECT * FROM city WHERE id=?";


  @Override
  public List<CityEntity> findAll() throws SQLException {
    List<CityEntity> cities = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          cities
              .add((CityEntity) new Transformer(CityEntity.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return cities;
  }

  @Override
  public CityEntity findById(String id) throws SQLException {
    CityEntity entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
      ps.setString(1, id);
      try (ResultSet resultSet = ps.executeQuery()) {
        while (resultSet.next()) {
          entity = (CityEntity) new Transformer(CityEntity.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(CityEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
      ps.setInt(1, entity.getId());
      ps.setString(2, entity.getName());
      return ps.executeUpdate();
    }
  }

  @Override
  public int update(CityEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
      ps.setInt(1, entity.getId());
      ps.setString(3, entity.getName());
      return ps.executeUpdate();
    }
  }

  @Override
  public int delete(String id) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(DELETE)) {
      ps.setString(1, id);
      return ps.executeUpdate();
    }
  }

}
