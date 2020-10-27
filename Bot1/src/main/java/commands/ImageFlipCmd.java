package commands;

import Helper.ParameterStringBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageFlipCmd extends ListenerAdapter {

    public void spongeBobSarcasm(GuildMessageReceivedEvent event) throws IOException {
        if(event.getAuthor().isBot())
            return;

        String[] messageSent = event.getMessage().getContentRaw().split(" ");

        event.getChannel().sendMessage("hi").queue();

        if(messageSent.length > 1 && messageSent[0].equalsIgnoreCase("!s"))
        {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < messageSent.length; i++)
            {
                sb.append(messageSent[i] + " " );
            }


            URL url = new URL("https://api.imgflip.com/caption_image");
            Map<String, String> parameters = new HashMap<>();

            parameters.put("template_id", "102156234");

            parameters.put("username", "flaminpee");
            parameters.put("password", "blahblahblah");

            parameters.put("text0", "");
            parameters.put("text1", sb.toString());

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");

            con.setDoOutput(true);
            con.setAllowUserInteraction(false);

            DataOutputStream out = new DataOutputStream((con.getOutputStream()));
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            String[] s = content.toString().split(":");
            String link = "";
            if(s.length == 7)
            {
                link = s[5] + ":" + s[6];
            }

            event.getChannel().sendMessage(link).queue();

        }
            }
}
