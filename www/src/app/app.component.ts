import {Component} from '@angular/core';
import {MatDialog} from '@angular/material';
import {ConfirmDlgComponent} from './confirm-dlg/confirm-dlg.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  constructor(public confirmDialog: MatDialog) {
  }

  confirmQuit() {
    let dialogRef = this.confirmDialog.open(ConfirmDlgComponent, {
      position: {top: '1em'}
    });

    dialogRef.afterClosed().subscribe((p: boolean) => {
      if (p) {
        alert('quit success');
      }
    });
  }
}
