package vivaldispring.eu.openaiassistants.data.assistant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateAssistantJson {

    private String instructions;
    private String name;
    private List<CreateAssistantToolsJson> tools;
    private String model;
}
