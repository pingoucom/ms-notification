package com.pingou.msnotification.presentation.http.controller;

import com.pingou.msnotification.domain.entity.Notification;
import com.pingou.msnotification.domain.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/users/{userId}/notifications")
    @ResponseBody
    public List<Notification> getNotifications(@PathVariable String userId) {
        return notificationService.getUserNotifications(userId);
    }
}
