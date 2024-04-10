package vivaldispring.eu.openaiassistants.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vivaldispring.eu.openaiassistants.components.OpenAIfileUpload;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FilesController {

    private final OpenAIfileUpload openAIfileUpload;

    public FilesController(OpenAIfileUpload openAIfileUpload) {
        this.openAIfileUpload = openAIfileUpload;
    }

    @GetMapping("/load")
    public ResponseEntity<String> load() throws IOException {

        openAIfileUpload.loadJsonFilesToOpenAI();

        return ResponseEntity.ok().body("File uploaded successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<String> list() throws IOException {

        return ResponseEntity.ok().body(openAIfileUpload.listFiles());
    }
}
