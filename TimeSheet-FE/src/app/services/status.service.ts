// status.service.ts

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, ReplaySubject } from 'rxjs';
import { Status } from './timesheet.type';

@Injectable({
  providedIn: 'root'
})
export class StatusService {
  private baseUrl = 'http://localhost:8080/api/v1/status';

  private _status: ReplaySubject<Status[]> = new ReplaySubject<Status[]>(1)

  constructor(private http: HttpClient) { }

  getAllStatus(): Observable<Status[]> {
    return this.http.get<Status[]>(`${this.baseUrl}/get/All`);
  }
}
