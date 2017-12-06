import {Component, OnInit} from '@angular/core';
import {Student} from '../model/student';
import {StudentService} from '../service/student.service';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  studentList: Student[];

  selectedStudent: Student;

  constructor(private studentService: StudentService) {
  }

  ngOnInit() {
    this.studentService.getStudents()
      .subscribe(p => {
        this.studentList = p;
      });
  }

  newStudent() {
    this.selectedStudent = new Student();
  }

  selectStudent(student: Student): void {
    this.selectedStudent = student;
  }
}
