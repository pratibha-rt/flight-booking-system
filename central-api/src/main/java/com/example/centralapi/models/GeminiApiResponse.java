package com.example.centralapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeminiApiResponse {
    private List<ResponseCandidate> candidates;
    private String modelVersion;
    private String responseId;

}
