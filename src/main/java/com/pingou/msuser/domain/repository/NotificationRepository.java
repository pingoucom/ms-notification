package com.pingou.msuser.domain.repository;

import com.pingou.msuser.domain.entity.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, String> {
    List<Notification> findByUserId(String userId);
}
