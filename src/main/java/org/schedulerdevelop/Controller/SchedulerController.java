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
            @RequestBody SchedulerRequest request){
        return ResponseEntity.ok(schedulerService.createSchedule(request));
    }

    @GetMapping("/scheduler")
    public ResponseEntity<List<SchedulerResponse>> getAllSchedule() {
        return ResponseEntity.ok(schedulerService.getAllSchedules());
    }

    @GetMapping("/scheduler/{id}")
    public ResponseEntity<SchedulerResponse> getScheduleById(
            @PathVariable Long id
    ) {
        return ResponseEntity.ok(schedulerService.getScheduleById(id));
    }

    @PutMapping("/scheduler/{id}")
    public ResponseEntity<SchedulerResponse> updateSchedule(
            @PathVariable Long id,
            @RequestBody SchedulerRequest request
    ) {
        return ResponseEntity.ok(schedulerService.updateSchedule(id, request));
    }

    @DeleteMapping("/scheduler/{id}")
    public ResponseEntity<Void>  deleteSchedule(
            @PathVariable Long id
    ) {
        schedulerService.deleteSchedule(id);
        return ResponseEntity.ok().build();
    }

}
