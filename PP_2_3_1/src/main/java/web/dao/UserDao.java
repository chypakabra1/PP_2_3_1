package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao<T> {

    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
