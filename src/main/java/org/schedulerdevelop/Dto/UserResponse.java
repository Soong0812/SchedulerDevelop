package org.schedulerdevelop.Dto;

import lombok.Getter;
import org.schedulerdevelop.Entity.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class UserResponse {
    private Long id;
    private String userName;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserResponse(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.email = user.getEmail();
        this.createdAt = user.getCreatedAt();
        this.updatedAt = user.getUpdatedAt();
    }
}
