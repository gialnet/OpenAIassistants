package vivaldispring.eu.openaiassistants.data;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class AssistantJsonTest {

    String jsonResponse = """
            {
               "id": "asst_nuCJs573PMBFwq2Glmr5lYz8",
               "object": "assistant",
               "created_at": 1712325342,
               "name": "Math Tutor",
               "description": null,
               "model": "gpt-4",
               "instructions": "You are a personal math tutor. When asked a question, write and run Python code to answer the question.",
               "tools": [
                 {
                   "type": "code_interpreter"
                 }
               ],
               "file_ids": [],
               "metadata": {}
             }          
            """;
    @Test
    public void test() {

        Gson gson = new Gson();
        AssistantJson json = gson.fromJson(jsonResponse, AssistantJson.class);
        System.out.println(json.getInstructions());
    }
}
