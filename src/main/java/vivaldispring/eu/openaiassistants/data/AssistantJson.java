package vivaldispring.eu.openaiassistants.data;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AssistantJson {
    private String id;
    private String object;
    private long createdAt;
    private String name;
    private String description;
    private String model;
    private String instructions;
    private List<ToolJson> tools;
    private List<String> fileIds;
    private MetadataJson metadata;
}
