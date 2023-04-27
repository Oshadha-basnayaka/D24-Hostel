package lk.ijse.d24.dao.custom;

import lk.ijse.d24.dao.CrudDAO;
import lk.ijse.d24.dao.SuperDAO;
import lk.ijse.d24.entity.Room;

public interface RoomDAO extends CrudDAO<Room> {
    public int getRoomQTY(String id);
}
