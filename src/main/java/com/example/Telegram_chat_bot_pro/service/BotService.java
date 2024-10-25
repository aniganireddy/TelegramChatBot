package com.example.Telegram_chat_bot_pro.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BotService {
    private final String BOT_TOKEN = "7860004992:AAHsyDdXr3WRLBu4rndf2S9x6YHhiFjUczI";
    private final String BASE_URL = "https://api.telegram.org/bot" + BOT_TOKEN;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();


    public void processUpdate(String update) {
        try {
            JsonNode jsonNode = objectMapper.readTree(update);
            String chatId = jsonNode.get("message").get("chat").get("id").asText();
            String messageText = jsonNode.get("message").get("text").asText();

            sendMessage(chatId, "as per your request:" + messageText);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void sendMessage(String chatId, String text) {

        String url = BASE_URL + "/sendMessage?chat_id=" + chatId + "&text=" + text;
        restTemplate.getForObject(url, String.class);
    }

    public void setWebhook() {
        String url = BASE_URL + "/setWebhook?url=https://yourdomain.com/webhook";
        restTemplate.getForObject(url, String.class);
    }


}

