package com.company.DAO.implementation;

import com.company.DAO.BookDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.company.model.BookEntity;
import com.company.persistant.ConnectionManager;
import com.company.transformer.Transformer;

public class BookDaoImpl implements BookDAO {

  private static final String FIND_ALL = "SELECT * FROM book";
  private static final String DELETE = "DELETE FROM book WHERE id=?";
  private static final String CREATE = "INSERT book (id, name_author, published, imdb_id) VALUES (?, ?, ?, ?)";
  private static final String UPDATE = "UPDATE book SET name_author=?, published=?, imdb_id=? WHERE id=?";
  private static final String FIND_BY_ID = "SELECT * FROM book WHERE id=?";


  @Override
  public List<BookEntity> findAll() throws SQLException {
    List<BookEntity> books = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          books
              .add((BookEntity) new Transformer(BookEntity.class).fromResultSetToEntity(resultSet));
        }
      }
    }
    return books;
  }

  @Override
  public BookEntity findById(String id) throws SQLException {
    BookEntity entity = null;
    Connection connection = ConnectionManager.getConnection();
    try (PreparedStatement ps = connection.prepareStatement(FIND_BY_ID)) {
      ps.setString(1, id);
      try (ResultSet resultSet = ps.executeQuery()) {
        while (resultSet.next()) {
          entity = (BookEntity) new Transformer(BookEntity.class).fromResultSetToEntity(resultSet);
          break;
        }
      }
    }
    return entity;
  }

  @Override
  public int create(BookEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
      ps.setInt(1, entity.getId());
      ps.setString(2, entity.getNameAuthor());
      ps.setString(3, entity.getPublished());
      ps.setInt(4, entity.getImdbId());
      return ps.executeUpdate();
    }
  }

  @Override
  public int update(BookEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
      ps.setInt(1, entity.getId());
      ps.setString(2, entity.getNameAuthor());
      ps.setString(3, entity.getPublished());
      ps.setInt(4, entity.getImdbId());
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
