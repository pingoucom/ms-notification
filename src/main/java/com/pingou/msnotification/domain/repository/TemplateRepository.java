package com.pingou.msnotification.domain.repository;

import com.pingou.msnotification.domain.entity.Template;

import java.util.List;

public interface TemplateRepository {
    List<Template> getAll();

    List<Template> getByOrigin(String origin);

    Template findByOriginAndId(String origin, String id);
}
