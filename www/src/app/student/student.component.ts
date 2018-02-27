import {Component, OnInit} from '@angular/core';
import {MatDialog} from '@angular/material';
import {StudentDetailComponent} from '../student-detail/student-detail.component';
import {Student} from '../model/student';
import {StudentService} from '../service/student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  displayedColumns = ['name', 'age', 'gender'];
  dataSource: Student[];

  constructor(public dialog: MatDialog,
              public studentService: StudentService) {
  }

  ngOnInit() {
    this.studentService.getStudents().subscribe((value: Student[]) => {
      this.dataSource = value;
    });
  }


  addStudent() {
    let dialogRef = this.dialog.open(StudentDetailComponent, {
      data: new Student()
    });

    dialogRef.afterClosed().subscribe((next: any) => {
      //refresh data
    });
  }

}
