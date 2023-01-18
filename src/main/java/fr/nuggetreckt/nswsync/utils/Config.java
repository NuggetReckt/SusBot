package fr.nuggetreckt.nswsync.utils;

import fr.nuggetreckt.nswsync.Main;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class Config {

    public String joinChannelId = "";
    public String botChannelId = "";

    private final Main main = Main.getInstance();

    public MessageChannel getJoinChannel() {
        return main.getJDA().getTextChannelById(joinChannelId);
    }

    public MessageChannel getBotChannel() {
        return main.getJDA().getTextChannelById(botChannelId);
    }
}
