package com.example.Telegram_chat_bot_pro.controller;

import com.example.Telegram_chat_bot_pro.service.BotService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class BotController {
    private final BotService botService;
    public BotController(BotService botService){
        this.botService = botService;
    }

    @PostMapping("/webhook")
    public void handleUpdate( @RequestBody  String update){
        botService.processUpdate(update);
    }

}
