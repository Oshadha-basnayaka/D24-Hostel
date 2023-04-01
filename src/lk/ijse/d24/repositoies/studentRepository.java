package lk.ijse.d24.repositoies;

import lk.ijse.d24.entity.Student;
import lk.ijse.d24.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class studentRepository {

    private Session session= SessionFactoryConfiguration.getInstance().getSession();
    private Transaction transaction;

public studentRepository (){}

    public boolean addStudent(Student student){
        transaction = session.beginTransaction();
        try {
            session.save(student);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
            e.printStackTrace();
        }
        return false;
    }

}
