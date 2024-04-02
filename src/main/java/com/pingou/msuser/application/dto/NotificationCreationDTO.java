package com.pingou.msuser.application.dto;

import com.pingou.msuser.domain.enumeration.Channel;

import java.util.Map;

public class NotificationCreationDTO {
    private long id;

    private Channel channel;

    private String resource;

    private Map<String, String> parameters;

    private String origin;
}
