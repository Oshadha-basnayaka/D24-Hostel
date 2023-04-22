package lk.ijse.d24.bo.custom;

import lk.ijse.d24.bo.SuperBO;
import lk.ijse.d24.dto.ReservationDTO;
import lk.ijse.d24.dto.StudentDTO;

import java.util.ArrayList;

public interface ReservationBO extends SuperBO {

    ReservationDTO getReservation(String id);
    public boolean addReservation(ReservationDTO reservationDTO);
    public boolean updateReservation(ReservationDTO reservationDTO);
    public boolean deleteReservation(String id);

    ArrayList<ReservationDTO> getAllReservation();
    public String genarateReservationId();

    public ArrayList<StudentDTO> getNotPayStudent();

}
