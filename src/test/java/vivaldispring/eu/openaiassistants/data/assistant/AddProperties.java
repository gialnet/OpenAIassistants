package vivaldispring.eu.openaiassistants.data.assistant;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AddProperties {


    @Test
    public void test4() {

        List<CreateAssistantToolsJson> list = new ArrayList<>();

        list.add(CreateAssistantToolsJson.builder()
                .type("function")
                .function(CreateAssistantFuntionJson.builder()
                        .name("get_domain_name")
                        .description("Get the domain name given a code")
                        .parameters(CreateAssistanParametersJson.builder()
                                .type("string")
                                .properties(CreateAssistantPropertiesJson.builder()
                                        .type("string")
                                        .description("The code of one domain")
                                        .build())
                                .required(List.of("code"))
                                .build())
                        .build())
                .build());

        list.add(CreateAssistantToolsJson.builder()
                .type("function")
                .function(CreateAssistantFuntionJson.builder()
                        .name("get_domains")
                        .description("Get the whole list fo domains")
                        .build())
                .build());


        CreateAssistantJson assistantJson = CreateAssistantJson.builder()
                .instructions("You are a Weblogic expert who manage a Weglogic farm organize in domains with codes and names e.g. 00 Expert, 01 SYGMA, 03 Legacy, etc.")
                .name("Weblogic API expert")
                .tools(list)
                .build();

        Gson gson = new Gson();
        String json = gson.toJson(assistantJson, CreateAssistantJson.class);
        System.out.println(json);
    }
}
