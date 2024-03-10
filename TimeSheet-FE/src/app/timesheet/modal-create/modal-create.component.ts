import { CommonModule } from "@angular/common";
import { Component, Inject } from "@angular/core";
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatNativeDateModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import {  MatDialogRef } from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { MatTableModule } from "@angular/material/table";
import { StatusService } from "src/app/services/status.service";
import { TimeSheetService } from "src/app/services/timesheet.service";
import { Status, User } from "src/app/services/timesheet.type";
import { UserService } from "src/app/services/user.service";

@Component({
  selector: 'modal-create',
  templateUrl: 'modal-create.component.html',
  standalone: true,
  imports: [MatIconModule, MatFormFieldModule, MatInputModule,CommonModule, MatButtonModule, MatTableModule, MatDatepickerModule, CommonModule,MatNativeDateModule, MatSelectModule, ReactiveFormsModule],
  providers: [],

})
export class ModalCreateComponent {
  selectedDate: Date;
  selectedUserId: number = 0;
  selectedStatusId: number = 0;
  status: Status[] = [];
  users: User[] = [];
  addForm!: FormGroup;

  constructor(public _dialogRef: MatDialogRef<ModalCreateComponent>, public _statusService: StatusService, public _userService: UserService, public _timesheetService: TimeSheetService, private fb: FormBuilder,) {
    this.selectedDate = new Date();
    
  }
    
      ngOnInit() {
        this.addForm = this.fb.group({
          project: ['', Validators.required],
          taskDescription: ['', Validators.required],
          startDate: ['', Validators.required],
          endDate: ['', Validators.required],
          userId: ['', Validators.required],
          statusId: ['', Validators.required],
        });

        this.getAllStatus();
        this.getAllUsers();
      }
    

      getAllStatus(): void {
        this._statusService.getAllStatus().subscribe(
          (status: Status[]) => {
            this.status = status;
          },
          (error) => {
            console.error('Error fetching statuses:', error);
          }
        );
      }

      getAllUsers(): void {
        this._userService.getAllUsers().subscribe(
          (user: User[]) => {
            this.users = user;
          },
          (error) => {
            console.error('Error fetching List of TimeSheet:', error);
          }
        );
      }
  save(): void {
    const body = {
      id: '',
      userId: this.addForm.get('userId')?.value,
      statusId: this.addForm.get('statusId')?.value,
      taskDescription: this.addForm.get('taskDescription')?.value,
      startDate: this.addForm.get('startDate')?.value,
      endDate: this.addForm.get('endDate')?.value,
      project: this.addForm.get('project')?.value,
    }

    this._timesheetService.addTimeSheet(body).subscribe(() =>{
      this._dialogRef.close();
    });
    
  }

  close(): void {
    this._dialogRef.close();
  }
}
