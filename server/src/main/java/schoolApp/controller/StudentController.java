package schoolApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schoolApp.common.config.StatusCode;
import schoolApp.domain.StudentDto;
import schoolApp.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/save")
    public StatusCode saveStudent(@RequestBody StudentDto studentDto) {
        try {
            studentService.saveStudent(studentDto);
            return new StatusCode(true);
        } catch (Exception e) {
            return new StatusCode(false, e.getMessage());
        }
    }

    @RequestMapping("/list")
    public List<StudentDto> getStudents() {
        return studentService.findAllStudents();
    }
}
