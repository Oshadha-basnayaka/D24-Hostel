package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.ReservationDAO;
import lk.ijse.d24.entity.Reservation;
import lk.ijse.d24.entity.Room;
import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

    @Override
    public String generateNewId() {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM Reservation ORDER BY id DESC ");

        String newId = "RES00-001";

        if (query.list().size() == 0) {
            return newId;
        } else {
            String genarateId = (String) query.list().get(0);

            String[] split = genarateId.split("RES00-00");

            for (String i : split) {
                genarateId = i;
            }

            int genNumber = Integer.valueOf(genarateId);

            genarateId = "RES00-00" + (genNumber + 1);

            transaction.commit();
            session.close();

            return genarateId;
        }

    }

    @Override
    public List<Student> getKeyMoneyNotPaid() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> notPaylist = session.createQuery("SELECT student FROM Reservation WHERE status LIKE : ID").setParameter("ID", "notpaid").list();

        transaction.commit();
        session.close();

        return notPaylist;
    }
}
