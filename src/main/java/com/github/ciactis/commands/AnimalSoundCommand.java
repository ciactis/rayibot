package com.github.ciactis.commands;

import java.util.List;
import java.util.Random;

import com.github.ciactis.rayibot.utils.TextFileManager;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class AnimalSoundCommand implements Command{

    private List<String> sounds;
    
    public AnimalSoundCommand() {
       sounds = TextFileManager.getTextFileData("commands/AnimalSounds.txt");
    }

    @Override
    public void execute(String[] args, MessageChannel channel, User author, Message inputMessage) {
        Random random = new Random();
        channel.sendMessage(
                   sounds.get(random.nextInt(sounds.size()))
                ).queue();
    }

}
