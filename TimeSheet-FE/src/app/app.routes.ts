import { Routes } from '@angular/router';
import { TimeSheetComponent } from './timesheet/timesheet.component';


export const routes: Routes = [
  { path: 'timesheet', component: TimeSheetComponent },
  { path: '', redirectTo: '/timesheet', pathMatch: 'full' }
];
