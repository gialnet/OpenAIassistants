package vivaldispring.eu.openaiassistants.components;

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

import java.io.IOException;

public interface OpenAIAssistant {

    // create an Assistant
   public void CreateAnAssistant(String instructions, String name);

    // Create an assistant file by attaching a File to an assistant.
    // public void CreateAssistantFile(String assistant_id, String Filename);

    // Returns a list of assistants
    // GET https://api.openai.com/v1/assistants

    /*
        Create assistant to call get domain code
     */
    void CreateAnAssistantFunction();

    public String getListAssistants() throws IOException;

    // Returns a list of assistant files.
    // public String getListAssistantsFiles() throws IOException;

    // Retrieves an assistant
    // GET https://api.openai.com/v1/assistants/{assistant_id}
    // public String RetrievesAssistant(String assistant_id);

    // GET https://api.openai.com/v1/assistants/{assistant_id}/files/{file_id}
    // public String RetrievesAssistantFiles(String assistant_id, String file_id);

    // Modifies an assistant
    // POST https://api.openai.com/v1/assistants/{assistant_id}
    // modifiesAssistant(String assistant_id);

    // DELETE https://api.openai.com/v1/assistants/{assistant_id}
    String deleteAssistant(String assistant_id) throws IOException;

    // Create a thread
    // POST https://api.openai.com/v1/thread
    Thread createThread();

    // Retrieves a thread
    // GET https://api.openai.com/v1/threads/{thread_id}
    // Thread getThread(thread_id);

    // Delete a thread
    // DELETE https://api.openai.com/v1/threads/{thread_id}
    // deleteThread(String thread_id);

    // Create a message
    // POST https://api.openai.com/v1/threads/{thread_id}/messages
    public void createMessageThread(String thread_id, String content);


}
