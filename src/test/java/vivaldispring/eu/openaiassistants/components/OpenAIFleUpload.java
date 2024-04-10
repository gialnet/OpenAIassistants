package vivaldispring.eu.openaiassistants.components;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import vivaldispring.eu.openaiassistants.data.FileListResponse;

public class OpenAIFleUpload {

    private String response = """
            { "object": "list", 
            "data": [ 
                { "object": "file", 
                    "id": "file-K7CVhVYFItNCeEV8Q9pLpDAx", 
                    "purpose": "assistants", 
                    "filename": "osbv2.json", 
                    "bytes": 1527, 
                    "created_at": 1712770819, 
                    "status": "processed", 
                    "status_details": null }, 
                { "object": "file", 
                    "id": "file-B82YTOns9PWYyIiHoVEaS40W", 
                    "purpose": "assistants", 
                    "filename": "opsystr3v2.json", 
                    "bytes": 3021, 
                    "created_at": 1712770818, 
                    "status": "processed", 
                    "status_details": null }, 
                { "object": "file", 
                    "id": "file-67ZpBxRYuu7cNHpAsnWdC53Y", 
                    "purpose": "assistants", 
                    "filename": "sepv2.json", 
                    "bytes": 1760, 
                    "created_at": 1712770818, 
                    "status": "processed", 
                    "status_details": null }, 
                { "object": "file", "id": "file-cozNfu662xUt4Vue1iqdh2uQ", "purpose": "assistants", "filename": "pocv2.json", "bytes": 1578, "created_at": 1712770817, "status": "processed", "status_details": null }, { "object": "file", "id": "file-r8uGZmYZFXbPhqDglhGAMydR", "purpose": "assistants", "filename": "eacv2.json", "bytes": 1758, "created_at": 1712770816, "status": "processed", "status_details": null }, { "object": "file", "id": "file-Md9CBYcg8x39R4v0w6WGHfLs", "purpose": "assistants", "filename": "corev2.json", "bytes": 1764, "created_at": 1712770816, "status": "processed", "status_details": null }, { "object": "file", "id": "file-fNi21w4u33KP86Cj8jcZ56M5", "purpose": "assistants", "filename": "commonv2.json", "bytes": 1541, "created_at": 1712770815, "status": "processed", "status_details": null }, { "object": "file", "id": "file-MYxw5qeyBtLZLqE3yxjiFz9X", "purpose": "assistants", "filename": "legacyv2.json", "bytes": 468, "created_at": 1712770815, "status": "processed", "status_details": null }, { "object": "file", "id": "file-3ghAQS3XH5FxMYLmv8vf1Gll", "purpose": "assistants", "filename": "pdmv2.json", "bytes": 916, "created_at": 1712770814, "status": "processed", "status_details": null }, { "object": "file", "id": "file-HpY8xGJWmSBWz9bUmjRud2QV", "purpose": "assistants", "filename": "opsysv2.json", "bytes": 3071, "created_at": 1712770813, "status": "processed", "status_details": null }, { "object": "file", "id": "file-NC8rhG9FGWXzFsRtkwWr13QA", "purpose": "assistants", "filename": "sygmav2.json", "bytes": 1334, "created_at": 1712770812, "status": "processed", "status_details": null }, { "object": "file", "id": "file-629kRzlQL6cxwez2kdXQ0DtV", "purpose": "assistants", "filename": "expertv2.json", "bytes": 1503, "created_at": 1712770812, "status": "processed", "status_details": null } 
                    ], "has_more": false}
            """;

    @Test
    public void FileListResponse(){
        Gson gson = new Gson();
        FileListResponse fileListResponse = gson.fromJson(response, FileListResponse.class);
        System.out.println(fileListResponse.getData().get(0).getFilename());
    }
}
