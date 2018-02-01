package boot.service;

import boot.domain.Student;

import java.util.List;

public interface StudentService {
    String testToUpper(String in) throws InterruptedException;

    List<Student> getAllStudents();

}
