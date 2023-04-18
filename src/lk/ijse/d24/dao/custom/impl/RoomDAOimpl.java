package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.RoomDAO;
import lk.ijse.d24.entity.Room;
import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RoomDAOimpl implements RoomDAO {
    @Override
    public Room search(String id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room room = session.get(Room.class,id);

        transaction.commit();
        session.close();
        return room;
    }

    @Override
    public boolean add(Room entity) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

       session.save(entity);

        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Room entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Room entity = session.load(Room.class,id);

        session.delete(entity);

        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Room> getAll() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Room> room = session.createQuery("FROM Room ").list();


        transaction.commit();
        session.close();

        return room;
    }
}
