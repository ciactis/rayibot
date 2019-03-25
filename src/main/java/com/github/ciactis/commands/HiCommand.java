package com.github.ciactis.commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public class HiCommand implements Command {

    @Override
    public void execute(String[] args, MessageChannel channel, User author, Message inputMessage) {
        channel.sendMessage("Hi, " + author.getName() + " :blush: !").queue();
    }

}
