import { inject } from "@angular/core"
import { TimeSheetService } from "../services/timesheet.service"

export const timesheetResolver = () => {
    const _timesheetService = inject(TimeSheetService)
    return _timesheetService.getAllTimeSheets();
}