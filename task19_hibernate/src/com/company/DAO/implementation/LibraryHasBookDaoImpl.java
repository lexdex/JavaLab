package com.company.DAO.implementation;

import com.company.DAO.HasDAO;
import com.company.model.LibraryHasBookEntity;
import com.company.persistant.ConnectionManager;
import com.company.transformer.Transformer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LibraryHasBookDaoImpl implements HasDAO {

  private static final String FIND_ALL = "SELECT * FROM library_has_book";
  private static final String CREATE = "INSERT library_has_book (library_id, book_id) VALUES (?, ?)";

  @Override
  public List<LibraryHasBookEntity> findAll() throws SQLException {
    List<LibraryHasBookEntity> has = new ArrayList<>();
    Connection connection = ConnectionManager.getConnection();
    try (Statement statement = connection.createStatement()) {
      try (ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
        while (resultSet.next()) {
          has.add((LibraryHasBookEntity) new Transformer(LibraryHasBookEntity.class)
              .fromResultSetToEntity(resultSet));
        }
      }
    }
    return has;
  }

  @Override
  public LibraryHasBookEntity findById(LibraryHasBookEntity pk_hasA) throws SQLException {
    return null;
  }

  @Override
  public int create(LibraryHasBookEntity entity) throws SQLException {
    Connection conn = ConnectionManager.getConnection();
    try (PreparedStatement ps = conn.prepareStatement(CREATE)) {
      ps.setInt(1, entity.getBookId());
      ps.setInt(2, entity.getLibraryId());
      return ps.executeUpdate();
    }
  }

  @Override
  public int update(LibraryHasBookEntity entity) throws SQLException {
    return 0;
  }

  @Override
  public int delete(LibraryHasBookEntity libraryHasBook) throws SQLException {
    return 0;
  }

}
