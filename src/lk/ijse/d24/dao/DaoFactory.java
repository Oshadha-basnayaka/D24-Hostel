package lk.ijse.d24.dao;

import lk.ijse.d24.dao.custom.impl.ReservationDAOimpl;
import lk.ijse.d24.dao.custom.impl.RoomDAOimpl;
import lk.ijse.d24.dao.custom.impl.StudentDAOimpl;
import lk.ijse.d24.dao.custom.impl.UserDAOimpl;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory() {

    }

    public static DaoFactory getInstance() {
        return (daoFactory == null)
                ? daoFactory = new DaoFactory()
                : daoFactory;

    }

    public SuperDAO getDAO(DaoType daoType) {
        switch (daoType) {
            case USER:
                return new UserDAOimpl();
            case STUDENT:
                return new StudentDAOimpl();
            case ROOM:
                return new RoomDAOimpl();
            case RESERVATION:
                return new ReservationDAOimpl();
            default:
                System.out.println("NO DAOimpl");
                return null;


        }
    }

}
