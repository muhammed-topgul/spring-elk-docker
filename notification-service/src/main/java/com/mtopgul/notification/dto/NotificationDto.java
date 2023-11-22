package com.mtopgul.notification.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author muhammed-topgul
 * @since 22/11/2023 14:44
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDto {
    private final String id = UUID.randomUUID().toString();
    private final LocalDateTime createdAt = LocalDateTime.now();
    private String message;

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", createdAt=" + createdAt +
                ", message='" + message + '\'' +
                '}';
    }
}
