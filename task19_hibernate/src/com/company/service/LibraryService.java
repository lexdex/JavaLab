package com.company.service;

import com.company.DAO.implementation.LibraryDaoImpl;
import com.company.model.LibraryEntity;
import java.sql.SQLException;
import java.util.List;

public class LibraryService {

  public List<LibraryEntity> findAll() throws SQLException {
    return new LibraryDaoImpl().findAll();
  }

  public LibraryEntity findById(Integer id) throws SQLException {
    return new LibraryDaoImpl().findById(id);
  }

  public int create(LibraryEntity entity) throws SQLException {
    return new LibraryDaoImpl().create(entity);
  }

  public int update(LibraryEntity entity) throws SQLException {
    return new LibraryDaoImpl().update(entity);
  }

  public int delete(Integer id) throws SQLException {
    return new LibraryDaoImpl().delete(id);
  }
}
