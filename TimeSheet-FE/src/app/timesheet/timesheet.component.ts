
import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { CommonModule } from '@angular/common';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import { ModalCreateComponent } from './modal-create/modal-create.component';
import { MatDialog, MatDialogModule } from '@angular/material/dialog';
import { MatTooltipModule } from '@angular/material/tooltip';
import {MatSelectModule} from '@angular/material/select';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { StatusService } from '../services/status.service';
import { TimeSheetService } from '../services/timesheet.service';
import { UserService } from '../services/user.service';

export interface TimesheetEntry {
    timesheet_id: string;
    user_id: number;
    status_id: number;
    task_description: string;
    start_date: Date;
    end_date: Date;
    project: string;
  }
  

@Component({
  selector: 'timesheet',
  templateUrl: 'timesheet.component.html',
  standalone: true,
  imports: [MatIconModule, MatFormFieldModule, FormsModule, MatInputModule,CommonModule, MatButtonModule, MatTableModule, MatDialogModule,MatTooltipModule, MatSelectModule, MatDatepickerModule, ReactiveFormsModule],
})
export class TimeSheetComponent {
    dummyData: TimesheetEntry[] = [
        {
          timesheet_id: "92acd49a-7c42-4ede-bae1-bda55ae70685",
          user_id: 3,
          status_id: 1,
          task_description: "sja saja update2222",
          start_date: new Date("2024-03-03T00:00:00"),
          end_date: new Date("2024-04-03T00:00:00"),
          project: "project Test 3",
        },
        {
          timesheet_id: "61dfae49-9636-4a3e-a978-f7d4a6ecbf1c",
          user_id: 2,
          status_id: 3,
          task_description: "i dunt knoww",
          start_date: new Date("2024-03-03T00:00:00"),
          end_date: new Date("2024-04-03T00:00:00"),
          project: "project Test 2",
        },
        {
          timesheet_id: "055d9b02-f7ac-4572-a092-d4ba31cf7636",
          user_id: 1,
          status_id: 1,
          task_description: "entahlah nakkk",
          start_date: new Date("2024-03-03T00:00:00"),
          end_date: new Date("2024-04-03T00:00:00"),
          project: "project Test 221",
        }
      ];
      
      searchTerm: string = '';
      filterGlobalSearchControl: FormControl = new FormControl();
      timeSheetList : MatTableDataSource<TimesheetEntry> ;
      displayedColumns: string[] = ['project', 'task', 'assignedto', 'from', 'to', 'status', 'operation'];
    
      constructor(public dialog: MatDialog, public _statusService: StatusService , public _timesheetService: TimeSheetService, public _userService: UserService ) {
        this.timeSheetList = new MatTableDataSource(this.dummyData);
        this.search();
      }
    
      ngOnInit() {
       
      }
    
      search(): void {
        this.filterGlobalSearchControl.valueChanges.subscribe((searchText: string) => {
          this.timeSheetList.filter = searchText.trim().toLowerCase();
        });
    
        // Set up custom filterPredicate
        this.timeSheetList.filterPredicate = (data: TimesheetEntry, filter: string) => {
          const searchData = `${data.project} ${data.task_description}`.toLowerCase();
          return searchData.includes(filter);
        };
      }

      create(): void {
        const dialogRef = this.dialog.open(ModalCreateComponent, {
          width: '100%',
          disableClose: false,
          panelClass: 'info',
        });
    }
    

}
