package vivaldispring.eu.openaiassistants.data;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

public class CreateThread {

    String Thread = """
            {
              "id": "thread_abc123",
              "object": "thread",
              "created_at": 1699012949,
              "metadata": {}
            }        
            """;

    @Test
    public void test() {

        Gson gson = new Gson();
        ThreadJson gsonThread = gson.fromJson(Thread, ThreadJson.class);
        System.out.println(gsonThread.getId());
    }
}
