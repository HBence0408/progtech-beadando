package com.gatchasim.gatchasim.Database;

import java.sql.SQLException;

public interface IQueryCommand<T> {
    T execute() throws SQLException;
}
