package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.StudentDAO;
import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOimpl implements StudentDAO {
    @Override
    public Student search(String id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class, id);

        transaction.commit();
        ;
        session.close();
        return student;
    }

    @Override
    public boolean add(Student entity) {


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();
        ;
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        ;
        session.close();

        return true;
    }

    @Override
    public boolean delete(String id) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student entity = session.load(Student.class, id);

        session.delete(entity);

        transaction.commit();
        ;
        session.close();

        return true;
    }

    @Override
    public List<Student> getAll() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = session.createQuery("FROM Student ").list();


        transaction.commit();
        session.close();

        return list;
    }

    @Override
    public String generateNewId() {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT id FROM Student ORDER BY id DESC ");

        String newId = "S00 - 001";

        if (query.list().size() == 0) {
            return newId;
        } else {
            String genarateId = (String) query.list().get(0);

            String[] split = genarateId.split("S00 - 00");

            for (String i : split) {
                genarateId = i;
            }

            int genNumber = Integer.valueOf(genarateId);

            genarateId = "S00 - 00" + (genNumber + 1);

            transaction.commit();
            session.close();

            return genarateId;
        }
    }
}
