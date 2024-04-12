package vivaldispring.eu.openaiassistants.data.assistant;

import lombok.Builder;

import java.util.List;

@Builder
public class CreateAssistanParametersJson {

    private String type;
    private CreateAssistantPropertiesJson properties;
    private List<String> required;
}
