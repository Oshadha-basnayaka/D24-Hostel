package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.UserDAO;
import lk.ijse.d24.entity.User;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    @Override
    public String generateNewId() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT name FROM User ORDER BY name DESC ");

        String newId = "U00-001";

        if (query.list().size() == 0) {
            return newId;
        }else {
            String genarateId = (String) query.list().get(0);

            String[] split = genarateId.split("U00-00");

            for (String i:split) {
                genarateId = i;
            }

            int genNumber = Integer.valueOf(genarateId);

            genarateId = "U00-00" + (genNumber + 1);

            transaction.commit();
            session.close();

            return null;
        }

        }
    }

