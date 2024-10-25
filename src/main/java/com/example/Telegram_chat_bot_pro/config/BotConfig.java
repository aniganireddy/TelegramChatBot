package com.example.Telegram_chat_bot_pro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {
    @Value("${telegram.bot.token}")
    private String botToken;
    public String getBotToken(){
        return botToken;
    }

}
