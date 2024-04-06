package vivaldispring.eu.openaiassistants.controllers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vivaldispring.eu.openaiassistants.components.ChatCompletionFunctions;

@RestController
public class ChatCompletionController {

    private final ChatCompletionFunctions chatCompletionFunctions;

    public ChatCompletionController(ChatCompletionFunctions chatCompletionFunctions) {
        this.chatCompletionFunctions = chatCompletionFunctions;
    }

    @GetMapping("/completion")
    public void completion() {
        chatCompletionFunctions.callFunction();
    }
}
