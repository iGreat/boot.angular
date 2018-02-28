import {Component, OnInit} from '@angular/core';
import {MatDialog, PageEvent} from '@angular/material';
import {StudentDetailComponent} from '../student-detail/student-detail.component';
import {Student} from '../model/student';
import {StudentService} from '../service/student.service';
import {StudentSearch} from '../model/student-search';
import {Page} from '../model/page';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  searchText: string;
  pageEvent: PageEvent;

  displayedColumns = ['select', 'name', 'age', 'gender', 'editor'];
  dataSource: Student[];

  constructor(public dialog: MatDialog,
              public studentService: StudentService) {
  }

  ngOnInit() {
    this.pageEvent = {
      pageIndex: 0,
      pageSize: 10,
      length: 0
    };

    this.searchStudents();
  }

  searchStudents() {
    let studentSearch: StudentSearch = {
      name: this.searchText,
      pageIndex: this.pageEvent.pageIndex,
      pageSize: this.pageEvent.pageSize
    };

    this.studentService.getStudents(studentSearch).subscribe((value: Page<Student>) => {
      this.dataSource = value.content;
      this.pageEvent.length = value.totalElements;
    });
  }

  addStudent() {
    let dialogRef = this.dialog.open(StudentDetailComponent, {
      data: {}
    });

    dialogRef.afterClosed().subscribe((next: any) => {
      //refresh data
      this.searchStudents();
    });
  }

  editStudent(student: Student) {
    let dialogRef = this.dialog.open(StudentDetailComponent, {
      data: student
    });
  }

  pageChange(pageEvent: PageEvent) {
    this.pageEvent = pageEvent;
    this.searchStudents();
  }
}
