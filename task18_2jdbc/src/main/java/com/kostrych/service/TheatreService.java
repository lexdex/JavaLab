package com.kostrych.service;

import com.kostrych.DAO.implementation.*;
import com.kostrych.model.*;
import com.kostrych.persistant.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class TheatreService {

    public List<TheatreEntity> findAll() throws SQLException {
        return new TheatreDaoImpl().findAll();
    }

    public TheatreEntity findById(String id) throws SQLException {
        return new TheatreDaoImpl().findById(id);
    }

    public int create(TheatreEntity entity) throws SQLException {
        return new TheatreDaoImpl().create(entity);
    }

    public int update(TheatreEntity entity) throws SQLException {
        return new TheatreDaoImpl().update(entity);
    }

    public int delete(String id) throws SQLException {
        return new TheatreDaoImpl().delete(id);
    }
}
