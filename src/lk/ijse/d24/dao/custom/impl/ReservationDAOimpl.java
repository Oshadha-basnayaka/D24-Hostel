package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.ReservationDAO;
import lk.ijse.d24.entity.Reservation;
import lk.ijse.d24.entity.Room;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ReservationDAOimpl implements ReservationDAO {
    @Override
    public Reservation search(String id)
    {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Reservation reservation = session.get(Reservation.class,id);

        transaction.commit();
        session.close();

        return reservation;
    }

    @Override
    public boolean add(Reservation entity) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        session.close();
        return true;

    }

    @Override
    public boolean update(Reservation entity) {
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

        Reservation entity  = session.load(Reservation.class,id);

        session.delete(entity);

        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public List<Reservation> getAll() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Reservation> reservation = session.createQuery("FROM Reservation ").list();


        transaction.commit();
        session.close();

        return reservation;
    }
}
