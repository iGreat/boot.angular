package boot.service;

import boot.domain.Student;
import boot.viewmodel.StudentSearch;
import org.springframework.data.domain.Page;

public interface StudentService {
    Page<Student> getAllStudents(StudentSearch studentSearch);

    void saveStudent(Student student);
}
