import { CommonModule } from "@angular/common";
import { Component, Inject, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, FormsModule, Validators } from "@angular/forms";
import { MatButtonModule } from "@angular/material/button";
import { MatNativeDateModule } from "@angular/material/core";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MAT_DIALOG_DATA} from "@angular/material/dialog";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatSelectModule } from "@angular/material/select";
import { MatTableModule } from "@angular/material/table";
import { TimeSheet } from "src/app/services/timesheet.type";

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
  selector: 'modal-edit',
  templateUrl: 'modal-edit.component.html',
  standalone: true,
  imports: [MatIconModule, MatFormFieldModule, FormsModule, MatInputModule,CommonModule, MatButtonModule, MatTableModule, MatDatepickerModule, CommonModule,MatNativeDateModule, MatSelectModule],
  providers: [],

})
export class ModalEditComponent implements OnInit{
  editForm: FormGroup;

  constructor(@Inject(MAT_DIALOG_DATA) public data: TimeSheet, private fb: FormBuilder) { 
    this.editForm = this.fb.group({
      project: [this.data.project || '', Validators.required],
      task_description: [this.data.task_description || '', Validators.required],
      start_date: [this.data.start_date || '', Validators.required],
      end_date: [this.data.end_date || '', Validators.required],
    });
  }
 
      ngOnInit() {
        console.log("dataa == ", this.data);
      }
  
}
