package com.pingou.msnotification.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Template {
    private String id;

    private String origin;

    private boolean enabled;

    private String title;

    private PushSettings push;

    private EmailSettings email;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PushSettings {
        private String title;

        private String body;

        private String deepLink;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class EmailSettings {
        private List<EmailVendor> vendors;

        public static class EmailVendor {
            private String id;

            private Map<String, Object> arguments;
        }
    }
}
