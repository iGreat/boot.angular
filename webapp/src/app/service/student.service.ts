import {Inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {APP_CONFIG, IAppConfig} from '../app.config';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Student} from '../model/student';

@Injectable()
export class StudentService {

  constructor(@Inject(APP_CONFIG) private config: IAppConfig,
              private httpClient: HttpClient) {
  }

  getStudents(): Observable<any> {
    return this.httpClient.post(`${this.config.apiEndPoint}/student/list`, {})
      .map((r: Response) => r);
  }

  saveStudent(student: Student): Observable<any> {
    return this.httpClient.post(`${this.config.apiEndPoint}/student/save`, student)
      .map((r: Response) => r);
  }
}
