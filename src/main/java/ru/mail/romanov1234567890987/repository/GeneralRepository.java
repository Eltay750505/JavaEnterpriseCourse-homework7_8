package ru.mail.romanov1234567890987.repository;

import ru.mail.romanov1234567890987.repository.model.User;
import ru.mail.romanov1234567890987.repository.model.UserInformation;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GeneralRepository<T> {
    T add(Connection connection, T t) throws SQLException;

    void deleteById(Connection connection, Serializable id) throws SQLException;

    /*T get(Connection connection, Serializable id) throws SQLException;

    void update(Connection connection, T t) throws SQLException;


    List<T> findAll(Connection connection) throws SQLException;*/
}
