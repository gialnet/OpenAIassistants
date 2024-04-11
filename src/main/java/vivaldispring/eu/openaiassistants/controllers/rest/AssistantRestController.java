package vivaldispring.eu.openaiassistants.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vivaldispring.eu.openaiassistants.components.OpenAIAssistant;

import java.io.IOException;

@RestController
public class AssistantRestController {


    private final OpenAIAssistant openAIAssistant;

    public AssistantRestController(OpenAIAssistant openAIAssistant) {
        this.openAIAssistant = openAIAssistant;
    }


    @GetMapping("/create")
    private void createAssistant(){

        openAIAssistant.CreateAnAssistant("Test", "Nothing");
    }

    @GetMapping("/create2")
    private ResponseEntity<?> createAssistant2(){

       return ResponseEntity.ok().body(openAIAssistant.CreateAnAssistantFunction());
    }

    @GetMapping("/list")
    private ResponseEntity<?> listAssistant() throws IOException {

        return ResponseEntity.ok().body(openAIAssistant.getListAssistants());
    }

    @GetMapping("/del/{assistant_id}")
    private ResponseEntity<?> deleteAssistant(@PathVariable String assistant_id) throws IOException {

        return ResponseEntity.ok().body(openAIAssistant.deleteAssistant(assistant_id));
    }
}
