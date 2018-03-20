package boot.controller;

import boot.common.OkResult;
import boot.domain.Student;
import boot.service.StudentService;
import boot.viewmodel.StudentSearch;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/list")
    public Page<Student> findAllStudents(@RequestBody StudentSearch studentSearch) {
        return studentService.getAllStudents(studentSearch);
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
