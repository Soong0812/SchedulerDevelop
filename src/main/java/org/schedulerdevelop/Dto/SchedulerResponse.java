package org.schedulerdevelop.Dto;

import lombok.Getter;
import org.schedulerdevelop.Entity.Scheduler;

import java.time.LocalDateTime;

@Getter
public class SchedulerResponse {
    private Long id;
    private String name;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public SchedulerResponse(Scheduler scheduler) {
        this.id = scheduler.getId();
        this.name = scheduler.getName();
        this.title = scheduler.getTitle();
        this.content = scheduler.getContent();
        this.createdAt = scheduler.getCreatedAt();
        this.updatedAt = scheduler.getUpdatedAt();
    }
}
