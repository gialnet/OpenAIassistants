package vivaldispring.eu.openaiassistants.components;

import org.junit.jupiter.api.Test;

public class ChatCompletionTest {

    /*
    {
  "id": "chatcmpl-9B48GXYzbtfe9MYKuBUxztYVgnBkx",
  "object": "chat.completion",
  "created": 1712424520,
  "model": "gpt-3.5-turbo-0125",
  "choices": [
    {
      "index": 0,
      "message": {
        "role": "assistant",
        "content": null,
        "tool_calls": [
          {
            "id": "call_OQP9amV1KfdI3gTA2KTaqO9H",
            "type": "function",
            "function": {
              "name": "get_domain_name",
              "arguments": "{\"code\":\"01\"}"
            }
          }
        ]
      },
      "logprobs": null,
      "finish_reason": "tool_calls"
    }
  ],
  "usage": {
    "prompt_tokens": 66,
    "completion_tokens": 15,
    "total_tokens": 81
  },
  "system_fingerprint": "fp_b28b39ffa8"
}
     */

    String mas ="mas es mas";
    String cadena = STR."""
            una bonita cadena de texto
            \{mas}
            """;

    @Test
    public void testChatCompletion() {


        System.out.println(cadena);
    }
}
