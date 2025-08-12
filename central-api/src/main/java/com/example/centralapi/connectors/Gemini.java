package com.example.centralapi.connectors;

import com.example.centralapi.models.GeminiApiRequest;
import com.example.centralapi.models.GeminiApiResponse;
import com.example.centralapi.models.RequestContent;
import com.example.centralapi.models.RequestPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class Gemini {
    RestTemplate restTemplate;

    @Autowired
    public Gemini(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${gemini.genai.url}")
    String geminiApiUrl;

    @Value("${gemini.token}")
    String geminiToken;

    String geminiTokenHeader = "X-goog-api-key";
    
    public GeminiApiResponse callGeminiGenAIEndpoint (String prompt) {
        GeminiApiRequest geminiApiRequest = getGeminiApiRequest(prompt);

        HttpHeaders headers = new HttpHeaders();
        headers.add(geminiTokenHeader, geminiToken);
        headers.add("Content-Type", "application/json");

        HttpEntity<GeminiApiRequest> entity = new HttpEntity<>(geminiApiRequest, headers);
        ResponseEntity<GeminiApiResponse> response = restTemplate.exchange(geminiApiUrl, HttpMethod.POST, entity, GeminiApiResponse.class);
        return response.getBody();
    }

    private static GeminiApiRequest getGeminiApiRequest(String prompt) {
        GeminiApiRequest geminiApiRequest = new GeminiApiRequest();
        RequestPart requestPart = new RequestPart();
        requestPart.setText(prompt);
        List<RequestPart> requestParts = new ArrayList<>();
        requestParts.add(requestPart);
        RequestContent requestContent = new RequestContent();
        requestContent.setParts(requestParts);
        List<RequestContent> requestContents = new ArrayList<>();
        requestContents.add(requestContent);
        geminiApiRequest.setContent(requestContents);
        return geminiApiRequest;
    }
}
