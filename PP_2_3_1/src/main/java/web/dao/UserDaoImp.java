package web.dao;

import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;


public class UserDaoImp implements UserDao<User> {
    /*@PersistenceContext
    private EntityManager em;

    public User update (User transientUser) {
        return em.merge(transientUser);
    }*/
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(em.find(User.class, id));
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("select e from User e").getResultList();
    }

    @Override
    public void save(User user) {
        executeInsideTransaction(em -> em.persist(user));
    }

    @Override
    public void update(User user, String[] params) {
        user.setName(Objects.requireNonNull(params[0], "Name cannot be null"));
        user.setEmail(Objects.requireNonNull(params[1], "Email cannot be null"));
        executeInsideTransaction(em -> em.merge(user));
    }

    @Override
    public void delete(User user) {
        executeInsideTransaction(em -> em.remove(user));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            action.accept(em);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }

}
