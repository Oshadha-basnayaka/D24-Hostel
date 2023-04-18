package lk.ijse.d24.bo.custom;

import lk.ijse.d24.bo.SuperBO;
import lk.ijse.d24.dto.StudentDTO;

import java.util.ArrayList;

public interface StudentBO extends SuperBO {
    StudentDTO getStudent (String id);
    public boolean addStudent(StudentDTO studentDTO);
    public boolean updateStudent(StudentDTO studentDTO);
    public  boolean deleteStudent(String id);

    ArrayList<StudentDTO> getAllStudent();

}
