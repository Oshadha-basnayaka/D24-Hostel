package lk.ijse.d24.bo.custom;

import lk.ijse.d24.bo.SuperBO;
import lk.ijse.d24.dto.RoomDTO;

import java.util.ArrayList;

public interface RoomBO extends SuperBO {

    RoomDTO getRoom(String id);
    public  boolean addRoom(RoomDTO roomDTO);
    public boolean updateRoom(RoomDTO roomDTO);
    public boolean deleteRoom(String id);

    ArrayList<RoomDTO> getAllRooms();
}
