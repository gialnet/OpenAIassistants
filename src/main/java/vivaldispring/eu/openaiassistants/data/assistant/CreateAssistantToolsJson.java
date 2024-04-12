package vivaldispring.eu.openaiassistants.data.assistant;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAssistantToolsJson {

    public String type;
    private CreateAssistantFuntionJson function;
}
