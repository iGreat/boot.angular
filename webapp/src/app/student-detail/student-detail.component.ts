import {Component, Input, OnInit} from '@angular/core';
import {Student} from '../model/student';
import {StudentService} from '../service/student.service';

@Component({
  selector: 'app-student-detail',
  templateUrl: './student-detail.component.html',
  styleUrls: ['./student-detail.component.css']
})
export class StudentDetailComponent implements OnInit {
  @Input()
  student: Student;

  genders: string[] = ['Male', 'Female'];

  constructor(private studentService: StudentService) {
  }

  ngOnInit() {
  }

  saveStudent() {
    this.studentService.saveStudent(this.student)
      .subscribe(r => {
        if (r.success) {
          alert('save success');
          window.location.reload();
        } else {
          alert(`save error: ${r.message}`);
        }
      });
  }

}
