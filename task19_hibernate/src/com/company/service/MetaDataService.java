package com.company.service;

import com.company.DAO.implementation.MetaDataDaoImpl;
import com.company.model.metadata.TableMetaData;
import java.sql.SQLException;
import java.util.List;

public class MetaDataService {

  public List<String> findAllTableName() throws SQLException {
    return new MetaDataDaoImpl().findAllTableName();
  }

  public List<TableMetaData> getTablesStructure() throws SQLException {
    return new MetaDataDaoImpl().getTablesStructure();
  }

}
