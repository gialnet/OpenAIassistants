package vivaldispring.eu.openaiassistants.components;

import java.io.IOException;
import java.io.InputStream;

public interface OpenAIfileUpload {

    void upload(InputStream file, String fileName) throws IOException;

    void loadJsonFilesToOpenAI() throws IOException;

    // GET https://api.openai.com/v1/files
    String listFiles() throws IOException;
}
