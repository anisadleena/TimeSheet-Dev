export interface Status {
    status_id: number;
    status_name: string;
  }

export interface TimeSheet {
    timesheet_id: string;
    user_id: number;
    status_id: number;
    task_description: string;
    start_date: string;
    end_date:string;
    project: string;
}

export interface User {
    user_id: number;
    email: string;
    username: string;
}