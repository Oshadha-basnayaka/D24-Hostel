package lk.ijse.d24.bo.custom;

import lk.ijse.d24.bo.SuperBO;
import lk.ijse.d24.dto.StudentDTO;

public interface StudentBO extends SuperBO {
    StudentDTO getStudent (String id);
    public boolean addStudent(StudentDTO studentDTO);
    public boolean updateStudent(StudentDTO studentDTO);
    public  boolean deleteStudent(String id);

}
