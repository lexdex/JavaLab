package com.company.service;

import com.company.DAO.implementation.LibraryHasBookDaoImpl;
import com.company.model.LibraryHasBookEntity;
import java.sql.SQLException;
import java.util.List;

public class LibraryHasBookService {

  public List<LibraryHasBookEntity> findAll() throws SQLException {
    return new LibraryHasBookDaoImpl().findAll();
  }

  public int create(LibraryHasBookEntity entity) throws SQLException {
    return new LibraryHasBookDaoImpl().create(entity);
  }

  public int update(LibraryHasBookEntity entity) throws SQLException {
    return new LibraryHasBookDaoImpl().update(entity);
  }

  public int delete(LibraryHasBookEntity pk) throws SQLException {
    return new LibraryHasBookDaoImpl().delete(pk);
  }
}
