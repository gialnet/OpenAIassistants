package vivaldispring.eu.openaiassistants.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileListResponse {

    private String object;
    private List<FileData> data;
    private boolean hasMore;

}
