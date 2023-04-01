package lk.ijse.d24.util;


import lk.ijse.d24.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class SessionFactoryConfiguration {
    private static SessionFactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Properties properties=new Properties();

        try{
            properties.load(ClassLoader.getSystemClassLoader().getResourceAsStream("d24hostel"));
        }catch (Exception e) {
            e.printStackTrace();
        }

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Student.class);
        sessionFactory=configuration.mergeProperties(properties).buildSessionFactory();

    }

    public static SessionFactoryConfiguration getInstance(){
        if (factoryConfiguration==null){
            factoryConfiguration=new SessionFactoryConfiguration();
        }
        return factoryConfiguration;
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
