package com.company.DAO;

import com.company.model.LibraryEntity;
import java.sql.SQLException;
import java.util.List;

public interface LibraryDAO extends GeneralDAO<LibraryEntity, Integer> {

  List<LibraryEntity> findByName(String name) throws SQLException;

  List<LibraryEntity> findByCityNo(String cityNo) throws SQLException;
}
