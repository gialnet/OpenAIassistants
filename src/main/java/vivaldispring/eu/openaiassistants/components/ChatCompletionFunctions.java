package vivaldispring.eu.openaiassistants.components;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MIME;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class ChatCompletionFunctions {

    /*
    curl https://api.openai.com/v1/chat/completions \
        -H "Content-Type: application/json" \
        -H "Authorization: Bearer $OPENAI_API_KEY" \
        -d '{
          "model": "gpt-3.5-turbo",
          "messages": [
            {
              "role": "user",
              "content": "What is the domain name for domain code 01?"
            }
          ],
          "tools": [
            {
              "type": "function",
              "function": {
                "name": "get_domain_name",
                "description": "Get the domain name given a code",
                "parameters": {
                  "type": "object",
                  "properties": {
                    "code": {
                      "type": "string",
                      "description": "The code of one domain"
                    }
                  },
                  "required": ["code"]
                }
              }
            }
          ],
          "tool_choice": "auto"
        }'
     */

    @Value("${myopenai.apikey}")
    private String OPENAI_API_KEY;
    private String jsonBody = """
            {
                      "model": "gpt-3.5-turbo",
                      "messages": [
                        {
                          "role": "user",
                          "content": "What is the domain name for domain code 01?"
                        }
                      ],
                      "tools": [
                        {
                          "type": "function",
                          "function": {
                            "name": "get_domain_name",
                            "description": "Get the domain name given a code",
                            "parameters": {
                              "type": "object",
                              "properties": {
                                "code": {
                                  "type": "string",
                                  "description": "The code of one domain"
                                }
                              },
                              "required": ["code"]
                            }
                          }
                        }
                      ],
                      "tool_choice": "auto"
                    }
            """;

    public void callFunction(){
        try (CloseableHttpClient httpClient = HttpClientBuilder.create().build()) {

            HttpPost httpPost = new HttpPost("https://api.openai.com/v1/chat/completions");
            httpPost.setHeader(MIME.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
            httpPost.setHeader("Authorization", "Bearer " + OPENAI_API_KEY);


            httpPost.setEntity(new StringEntity(jsonBody));

            try (CloseableHttpResponse response = httpClient.execute(httpPost)){
                String result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                System.out.println(result);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}