package com.email.Gemmail.Service;

import com.email.Gemmail.Entity.EmailRequest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;
import java.util.Objects;


@Service
public class EmailService {

    private final WebClient webClient;

     @Value("${gemini.api.url}")
    private String geminiApiUrl;

     @Value("${gemini.api.key}")
    private String getGeminiApiKey;

    public EmailService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }


    public String generateEmailReply(EmailRequest emailRequest){

        // Build the prompt

        String prompt= buildPrompt(emailRequest);

        // Craft a request
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]{
                        Map.of("parts", new Object[]{
                                Map.of("text", prompt)
                        })
                }
        );



// Do request and get response
 String response = webClient.post()
         .uri(geminiApiUrl+getGeminiApiKey).header("Content-Type", "application/json").bodyValue(requestBody)

         .retrieve().bodyToMono(String.class).block();


        // extract response and return
        return  extractResponseContent(response);

    }

    private String extractResponseContent(String response) {

        try{
            ObjectMapper mapper= new ObjectMapper();
            JsonNode rootNode=  mapper.readTree(response);
            return  rootNode.path("candidates").get(0).path("content").path("parts").get(0).path("text").asText();
        } catch (Exception e){
            return  "Error processing Request:"+e.getMessage();
        }
    }

    private String buildPrompt(EmailRequest emailRequest) {
        StringBuilder prompt = new StringBuilder();
        prompt.append("Generate a professional email reply for the following email content . Please don't generate the subject Line");
        if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty()){
            prompt.append("Use a").append(emailRequest.getTone()).append(" tone.");
        }
        prompt.append("\nOriginal email: \n").append(emailRequest.getEmailContent());
        return  prompt.toString();

    }
}
