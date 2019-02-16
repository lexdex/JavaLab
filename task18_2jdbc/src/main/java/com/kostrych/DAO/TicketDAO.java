package com.kostrych.DAO;

import com.kostrych.model.TicketEntity;

import java.sql.SQLException;
import java.util.List;

public interface TicketDAO extends GeneralDAO<TicketEntity, Integer> {
   List<TicketEntity> findByName(String name) throws SQLException;
}
