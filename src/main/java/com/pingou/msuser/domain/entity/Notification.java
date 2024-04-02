package com.pingou.msuser.domain.entity;

import com.pingou.msuser.domain.entity.generator.Snowflake;
import com.pingou.msuser.domain.enumeration.Channel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "notifications", indexes = {
        @Index(name = "idx_user_id", columnList = "userId")
})
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    @GenericGenerator(name = "snowflake", type = Snowflake.class)
    @GeneratedValue(generator = "snowflake")
    private long id;

    private String userId;

    private Channel channel;

    private String resource;

    private String parameters;

    private String origin;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime sentAt;

    private LocalDateTime receivedAt;

    private LocalDateTime readAt;
}
