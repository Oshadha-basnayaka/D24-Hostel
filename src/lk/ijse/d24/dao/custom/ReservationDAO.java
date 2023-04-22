package lk.ijse.d24.dao.custom;

import lk.ijse.d24.dao.CrudDAO;
import lk.ijse.d24.dao.SuperDAO;
import lk.ijse.d24.entity.Reservation;
import lk.ijse.d24.entity.Student;

import java.util.List;

public interface ReservationDAO extends CrudDAO<Reservation> {


    public List<Student> getKeyMoneyNotPaid();
}
