import {Component, OnInit, ViewChild} from '@angular/core';
import {Student} from '../model/student';
import {StudentService} from '../service/student.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {
  dataSource: any;

  selectedStudent: Student;

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private studentService: StudentService) {
  }

  ngOnInit() {
    this.studentService.getStudents()
      .subscribe(p => {
        this.dataSource = new MatTableDataSource<Student>(p);
        this.dataSource.paginator = this.paginator;
      });
  }

  newStudent() {
    this.selectedStudent = new Student();
  }

  selectStudent(student: Student): void {
    this.selectedStudent = student;
  }
}
