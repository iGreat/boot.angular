import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Confirm} from '../model/confirm';

@Component({
  selector: 'app-confirm-dlg',
  templateUrl: './confirm-dlg.component.html',
  styleUrls: ['./confirm-dlg.component.css']
})
export class ConfirmDlgComponent implements OnInit {
  private confirmMsg: Confirm;

  constructor(public dlgRef: MatDialogRef<ConfirmDlgComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Confirm) {
  }

  ngOnInit() {
    this.confirmMsg = {title: 'Confirm', content: 'Are you sure?'};

    if (this.data !== null) {
      this.confirmMsg = this.data;
      if (this.confirmMsg.title === null) {
        this.confirmMsg.title = 'Confirm';
      }
      if (this.confirmMsg.content === null) {
        this.confirmMsg.content = 'Are you sure?';
      }
    }
  }

}
