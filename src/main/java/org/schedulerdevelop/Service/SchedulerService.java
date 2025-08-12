package org.schedulerdevelop.Service;

import lombok.RequiredArgsConstructor;
import org.schedulerdevelop.Dto.SchedulerResponse;
import org.schedulerdevelop.Dto.SchedulerRequest;
import org.schedulerdevelop.Entity.Scheduler;
import org.schedulerdevelop.Repository.SchedulerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchedulerService {
    private final SchedulerRepository schedulerRepository;

    @Transactional
    public SchedulerResponse createSchedule(SchedulerRequest request) {
        Scheduler scheduler = new Scheduler(
                request.getUserId(),
                request.getTitle(),
                request.getContent()
        );

        Scheduler saved = schedulerRepository.save(scheduler);
        return new SchedulerResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<SchedulerResponse> getAllSchedules() {
        return schedulerRepository.findAll()
                .stream()
                .map(SchedulerResponse::new)
                .toList();
    }

    @Transactional(readOnly = true)
    public SchedulerResponse getScheduleById(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 없습니다.")
        );
        return new SchedulerResponse(scheduler);
    }

    @Transactional
    public SchedulerResponse updateSchedule(Long id, SchedulerRequest request) {
        Scheduler scheduler = schedulerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 일정이 없습니다.")
        );
        scheduler.update(request.getTitle(), request.getContent());
        return new SchedulerResponse(scheduler);
    }

    @Transactional
    public void deleteSchedule(Long id) {
        if(!schedulerRepository.existsById(id)) {
            throw new IllegalArgumentException("해당 일정이 없습니다.");
        }
        schedulerRepository.deleteById(id);
    }
}
