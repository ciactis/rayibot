package com.github.ciactis.rayibot.events;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.github.ciactis.commands.AnimalSoundCommand;
import com.github.ciactis.commands.Command;
import com.github.ciactis.commands.HiCommand;
import com.github.ciactis.commands.SmashCommand;
import com.github.ciactis.rayibot.utils.RayiConstants;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class JDAEvents extends ListenerAdapter {

    private static Map<String, Command> commands = new HashMap<>();
    
    static {
        commands.put("hi", new HiCommand());
        commands.put("ruido", new AnimalSoundCommand());
        commands.put("smash", new SmashCommand());
    }
    
    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        Message message = event.getMessage();
        String text = message.getContentDisplay();
        MessageChannel channel = event.getChannel();
        if (text.startsWith(RayiConstants.DELIMITER)) {
            User author = event.getAuthor();                //The user that sent the message
            boolean bot = author.isBot();                    //This boolean is useful to determine if the User that
            
            if (!bot) {
                String command = text.split(" ", 2)[0].substring(1);
                Optional.ofNullable(commands.get(command))
                .ifPresent(c -> c.execute(null, channel, author, message));
            }
        }
        
        if (text.toLowerCase().contains("rayito")) {
            message.addReaction(RayiConstants.RAYITO).queue();
        }
    }
    
    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        User author = event.getAuthor();
        if (!author.isBot()) {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("AAAA!").queue();
        }
    }
}
