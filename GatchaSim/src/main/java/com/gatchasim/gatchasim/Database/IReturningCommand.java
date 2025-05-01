package com.gatchasim.gatchasim.Database;

public interface IReturningCommand<T> {
    T execute() throws Exception;
}
