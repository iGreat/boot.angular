import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Student} from '../model/student';
import {Observable} from 'rxjs/Observable';
import {OkResult} from '../model/okResult';

@Injectable()
export class StudentService {

  constructor(private httpClient: HttpClient) {
  }

  saveStudent(student: Student): Observable<OkResult> {
    return this.httpClient.post<OkResult>('/student/save', student);
  }

  getStudents(): Observable<Student[]> {
    return this.httpClient.post<Student[]>('/student/list', {});
  }
}
