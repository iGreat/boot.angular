package boot.service.impl;

import boot.domain.Student;
import boot.entity.StudentEntity;
import boot.respository.StudentRepository;
import boot.service.StudentService;
import boot.viewmodel.StudentSearch;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    private static Student convert(StudentEntity studentEntity) {
        ModelMapper modelMap = new ModelMapper();
        return modelMap.map(studentEntity, Student.class);
    }

    @Override
    public Page<Student> getAllStudents(StudentSearch studentSearch) {
        Pageable pageable = PageRequest.of(studentSearch.getPageIndex(), studentSearch.getPageSize());

        if (!StringUtils.hasText(studentSearch.getName()))
            return studentRepository.findAll(pageable)
                    .map(StudentServiceImpl::convert);
        else
            return studentRepository.findByNameContains(studentSearch.getName(), pageable)
                    .map(StudentServiceImpl::convert);
    }

    @Override
    public void saveStudent(Student student) {
        if (student.getId() == null) {
            StudentEntity studentEntity = new StudentEntity();
            studentEntity.setName(student.getName());
            studentEntity.setAge(student.getAge());
            studentEntity.setGender(student.getGender());
            studentRepository.save(studentEntity);
        } else {
            StudentEntity studentEntity = studentRepository.findById(student.getId()).orElse(null);
            if (studentEntity != null) {
                studentEntity.setName(student.getName());
                studentEntity.setAge(student.getAge());
                studentEntity.setGender(student.getGender());
                studentRepository.save(studentEntity);
            }
        }
    }
}
