import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {Student} from "../model/student";

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  student: Student;

  genders: [{ name: 'Male', value: 1 }, { name: 'Female', value: 2 }];

  constructor(public dialogRef: MatDialogRef<StudentDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) {
  }

  ngOnInit() {
    if (this.data == null) {
      this.student = new Student();
    }
  }

  close() {
    this.dialogRef.close();
  }

}
