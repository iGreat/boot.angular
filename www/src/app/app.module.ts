import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';


import {AppComponent} from './app.component';
import {StudentComponent} from './student/student.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {
  MatButtonModule, MatCardModule, MatGridListModule, MatIconModule, MatMenuModule, MatSidenavModule,
  MatToolbarModule
} from "@angular/material";
import { MenuComponent } from './menu/menu.component';
import {AppRouterModule} from "./app.router.module";


@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
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

    //route
    AppRouterModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
