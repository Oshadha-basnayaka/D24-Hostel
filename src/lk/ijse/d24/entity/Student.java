package lk.ijse.d24.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Student {
    @Id
    @Column(name = "s_id",length = 50)
    private String id;
    @Column(name = "s_name",length = 50)
    private String name;
    @Column(name = "s_contact",length = 50)
    private int contact;
    @Column(name = "s_address",length = 50)
    private String address;
    @Column(name = "s_dob",length = 50)
    private Date dob;
    @Column(name = "s_gender",length = 50)
    private String gender;

    public Student() {
    }

    public Student(String id, String name, int contact, String address, Date dob, String gender) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.address = address;
        this.dob = dob;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}
