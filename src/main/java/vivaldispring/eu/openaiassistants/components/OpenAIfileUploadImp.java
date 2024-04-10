package vivaldispring.eu.openaiassistants.components;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import vivaldispring.eu.openaiassistants.utils.JsonFileNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class OpenAIfileUploadImp implements OpenAIfileUpload{

    @Value("${myopenai.apikey}")
    private String OPENAI_API_KEY;
    private final ResourceLoader resourceLoader;
    private final String[] allDoms = {"00","01","02","03","04","05","06","07","08","09","10","11"};

    public OpenAIfileUploadImp(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /*
    curl https://api.openai.com/v1/files \
      -H "Authorization: Bearer $OPENAI_API_KEY" \
      -F purpose="fine-tune" \
      -F file="@mydata.jsonl"
     */

    @Override
    public void upload(InputStream file, String fileName) throws IOException {

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("https://api.openai.com/v1/files");
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + OPENAI_API_KEY);

        HttpEntity entity = MultipartEntityBuilder.create()
                .addBinaryBody("file", file, ContentType.APPLICATION_JSON, fileName)
                .addTextBody("purpose", "assistants")
                .build();

        httpPost.setEntity(entity);

        HttpResponse response = httpClient.execute(httpPost);
        System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
    }


    /**
     * Load a list of json files to OpenAI files API
     * @throws IOException
     */
    @Override
    public void loadJsonFilesToOpenAI() throws IOException {

        Resource resource;

        for (String dn : allDoms){
            resource = resourceLoader.getResource("classpath:/static/json/".concat(JsonFileNames.getNameByNumber(dn)));
            InputStream jsonfile = resource.getInputStream();
            upload(jsonfile, JsonFileNames.getNameByNumber(dn));
        }
    }

    // GET https://api.openai.com/v1/files
    @Override
    public String listFiles() throws IOException {

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet("https://api.openai.com/v1/files");

        // Set headers
        request.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);

        HttpResponse response = httpClient.execute(request);

        // Read response content
        BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            result.append(line);
        }

        return result.toString();

    }
}
