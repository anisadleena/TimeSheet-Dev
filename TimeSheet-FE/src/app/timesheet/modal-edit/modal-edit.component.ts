import { CommonModule } from "@angular/common";
import { Component, Inject, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatNativeDateModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { MatTableModule } from "@angular/material/table";
import { StatusService } from "src/app/services/status.service";
import { TimeSheetService } from "src/app/services/timesheet.service";
import { Status, TimeSheet, User } from "src/app/services/timesheet.type";
import { UserService } from "src/app/services/user.service";

@Component({
  selector: 'modal-edit',
  templateUrl: 'modal-edit.component.html',
  standalone: true,
  imports: [MatIconModule, MatFormFieldModule, MatInputModule,CommonModule, MatButtonModule, MatTableModule, MatDatepickerModule, CommonModule,MatNativeDateModule, MatSelectModule, ReactiveFormsModule],
  providers: [],

})
export class ModalEditComponent{
  editForm!: FormGroup;
  status: Status[] = [];
  users: User[] = [];

  constructor(
    @Inject(MAT_DIALOG_DATA) public data: any, 
    private fb: FormBuilder,
    public _dialogRef: MatDialogRef<ModalEditComponent>,
    public _statusService: StatusService,
    public _timesheetService: TimeSheetService,
    public _userService: UserService
    ) { 
  
   
  }
 
  ngOnInit() {
    this.editForm = this.fb.group({
      project: [this.data.project || '', Validators.required],
      taskDescription: [this.data.taskDescription || '', Validators.required],
      startDate: [this.data.startDate || '', Validators.required],
      endDate: [this.data.endDate || '', Validators.required],
      userId: [this.data.userId || '', Validators.required],
      statusId: [this.data.statusId || '', Validators.required],
    });
    this.getAllStatus();
    this.getAllUsers();
  }

  getAllStatus(): void {
    this._statusService.getAllStatus().subscribe(
      (status: Status[]) => {
        this.status = status;
        console.log(this.status);
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
        console.log(this.users);
      },
      (error) => {
        console.error('Error fetching List of TimeSheet:', error);
      }
    );
  }

  cancel() : void {
    this._dialogRef.close();
  }

  save(): void {
    const body = {
      id: '',
      userId: this.editForm.get('userId')?.value,
      statusId: this.editForm.get('statusId')?.value,
      taskDescription: this.editForm.get('taskDescription')?.value,
      startDate: this.editForm.get('startDate')?.value,
      endDate: this.editForm.get('endDate')?.value,
      project: this.editForm.get('project')?.value,
    }

    this._timesheetService.updateTimeSheet(this.data.id, body).subscribe((response) =>{
      console.log("response : ", response);
      this._dialogRef.close();
    });
  }

  // private formatDate(date: DateTime) : string {
    
  // }

  
}
