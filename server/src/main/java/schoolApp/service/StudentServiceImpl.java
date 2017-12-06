package schoolApp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schoolApp.domain.StudentDto;
import schoolApp.entity.Student;
import schoolApp.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setGender(studentDto.getGender());

        studentRepository.save(student);
    }

    @Override
    public List<StudentDto> findAllStudents() {
        List<StudentDto> studentDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Student student : studentRepository.findAll()) {
            studentDtoList.add(modelMapper.map(student, StudentDto.class));
        }
        return studentDtoList;
    }
}
