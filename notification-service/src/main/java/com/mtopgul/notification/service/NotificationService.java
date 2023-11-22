package com.mtopgul.notification.service;

import com.mtopgul.notification.dto.NotificationDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author muhammed-topgul
 * @since 22/11/2023 14:46
 */
@Service
@Log4j2
public class NotificationService {
    @Scheduled(initialDelay = 5000, fixedDelay = 5000)
    public void generateNotification() {
        String message = "This message is auto generated. (At: %s)".formatted(LocalDateTime.now());
        NotificationDto notificationDto = new NotificationDto(message);
        log.info("New notification: {}", notificationDto.toString());
    }
}
