package lk.ijse.d24.bo.custom.impl;

import lk.ijse.d24.bo.custom.ReservationBO;
import lk.ijse.d24.dao.DaoFactory;
import lk.ijse.d24.dao.DaoType;
import lk.ijse.d24.dao.custom.ReservationDAO;
import lk.ijse.d24.dao.custom.RoomDAO;
import lk.ijse.d24.dao.custom.StudentDAO;
import lk.ijse.d24.dto.ReservationDTO;
import lk.ijse.d24.entity.Reservation;
import lk.ijse.d24.entity.Room;
import lk.ijse.d24.entity.Student;

public class ReservationBOimpl implements ReservationBO {

    ReservationDAO reservationDAO = (ReservationDAO) DaoFactory.getInstance().getDAO(DaoType.RESERVATION);
    RoomDAO roomDAO = (RoomDAO) DaoFactory.getInstance().getDAO(DaoType.ROOM);
    StudentDAO studentDAO = (StudentDAO) DaoFactory.getInstance().getDAO(DaoType.STUDENT);
    @Override
    public ReservationDTO getReservation(String id) {
        Reservation reservation = reservationDAO.search(id);
        return  new ReservationDTO(
                reservation.getId(),
                reservation.getDate(),
                reservation.getStatus(),
                reservation.getStudent().getId(),
                reservation.getRoom().getId()
        );
    }

    @Override
    public boolean addReservation(ReservationDTO reservationDTO) {

        Student student = studentDAO.search(reservationDTO.getReservationStudentId());
        Room room = roomDAO.search(reservationDTO.getReservationRoomId());

        return reservationDAO.add(new Reservation(
                reservationDTO.getId(),
                reservationDTO.getDate(),
                reservationDTO.getStatus(),
                student,
                room
        ));
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) {

        Student student = studentDAO.search(reservationDTO.getReservationStudentId());
        Room room = roomDAO.search(reservationDTO.getReservationRoomId());

        return reservationDAO.update(new Reservation(
                reservationDTO.getId(),
                reservationDTO.getDate(),
                reservationDTO.getStatus(),
                student,
                room
        ));

    }

    @Override
    public boolean deleteReservation(String id) {
      return  reservationDAO.delete(id);
    }
}
