package org.schedulerdevelop.Dto;

import lombok.Getter;

@Getter
public class SchedulerRequest {
    private Long userId;
    private String title;
    private String content;
}
