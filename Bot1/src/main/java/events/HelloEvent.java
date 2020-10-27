package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class HelloEvent extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {

        if(event.getAuthor().isBot())
            return;

        String[] messageSent = event.getMessage().getContentRaw().split(" ");

        StringBuilder sb = new StringBuilder();
        String prev = "";


        for(String s : messageSent)
        {
            if(prev.equals("i'm"))
            {
                event.getChannel().sendMessage(("Hi " + s)).queue();
            }
            prev = s;

        }
    }
}
