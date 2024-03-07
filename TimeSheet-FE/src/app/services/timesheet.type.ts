export interface Status {
    id: number;
    statusName: string;
  }

export interface TimeSheet {
    id: string;
    userId: number;
    statusId: number;
    taskDescription: string;
    startDate: string;
    endDate:string;
    project: string;
}

export interface User {
    id: number;
    email: string;
    username: string;
}