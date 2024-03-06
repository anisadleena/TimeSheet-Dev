import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TimeSheet } from './timesheet.type';

@Injectable({
  providedIn: 'root'
})
export class TimeSheetService {
  private apiUrl = 'http://localhost:8080/api/1.0/timesheet'; // Update URL accordingly

  constructor(private http: HttpClient) { }

  // Add a new TimeSheet
  addTimeSheet(timeSheet: TimeSheet): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/create`, timeSheet);
  }

  // // Get all TimeSheets
  // getAllTimeSheets(): Observable<TimeSheet[]> {
  //   return this.http.get<TimeSheet[]>(this.apiUrl);
  // }

  // Update TimeSheet
  updateTimeSheet(id: number, timeSheet: TimeSheet): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/delete/${id}`, timeSheet);
  }

  // Delete TimeSheet by ID
  deleteTimeSheet(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/edit/${id}`);
  }
}
