package com.company.service;

import com.company.DAO.implementation.BookDaoImpl;
import java.sql.SQLException;
import java.util.List;
import com.company.model.BookEntity;

public class BookService {

  public List<BookEntity> findAll() throws SQLException {
    return new BookDaoImpl().findAll();
  }

  public BookEntity findById(String id) throws SQLException {
    return new BookDaoImpl().findById(id);
  }

  public int create(BookEntity entity) throws SQLException {
    return new BookDaoImpl().create(entity);
  }

  public int update(BookEntity entity) throws SQLException {
    return new BookDaoImpl().update(entity);
  }

  public int delete(String id) throws SQLException {
    return new BookDaoImpl().delete(id);
  }
}
