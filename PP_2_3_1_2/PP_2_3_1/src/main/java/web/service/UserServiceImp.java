package web.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//@Service
@Component
public class UserServiceImp /*implements UserService*/ {
    public static int USERS;
    /*@Override
    public List<User> users(Integer count) {
        List<User> users = new ArrayList<>();
        {

            users.add(new User(++USERS, "User1", "Lastname1", "user1@mail.ru"));
            users.add(new User(++USERS, "User2", "Lastname2", "user2@mail.ru"));
            users.add(new User(++USERS, "User3", "Lastname3", "user3@mail.ru"));
            users.add(new User(++USERS, "User4", "Lastname4", "user4@mail.ru"));
            users.add(new User(++USERS, "User5", "Lastname5", "user5@mail.ru"));
        }
        return users.stream().limit(count).collect(Collectors.toList());
    }*/

    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++USERS, "User1", "Lastname1", "user1@mail.ru"));
        users.add(new User(++USERS, "User2", "Lastname2", "user2@mail.ru"));
        users.add(new User(++USERS, "User3", "Lastname3", "user3@mail.ru"));
        users.add(new User(++USERS, "User4", "Lastname4", "user4@mail.ru"));
        users.add(new User(++USERS, "User5", "Lastname5", "user5@mail.ru"));
    }

    public List<User> index() {
        return users;
    }

    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    public void save(User user) {
        user.setId(++USERS);
        users.add(user);
    }

    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastname(updatedUser.getLastname());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
