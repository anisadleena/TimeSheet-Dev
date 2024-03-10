
import { Component, OnInit, ViewChild } from '@angular/core';
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
import { Status, TimeSheet, User } from '../services/timesheet.type';
import { ModalEditComponent } from './modal-edit/modal-edit.component';
import { MatPaginator, MatPaginatorModule } from '@angular/material/paginator';
import { MatSort, MatSortModule } from '@angular/material/sort';
  

@Component({
  selector: 'timesheet',
  templateUrl: 'timesheet.component.html',
  standalone: true,
  imports: [MatIconModule, MatFormFieldModule, FormsModule, MatInputModule,CommonModule, MatButtonModule, MatTableModule, MatDialogModule,MatTooltipModule, MatSelectModule, MatDatepickerModule, ReactiveFormsModule, MatPaginatorModule,MatSortModule],
})
export class TimeSheetComponent implements OnInit {
  searchTerm: string = '';
  filterGlobalSearchControl: FormControl = new FormControl();
  displayedColumns: string[] = ['project', 'task', 'assignedto', 'from', 'to', 'status', 'operation'];
  status: Status[] = [];
 
  users: User[] = [];

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;
  listTimeSheet: MatTableDataSource<any>;
  constructor(
    public dialog: MatDialog,
    public _statusService: StatusService,
    public _timesheetService: TimeSheetService,
    public _userService: UserService
  ) {
    this.listTimeSheet = new MatTableDataSource<any>();
  }

  ngOnInit() {
    this.getAllStatus();
    this.getAllTimeSheets();
    this.getAllUsers();
    this.search();
  }

  ngAfterViewInit() {
    // Assuming your data is fetched and assigned to listTimeSheet
    this.listTimeSheet.paginator = this.paginator;
    this.listTimeSheet.sort = this.sort;
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

  getAllTimeSheets(): void {
    this._timesheetService.getAllTimeSheets().subscribe(
      (listTimeSheet: TimeSheet[]) => {
        this.listTimeSheet.data = listTimeSheet;  
      },
      (error) => {
        console.error('Error fetching List of TimeSheet:', error);
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

  search(): void {
    this.filterGlobalSearchControl.valueChanges.subscribe((searchText: string) => {
      this.listTimeSheet.filter = searchText.trim().toLowerCase();
    });

    // Set up custom filterPredicate
    this.listTimeSheet.filterPredicate = (data: TimeSheet, filter: string) => {
      const searchData = `${data.project} ${data.taskDescription}`.toLowerCase();
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

  edit(id : string): void {
    const selectedTimeSheet = this.listTimeSheet.data.find(timesheet => timesheet.id === id);
    const dialogRef = this.dialog.open(ModalEditComponent, {
      width: '100%',
      disableClose: false,
      panelClass: 'info',
      data: selectedTimeSheet
    });

    // ==========================================
    // automatically refresh from backend 
    // after close modal 
    // ==========================================
    dialogRef.afterClosed().subscribe(()=>{
      this._timesheetService.getAllTimeSheets().subscribe();
    })
  }

  delete(id : string): void {
    this._timesheetService.deleteTimeSheet(id).subscribe(() =>{
    });
  }
}
