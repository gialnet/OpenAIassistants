package vivaldispring.eu.openaiassistants.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileData {
    private String object;
    private String id;
    private String purpose;
    private String filename;
    private int bytes;
    private long createdAt;
    private String status;
    private Object statusDetails;

}
