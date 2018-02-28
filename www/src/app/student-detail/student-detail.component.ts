import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Student} from '../model/student';
import {StudentService} from '../service/student.service';
import {Gender, Genders} from '../model/gender';
import {OkResult} from '../model/okResult';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  student: Student;

  genders: Gender[];

  constructor(public dialogRef: MatDialogRef<StudentDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Student,
              public studentService: StudentService) {
  }

  ngOnInit() {
    this.genders = Genders;
    this.student = this.data;
  }

  close() {
    this.dialogRef.close();
  }

  saveStudent() {
    this.studentService.saveStudent(this.student)
      .subscribe((next: OkResult) => {
        if (next.success) {
          this.close();
        } else {
          alert('error:' + next.message);
        }
      });
  }

}
