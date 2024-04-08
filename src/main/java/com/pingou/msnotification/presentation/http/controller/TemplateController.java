package com.pingou.msnotification.presentation.http.controller;

import com.pingou.msnotification.domain.entity.Template;
import com.pingou.msnotification.domain.service.TemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/templates")
public final class TemplateController {
    private final TemplateService notificationService;

    public TemplateController(TemplateService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    @ResponseBody
    public List<Template> getTemplates() {
        return notificationService.getAll();
    }

    @GetMapping("/{origin}")
    @ResponseBody
    public List<Template> getTemplatesByOrigin(@PathVariable String origin) {
        return notificationService.getByOrigin(origin);
    }

    @GetMapping("/{origin}/{id}")
    @ResponseBody
    public Template getTemplateByOriginAndId(@PathVariable String origin, @PathVariable String id) {
        return notificationService.findByOriginAndId(origin, id);
    }
}
