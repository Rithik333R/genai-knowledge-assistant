package com.rithik.genai_knowledge_assistant;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatController {

    private final GeminiService geminiService;

    public ChatController(GeminiService geminiService) {
        this.geminiService = geminiService;
    }

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {
        double temperature = request.temperature() != null ? request.temperature() : 0.7;
        return geminiService.ask(request.question(), temperature);
    }
}
