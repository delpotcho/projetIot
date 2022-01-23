package org.eheio.projet.iot.service.implementation;

import org.springframework.stereotype.Component;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramService extends TelegramLongPollingBot {
    private static  long chatId;
    @Override
    public String getBotUsername() {
        return "shaybalegend_bot";
    }

    @Override
    public String getBotToken() {
        return "5159865884:AAFsTVYhDIsQS8qmRHELqW0dxFMb_PUoRzQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            String message_text = update.getMessage().getText();
            long chat_id = update.getMessage().getChatId();
            chatId=chat_id;
            SendMessage message = new SendMessage(); // Create a message object object
                    message.setChatId(String.valueOf(chat_id));

            try {
                if(message_text.equals("/active")){
                    message.setText("Notification Activé");
                    execute(message);
                }
              //  execute(message); // Sending our message object to user
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMessage(String myMessage){
        SendMessage message = new SendMessage(); // Create a message object object
        message.setChatId(String.valueOf(chatId));
        try {

                System.out.println(chatId);
                message.setText(myMessage);
                execute(message);

            //  execute(message); // Sending our message object to user
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
