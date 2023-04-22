package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.RoomDAO;
import lk.ijse.d24.entity.Room;
import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    @Override
    public String generateNewId() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM Room ORDER BY id DESC ");

        String newId = "R00 - 001";

        if (query.list().size() == 0) {
            return newId;
        } else {
            String genarateId = (String) query.list().get(0);

            String[] split = genarateId.split("R00 - 00");

            for (String i : split) {
                genarateId = i;
            }

            int genNumber = Integer.valueOf(genarateId);

            genarateId = "R00 - 00" + (genNumber + 1);

            transaction.commit();
            session.close();

            return genarateId;
        }
    }
}
