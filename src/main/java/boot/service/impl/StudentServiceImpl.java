package boot.service.impl;

import boot.domain.Student;
import boot.entity.StudentEntity;
import boot.respository.StudentRepository;
import boot.service.StudentService;
import boot.viewmodel.StudentSearch;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.UUID;

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
    public Page<Student> getAllStudents(StudentSearch studentSearch) {
        Pageable pageable = new PageRequest(studentSearch.getPageIndex(), studentSearch.getPageSize());

        if (!StringUtils.hasText(studentSearch.getName()))
            return studentRepository.findAll(pageable)
                    .map(StudentServiceImpl::convert);
        else
            return studentRepository.findByNameContains(studentSearch.getName(), pageable)
                    .map(StudentServiceImpl::convert);
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
