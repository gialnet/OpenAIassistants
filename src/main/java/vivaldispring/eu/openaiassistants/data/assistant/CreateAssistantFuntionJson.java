package vivaldispring.eu.openaiassistants.data.assistant;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateAssistantFuntionJson {

    private String name;
    private String description;

    // parameters object Optional
    private CreateAssistanParametersJson parameters;
}
