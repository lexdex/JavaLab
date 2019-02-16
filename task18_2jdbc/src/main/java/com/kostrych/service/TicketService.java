package com.kostrych.service;

import com.kostrych.DAO.implementation.TicketDaoImpl;
import com.kostrych.model.TicketEntity;

import java.sql.SQLException;
import java.util.List;

public class TicketService {
    public List<TicketEntity> findAll() throws SQLException {
        return new TicketDaoImpl().findAll();
    }

    public TicketEntity findById(Integer id) throws SQLException {
        return new TicketDaoImpl().findById(id);
    }

    public int create(TicketEntity entity) throws SQLException {
        return new TicketDaoImpl().create(entity);
    }

    public int update(TicketEntity entity) throws SQLException {
        return new TicketDaoImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TicketDaoImpl().delete(id);
    }

    public List<TicketEntity> findByName(String name) throws SQLException {
        return new TicketDaoImpl().findByName(name);
    }
}
