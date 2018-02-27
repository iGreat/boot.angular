package boot.controller;

import boot.common.OkResult;
import boot.domain.Student;
import boot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/list")
    public List<Student> findAllStudents() {
        return studentService.getAllStudents();
    }

    @RequestMapping("/save")
    public OkResult saveStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
            return new OkResult(true, "");
        } catch (Exception e) {
            return new OkResult(false, e.getMessage());
        }
    }
}
