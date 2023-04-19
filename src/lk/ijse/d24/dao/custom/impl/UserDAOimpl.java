package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.UserDAO;
import lk.ijse.d24.entity.User;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOimpl implements UserDAO {
    @Override
    public User search(String id) {


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        User user = session.get(User.class, id);

        transaction.commit();
        session.close();

        return user;
    }

    @Override
    public boolean add(User entity) {


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();;
        session.close();
        return true;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public List<User> getAll() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List userList = session.createQuery("FROM User ").list();

        transaction.commit();
        session.close();

        return userList;
    }
}
