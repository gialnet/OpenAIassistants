package vivaldispring.eu.openaiassistants.components;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class OpenAIAssistantImp implements OpenAIAssistant {

    @Value("${myopenai.apikey}")
    private String OPENAI_API_KEY;
    private static final String API_URL_CREATE = "https://api.openai.com/v1/assistants";
    private static final String API_URL_LIST = "https://api.openai.com/v1/assistants?order=desc&limit=20";
    private static final String API_URL_THREAD = "https://api.openai.com/v1/threads";

    /*
    curl "https://api.openai.com/v1/assistants" \
      -H "Content-Type: application/json" \
      -H "Authorization: Bearer $OPENAI_API_KEY" \
      -H "OpenAI-Beta: assistants=v1" \
      -d '{
        "instructions": "You are a personal math tutor. When asked a question, write and run Python code to answer the question.",
        "name": "Math Tutor",
        "tools": [{"type": "code_interpreter"}],
        "model": "gpt-4"
      }'
    */

    @Override
    public void CreateAnAssistant(String instructions, String name) {

        String jsonBody = "{\n" +
                "        \"instructions\": \"You are a personal math tutor. When asked a question, write and run Python code to answer the question.\",\n" +
                "        \"name\": \"Math Tutor\",\n" +
                "        \"tools\": [{\"type\": \"code_interpreter\"}],\n" +
                "        \"model\": \"gpt-4\"\n" +
                "      }";

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpPost httpPost = new HttpPost(API_URL_CREATE);
            httpPost.setHeader(MIME.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            httpPost.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);
            httpPost.setHeader("OpenAI-Beta", "assistants=v1");

            httpPost.setEntity(new StringEntity(jsonBody));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)){
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                System.out.println(result);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
        curl "https://api.openai.com/v1/assistants?order=desc&limit=20" \
          -H "Content-Type: application/json" \
          -H "Authorization: Bearer $OPENAI_API_KEY" \
          -H "OpenAI-Beta: assistants=v1"
     */
    @Override
    public String getListAssistants() throws IOException {

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(API_URL_LIST);

        // Set headers
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);
        request.setHeader("OpenAI-Beta", "assistants=v1");

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

    /*
    curl https://api.openai.com/v1/threads \
          -H "Content-Type: application/json" \
          -H "Authorization: Bearer $OPENAI_API_KEY" \
          -H "OpenAI-Beta: assistants=v1" \
          -d ''
     */
    @Override
    public Thread createThread() {

        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpPost httpPost = new HttpPost(API_URL_THREAD);
            httpPost.setHeader(MIME.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            httpPost.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);
            httpPost.setHeader("OpenAI-Beta", "assistants=v1");

            httpPost.setEntity(new StringEntity(""));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)){
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                System.out.println(result);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}