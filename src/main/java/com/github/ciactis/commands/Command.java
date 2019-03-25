package com.github.ciactis.commands;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;

public interface Command {

    public abstract void execute(String[] args, MessageChannel channel, User author, Message inputMessage);
}
