package lk.ijse.d24.bo;

import lk.ijse.d24.bo.custom.impl.ReservationBOimpl;
import lk.ijse.d24.bo.custom.impl.RoomBOimpl;
import lk.ijse.d24.bo.custom.impl.StudentBOimpl;
import lk.ijse.d24.bo.custom.impl.UserBOimpl;

public class BoFactory {
    private static BoFactory boFactory;

    private BoFactory() {
    }

    public static BoFactory getInstance() {
        return (boFactory == null)
                ? boFactory = new BoFactory()
                : boFactory;
    }

    public SuperBO getBO(BoType boType){
        switch (boType) {
            case USER:
                return new UserBOimpl();
            case STUDENT:
                return new StudentBOimpl();
            case ROOM:
                return new RoomBOimpl();
            case RESERVATION:
                return new ReservationBOimpl();
            default:
                System.out.println("Class not Found");
                return null;


        }
    }
}