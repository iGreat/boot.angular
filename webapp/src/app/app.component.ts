import {Component, Inject, OnInit} from '@angular/core';
import {APP_CONFIG, IAppConfig} from './app.config';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  constructor(@Inject(APP_CONFIG) public config: IAppConfig) {
  }

  ngOnInit() {
  }
}
