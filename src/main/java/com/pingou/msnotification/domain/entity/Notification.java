package com.pingou.msnotification.domain.entity;

import com.pingou.msnotification.domain.entity.attribute.converter.ParametersAttributeConverter;
import com.pingou.msnotification.domain.entity.generator.Snowflake;
import com.pingou.msnotification.domain.enumeration.Channel;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "notifications", indexes = {
        @Index(name = "idx_user_id", columnList = "userId"),
        @Index(name = "idx_template_id", columnList = "template"),
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

    @Column(unique = true)
    private String correlationId;

    private Channel channel;

    private String template;

    @Convert(converter = ParametersAttributeConverter.class)
    @Column(columnDefinition = "json")
    private Map<String, Object> parameters;

    private String origin;

    private String vendor;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime sentAt;

    private LocalDateTime receivedAt;

    private LocalDateTime readAt;
}
