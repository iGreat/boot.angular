import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  confirmQuit() {
    if (confirm('are you sure?')) {
      console.log('quit');
    }
  }
}
