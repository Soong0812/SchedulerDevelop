package org.schedulerdevelop.Controller;

import lombok.RequiredArgsConstructor;
import org.schedulerdevelop.Dto.SchedulerRequest;
import org.schedulerdevelop.Dto.SchedulerResponse;
import org.schedulerdevelop.Service.SchedulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SchedulerController {

    private final SchedulerService schedulerService;

    @PostMapping("/scheduler")
    public ResponseEntity<SchedulerResponse> createSchedule(
            @RequestBody SchedulerRequest request
    ) {
        return ResponseEntity.ok(schedulerService.createSchedule(request));
    }

    @GetMapping("/scheduler")
    public ResponseEntity<List<SchedulerResponse>> getAllSchedules() {
        return ResponseEntity.ok(schedulerService.getAllSchedules());
    }

    @GetMapping("/scheduler/{scheduleId}")
    public ResponseEntity<SchedulerResponse> getScheduleById(
            @PathVariable Long scheduleId
    ) {
        return ResponseEntity.ok(schedulerService.getScheduleById(scheduleId));
    }

    @PutMapping("/scheduler/{scheduleId}")
    public ResponseEntity<SchedulerResponse> updateSchedule(
            @PathVariable Long scheduleId,
            @RequestBody SchedulerRequest request
    ) {
        return ResponseEntity.ok(schedulerService.updateSchedule(scheduleId, request));
    }

    @DeleteMapping("/scheduler/{scheduleId}")
    public ResponseEntity<Void>  deleteSchedule(
            @PathVariable Long scheduleId
    ) {
        schedulerService.deleteSchedule(scheduleId);
        return ResponseEntity.ok().build();
    }

}
