import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {StudentListComponent} from './student-list/student-list.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {APP_CONFIG, AppConfig} from './app.config';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {StudentService} from './service/student.service';


@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    StudentDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    {provide: APP_CONFIG, useValue: AppConfig},

    /**
     * services start
     */
    StudentService
    /**
     * service end
     */
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
