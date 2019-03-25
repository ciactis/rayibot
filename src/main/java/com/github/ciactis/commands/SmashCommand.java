package com.github.ciactis.commands;

import java.util.List;
import java.util.Random;

import com.github.ciactis.rayibot.utils.TextFileManager;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class SmashCommand implements Command{

    private List<String> characters;
    
    public SmashCommand() {
       characters = TextFileManager.getTextFileData("commands/SmashCharacters.txt");
    }

    @Override
    public void execute(String[] args, MessageChannel channel, User author, Message inputMessage) {
        Random random = new Random();
        channel.sendMessage(
                   characters.get(random.nextInt(characters.size()))
                ).queue();
    }

}
