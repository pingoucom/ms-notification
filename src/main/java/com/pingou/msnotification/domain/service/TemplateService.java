package com.pingou.msnotification.domain.service;

import com.pingou.msnotification.domain.entity.Template;
import com.pingou.msnotification.domain.repository.TemplateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateService {
    private final TemplateRepository templateRepository;

    public TemplateService(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    public List<Template> getAll() {
        return templateRepository.getAll();
    }

    public List<Template> getByOrigin(String origin) {
        return templateRepository.getByOrigin(origin);
    }

    public Template findByOriginAndId(String origin, String id) {
        return templateRepository.findByOriginAndId(origin, id);
    }
}
