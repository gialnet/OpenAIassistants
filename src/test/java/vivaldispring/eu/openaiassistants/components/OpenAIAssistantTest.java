package vivaldispring.eu.openaiassistants.components;

import org.junit.jupiter.api.Test;

public class OpenAIAssistantTest {

    private static final String INTRUCTIONS = """
            You are an IT administrator responsible for managing a pool of WebLogic 12c servers. These servers are grouped into domains, each identified by a unique two-digit code (00-11) and a descriptive name (e.g., EXPERT, SYGMA).            Each domain further comprises various environments for different purposes: Integration, Development, Test, Pre-Production, Production, Training, and Stress-Test.            An existing REST API allows you to manage these servers. Your task is to leverage this API to access and interact with the WebLogic servers. Information Provided: JSON files containing details about the server organization (domain codes, names, environments) Documentation or specifications for the REST API (if available) Goal: Construct the base URI for the REST API.            Demonstrate how to construct URIs to access specific WebLogic servers within different environments using the domain code and environment name. Additional Considerations: Include any assumptions made about the JSON file format (e.g., structure, key names).Specify if authentication details are required for API access (username, password, token). If API documentation exists, reference it for specific API endpoints and parameters.            This improved version provides a clearer context, defines the goal, and outlines additional considerations. It also avoids subjective statements like: We have an amazing REST API, and focuses on providing a structured approach to accessing the WebLogic servers.""";

    @Test
    public void test() {
        StringBuffer jsonBody2 = new StringBuffer("{");
        jsonBody2.append("\"instructions\": \"");
        jsonBody2.append(INTRUCTIONS);
        jsonBody2.append("\",");
        jsonBody2.append("\"name\": \"Weblogic API expert\",");
        jsonBody2.append("\"tools\": [{\"type\": \"function\",");
        jsonBody2.append("\"function\": {");
        jsonBody2.append("\"name\": \"get_domain_name\",");
        jsonBody2.append("\"description\": \"Get the domain name given a code\",");
        jsonBody2.append("\"parameters\": {");
        jsonBody2.append("\"type\": \"object\",");
        jsonBody2.append("\"properties\": {");
        jsonBody2.append("\"code\": {");
        jsonBody2.append("\"type\": \"string\",");
        jsonBody2.append("\"description\": \"The code of one domain\"");
        jsonBody2.append("}");
        jsonBody2.append("},");
        jsonBody2.append("\"required\": [\"code\"]");
        jsonBody2.append("}");
        jsonBody2.append("}");
        jsonBody2.append("}],");
        jsonBody2.append("\"model\": \"gpt-4\"");
        jsonBody2.append("}");

        System.out.println(jsonBody2);
    }
}
