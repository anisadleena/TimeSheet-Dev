import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { TimeSheet } from './timesheet.type';

@Injectable({
  providedIn: 'root'
})
export class TimeSheetService {
  private apiUrl = 'http://localhost:8080/api/v1/timesheet'; // Update URL accordingly

  constructor(private http: HttpClient) { }

  // Add a new TimeSheet
  addTimeSheet(timeSheet: TimeSheet): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/create`, timeSheet);
  }

  // Get all TimeSheets
  getAllTimeSheets(): Observable<TimeSheet[]> {
    return this.http.get<TimeSheet[]>(`${this.apiUrl}/get/All`);
  }

  // Update TimeSheet
  updateTimeSheet(id: string, timeSheet: TimeSheet): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/update/${id}`, timeSheet);
  }

  // Delete TimeSheet by ID
  deleteTimeSheet(id: string): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/delete/${id}`);
  }

  // Sorting by endDate (DESC)
  sortByEndDate(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/sortedByEndDate`);
  }

  // Sorting by startDate (DESC)
  sortByStartDate(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/sortedByStartDate`);
  }
}
