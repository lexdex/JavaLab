package com.company.service;

import com.company.DAO.implementation.CityDaoImpl;
import com.company.model.CityEntity;
import java.sql.SQLException;
import java.util.List;

public class CityService {

  public List<CityEntity> findAll() throws SQLException {
    return new CityDaoImpl().findAll();
  }

  public CityEntity findById(String id) throws SQLException {
    return new CityDaoImpl().findById(id);
  }

  public int create(CityEntity entity) throws SQLException {
    return new CityDaoImpl().create(entity);
  }

  public int update(CityEntity entity) throws SQLException {
    return new CityDaoImpl().update(entity);
  }

  public int delete(String id) throws SQLException {
    return new CityDaoImpl().delete(id);
  }

}
