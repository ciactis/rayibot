package com.github.ciactis.rayibot;

import java.io.IOException;

import javax.security.auth.login.LoginException;

import com.github.ciactis.rayibot.events.JDAEvents;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Rayibot extends ListenerAdapter {

    private static JDA jda;
    
    public static void main(String[] args) throws IOException
    {
        // config.txt contains two lines
        // the first is the bot token
        String token = args[0];

        //We construct a builder for a BOT account. If we wanted to use a CLIENT account
        // we would use AccountType.CLIENT
        try
        {
            jda = new JDABuilder(token)         // The token of the account that is logging in.
                    .addEventListener(new JDAEvents())  // An instance of a class that will handle events.
                    .build();
            jda.awaitReady(); // Blocking guarantees that JDA will be completely loaded.
            System.out.println("Finished Building JDA!");
        }
        catch (LoginException e)
        {
            //If anything goes wrong in terms of authentication, this is the exception that will represent it
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            //Due to the fact that awaitReady is a blocking method, one which waits until JDA is fully loaded,
            // the waiting can be interrupted. This is the exception that would fire in that situation.
            //As a note: in this extremely simplified example this will never occur. In fact, this will never occur unless
            // you use awaitReady in a thread that has the possibility of being interrupted (async thread usage and interrupts)
            e.printStackTrace();
        }
    }

}
