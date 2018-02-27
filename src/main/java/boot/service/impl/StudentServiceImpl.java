package boot.service.impl;

import boot.domain.Student;
import boot.entity.StudentEntity;
import boot.respository.StudentRepository;
import boot.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private static Student convert(StudentEntity studentEntity) {
        ModelMapper modelMap = new ModelMapper();
        Student student = modelMap.map(studentEntity, Student.class);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(t -> convert(t))
                .collect(Collectors.toList());
    }

    @Override
    public String testToUpper(String in) throws InterruptedException {
        Thread.sleep(3000L);
        return in.toUpperCase();
    }

    @Override
    public void saveStudent(Student student) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(UUID.randomUUID());
        studentEntity.setName(student.getName());
        studentEntity.setAge(student.getAge());
        studentEntity.setGender(student.getGender());

        studentRepository.save(studentEntity);
    }
}
