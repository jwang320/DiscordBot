import commands.ImageFlipCmd;
import events.CategoryEvent;
import events.HelloEvent;
import filter.Filter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Bot {

    public static void main(String args[]) throws Exception
    {


        JDA jda = new JDABuilder("NjI1NzQ4NzM3NTgyNDMyMjk3.XYkD7A.dW_a04Hp8UNXLANbr4LxCH88oOo").build();

        jda.addEventListener(new HelloEvent());
        jda.addEventListener(new CategoryEvent());
        jda.addEventListener(new Filter());
        jda.addEventListener(new ImageFlipCmd());
    }
}
