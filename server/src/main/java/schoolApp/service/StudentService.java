package schoolApp.service;

import schoolApp.domain.StudentDto;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDto studentDto);

    List<StudentDto> findAllStudents();
}
