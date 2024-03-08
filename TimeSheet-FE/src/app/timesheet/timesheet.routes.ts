import { Routes } from "@angular/router";
import { TimeSheetComponent } from "./timesheet.component";
import { timesheetResolver } from "./timesheet.resolver";

export default [
    {
        path: '',
        children: [
            {
                path: '',
                pathMatch: 'full',
                component: TimeSheetComponent,
                resolve: {
                    product: timesheetResolver
                }
            }
        ]
    }
] as Routes;