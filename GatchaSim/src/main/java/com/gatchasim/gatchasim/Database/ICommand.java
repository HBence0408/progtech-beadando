package com.gatchasim.gatchasim.Database;

import java.sql.SQLException;

public interface ICommand {
    void execute() throws SQLException;
}
