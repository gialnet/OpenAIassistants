package vivaldispring.eu.openaiassistants.data;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ThreadJson {
    private String id;
    private String object;
    private long createdAt;
    private MetadataJson metadata;
}
