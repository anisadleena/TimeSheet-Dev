import { CommonModule } from "@angular/common";
import { Component, Inject } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatNativeDateModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { MatTableModule } from "@angular/material/table";

export interface User {
  user_id: number;
  username: string;
  email: string;
}

export interface Status {
  status_id: number;
  status_name: string;
}

@Component({
  selector: 'modal-create',
  templateUrl: 'modal-create.component.html',
  standalone: true,
  imports: [MatIconModule, MatFormFieldModule, FormsModule, MatInputModule,CommonModule, MatButtonModule, MatTableModule, MatDatepickerModule, CommonModule,MatNativeDateModule, MatSelectModule],
  providers: [],

})
export class ModalCreateComponent {
  selectedDate: Date;
  selectedUserId: number = 0;
  selectedStatusId: number = 0;

  dummyStatus : Status[]= [
    {
      status_id: 1,
      status_name: 'Open',
    },
    {
      status_id: 2,
      status_name: 'In Progress',
    },
    {
      status_id: 3,
      status_name: 'Closed',
    }
  ]

  dummyUser : User[] = [
    {
      user_id: 1,
      username: 'anisadleena',
      email: 'anisadleena@test.com'
    },
    {
      user_id: 2,
      username: 'mikoo',
      email: 'mikoo123@test.com'
    },
    {
      user_id: 1,
      username: 'Ashley',
      email: 'princessAshley@test.com'
    },
    {
      user_id: 1,
      username: 'Ayengg',
      email: 'ayengg22@test.com'
    }
  ]

  constructor(public _dialogRef: MatDialogRef<ModalCreateComponent>) {
    this.selectedDate = new Date();
    
  }
    
      ngOnInit() {
        
      }
    

  close(): void {
    this._dialogRef.close();
  }
}
