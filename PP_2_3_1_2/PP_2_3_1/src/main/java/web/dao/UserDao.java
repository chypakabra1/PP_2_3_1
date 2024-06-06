package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao<T> {

    Optional<User> get(long id);
    List<User> getAll();
    void save(T t);
    void update(T t, String[] params);
    void delete(T t);
}
