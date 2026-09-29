package com.rithik.genai_knowledge_assistant;
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.GenerateContentResponseUsageMetadata;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GeminiService {

    private final Client client = new Client();

    public ChatResponse ask(String question) {
        GenerateContentResponse response =
                client.models.generateContent("gemini-2.5-flash", question, null);

        int input = 0, output = 0, total = 0;
        Optional<GenerateContentResponseUsageMetadata> usage = response.usageMetadata();
        if (usage.isPresent()) {
            input = usage.get().promptTokenCount().orElse(0);
            output = usage.get().candidatesTokenCount().orElse(0);
            total = usage.get().totalTokenCount().orElse(0);
        }
        return new ChatResponse(response.text(), input, output, total);
    }
}
