package lk.ijse.d24.bo.custom.impl;

import lk.ijse.d24.bo.SuperBO;
import lk.ijse.d24.bo.custom.StudentBO;
import lk.ijse.d24.dao.DaoFactory;
import lk.ijse.d24.dao.DaoType;
import lk.ijse.d24.dao.custom.StudentDAO;
import lk.ijse.d24.dto.StudentDTO;
import lk.ijse.d24.entity.Student;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class StudentBOimpl implements StudentBO {
    StudentDAO studentDAO = (StudentDAO) DaoFactory.getInstance().getDAO(DaoType.STUDENT);
    @Override
    public StudentDTO getStudent(String id) {
        Student student = studentDAO.search(id);
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getContact(),
                student.getAddress(),
                student.getDob(),
                student.getGender()
        );
    }

    @Override
    public boolean addStudent(StudentDTO studentDTO) {
        return studentDAO.add(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) {
        return studentDAO.update(new Student(
                studentDTO.getId(),
                studentDTO.getName(),
                studentDTO.getAddress(),
                studentDTO.getContact(),
                studentDTO.getDob(),
                studentDTO.getGender()
        ));
    }

    @Override
    public boolean deleteStudent(String id) {
        return studentDAO.delete(id);
    }

    @Override
    public ArrayList<StudentDTO> getAllStudent() {
        ArrayList<StudentDTO> studentDTOArrayList = new ArrayList<>();
        studentDTOArrayList.addAll(studentDAO.getAll().stream().map(student -> {return  new StudentDTO(
                student.getId(),
                student.getName(),
                student.getContact(),
                student.getAddress(),
                student.getDob(),
                student.getGender());
        }).collect(Collectors.toList()));
        return studentDTOArrayList;
    }

    @Override
    public String genarateStudentId() {
        return studentDAO.generateNewId();
    }
}
