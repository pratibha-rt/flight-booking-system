package com.example.centralapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCandidate {
    private RequestContent content;
    private String finishReason;
    private double avgLogprobs;
}
