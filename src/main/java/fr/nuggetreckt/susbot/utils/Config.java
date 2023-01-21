package fr.nuggetreckt.susbot.utils;

import fr.nuggetreckt.susbot.Main;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class Config {

    //Channel ids
    public String joinChannelId = "975728853374877758";
    public String botChannelId = "975728853538471986";

    //Role ids
    public String playerRoleId = "975728853081284702";

    private final Main main = Main.getInstance();

    public MessageChannel getJoinChannel() {
        return main.getJDA().getTextChannelById(joinChannelId);
    }

    public MessageChannel getBotChannel() {
        return main.getJDA().getTextChannelById(botChannelId);
    }

    public Role getPlayerRole() {
        return main.getJDA().getRoleById(playerRoleId);
    }
}
