import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Student} from '../model/student';
import {Observable} from 'rxjs/Observable';
import {OkResult} from '../model/okResult';
import {StudentSearch} from '../model/student-search';
import {Page} from '../model/page';

@Injectable()
export class StudentService {

  constructor(private httpClient: HttpClient) {
  }

  saveStudent(student: Student): Observable<OkResult> {
    return this.httpClient.post<OkResult>('/student/save', student);
  }

  getStudents(studentSearch: StudentSearch): Observable<Page<Student>> {
    return this.httpClient.post<Page<Student>>('/student/list', studentSearch);
  }
}
