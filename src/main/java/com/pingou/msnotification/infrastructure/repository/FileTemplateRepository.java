package com.pingou.msnotification.infrastructure.repository;

import com.google.gson.Gson;
import com.pingou.msnotification.domain.entity.Template;
import com.pingou.msnotification.domain.repository.TemplateRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Component
public class FileTemplateRepository implements TemplateRepository {
    private static final Path TEMPLATES_FOLDER_PATH = Paths.get("templates", "blueprints");

    private final Gson gson = new Gson();

    public List<Template> getAll() {
        return loadTemplatesFromPath(TEMPLATES_FOLDER_PATH);
    }

    private List<Template> loadTemplatesFromPath(Path path) {
        List<Template> templates = List.of();

        try (Stream<Path> templateFiles = Files.walk(path)) {
            templates = templateFiles
                    .filter(Files::isRegularFile)
                    .map(this::mapPathToTemplate)
                    .toList();
        } catch (IOException e) {
            return List.of();
        }

        return templates;
    }

    private Template mapPathToTemplate(Path path) {
        String content = "";
        try {
            content = Files.readString(path);
        } catch (IOException e) {
            return null;
        }

        String fileName = path.getFileName().toString().replace(".json", "");
        String directoryName = path.getParent().getFileName().toString();

        Template template = gson.fromJson(content, Template.class);
        template.setId(fileName);
        template.setOrigin(directoryName);

        return template;
    }

    public List<Template> getByOrigin(String origin) {
        Path originFolderPath = TEMPLATES_FOLDER_PATH.resolve(origin);

        return loadTemplatesFromPath(originFolderPath);
    }

    public Template findByOriginAndId(String origin, String id) {
        String templateFileName = id + ".json";
        Path templatePath = TEMPLATES_FOLDER_PATH.resolve(origin).resolve(templateFileName);

        return mapPathToTemplate(templatePath);
    }
}
