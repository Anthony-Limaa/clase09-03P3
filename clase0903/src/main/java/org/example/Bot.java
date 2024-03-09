package org.example;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;


public class Bot extends TelegramLongPollingBot {

    private List<String> mensajes = new ArrayList<String>();

    @Override
    public String getBotUsername() {
        return "P3anthonyl_bot";
    }

    @Override
    public String getBotToken() {
        return "7045294319:AAHvj6n6zdGerX_OCo11WzoHnk8uNBANb2Q";
    }


    //Aqui se recibe el mensaje
    @Override
    public void onUpdateReceived(Update update) {
        //System.out.println(update);
        var usuario = update.getMessage().getFrom();
        var mensaje = update.getMessage().getText();
        var id = usuario.getId();

        mensajes.add(usuario+":"+mensaje);

        System.out.println("Usuario: " + usuario.getFirstName() + " " + usuario.getLastName() + " Mensaje: " + mensaje);

        System.out.println("Usuario: " + usuario.getFirstName() + " " + usuario.getLastName() + " Mensaje: " + mensaje);


        if (mensaje.contains("/desplegar"&& mensaje.size()>0){
       String lista= "";
       for (String mensaje1: mensajes){
           lista += mensaje1 + "\n";
       }

    }

    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }
}
}

