import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {StudentComponent} from './student/student.component';
import {FormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatDialogModule,
  MatExpansionModule,
  MatFormFieldModule,
  MatGridListModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatPaginatorModule,
  MatSelectModule,
  MatSidenavModule,
  MatSortModule,
  MatTableModule,
  MatToolbarModule
} from '@angular/material';
import {MenuComponent} from './menu/menu.component';
import {AppRouterModule} from './app-router.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {TeacherComponent} from './teacher/teacher.component';
import {BookComponent} from './book/book.component';
import {StudentDetailComponent} from './student-detail/student-detail.component';
import {StudentService} from './service/student.service';
import {AppHttpInterceptor} from './app-http-interceptor';
import {ConfirmDlgComponent} from './confirm-dlg/confirm-dlg.component';


@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    MenuComponent,
    TeacherComponent,
    BookComponent,
    StudentDetailComponent,
    ConfirmDlgComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,

    //material module
    MatButtonModule,
    MatGridListModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatSidenavModule,
    MatCardModule,
    MatExpansionModule,
    MatListModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatInputModule,
    MatCheckboxModule,
    MatFormFieldModule,
    MatDialogModule,
    MatSelectModule,

    //route
    AppRouterModule
  ],

  entryComponents: [
    ConfirmDlgComponent,
    StudentDetailComponent
  ],

  providers: [
    {provide: HTTP_INTERCEPTORS, useClass: AppHttpInterceptor, multi: true},

    //app service
    StudentService
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
