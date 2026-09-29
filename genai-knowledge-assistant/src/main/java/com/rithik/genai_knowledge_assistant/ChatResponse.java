package com.rithik.genai_knowledge_assistant;

public record ChatResponse(String answer, int inputTokens, int outputTokens, int totalTokens) {}
