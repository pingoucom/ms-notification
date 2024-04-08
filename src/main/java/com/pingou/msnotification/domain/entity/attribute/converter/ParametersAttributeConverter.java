package com.pingou.msnotification.domain.entity.attribute.converter;

import com.google.gson.Gson;
import jakarta.persistence.AttributeConverter;
import org.springframework.boot.autoconfigure.gson.GsonProperties;

import java.util.Map;

public class ParametersAttributeConverter implements AttributeConverter<Map<String, Object>, String> {
    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        return gson.toJson(attribute);
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        return gson.fromJson(dbData, Map.class);
    }
}
