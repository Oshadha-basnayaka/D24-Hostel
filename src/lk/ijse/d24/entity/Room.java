package lk.ijse.d24.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Room {
    @Id
    @Column(name = "r_id", length = 50, nullable = false)
    private String id;
    @Column(name = "r_type", length = 50)
    private String roomType;
    @Column(name = "r_keyMoney", length = 50)
    private String keyMoney;
    @Column(name = "r_qty", length = 50)
    private int qty;

    public Room(String id, String roomType, String keyMoney, int qty) {
        this.id = id;
        this.roomType = roomType;
        this.keyMoney = keyMoney;
        this.qty = qty;
    }

    @OneToMany(mappedBy =  "room")
    private List<Reservation> reservations = new ArrayList<>();
}
