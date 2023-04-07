package lk.ijse.d24.dao.custom.impl;

import lk.ijse.d24.dao.custom.StudentDAO;
import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

public class StudentDAOimpl implements StudentDAO {
    @Override
    public Student search(String id) {
        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Student student = session.get(Student.class,id);

        transaction.commit();;
        session.close();
        return null;
    }

    @Override
    public boolean add(Student entity) {


        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);

        transaction.commit();;
        session.close();
        return false;
    }

    @Override
    public boolean update(Student entity) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

     session.update(entity);

        transaction.commit();;
        session.close();

        return false;
    }

    @Override
    public boolean delete(String id) {

        Session session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

       Student entity = session.load(Student.class,id);

       session.delete(entity);

        transaction.commit();;
        session.close();

        return false;
    }
}
