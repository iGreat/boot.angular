package boot.service.impl;

import boot.domain.Student;
import boot.service.StudentService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public List<Student> getAllStudents() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String testToUpper(String in) throws InterruptedException {
        Thread.sleep(3000L);
        return in.toUpperCase();
    }
}
