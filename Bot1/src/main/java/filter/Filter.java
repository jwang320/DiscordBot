package filter;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Filter extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event)
    {
        String[] message = event.getMessage().getContentRaw().split(" ");
        for(String s : message)
        {
            if(s.equalsIgnoreCase("work"))
            {
                event.getMessage().delete().queue();
                event.getChannel().sendMessage("that's not allowed").queue();
            }
        }
    }
}
