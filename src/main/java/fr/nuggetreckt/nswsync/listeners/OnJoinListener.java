package fr.nuggetreckt.nswsync.listeners;

import fr.nuggetreckt.nswsync.utils.Config;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.Date;

public class OnJoinListener extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(@NotNull GuildMemberJoinEvent event) {
        EmbedBuilder embedBuilder = new EmbedBuilder();
        Member member = event.getMember();

        embedBuilder.setTitle("")
                .setDescription(member.getEffectiveName() + "A rejoint le discord")
                .setColor(new Color(200, 0, 7))
                .setFooter("CTOUTPT", "https://play.ctoutpt.fr/assets/images/logo.png")
                .setTimestamp(new Date().toInstant());

        new Config().getJoinChannel().sendMessageEmbeds(embedBuilder.build()).queue();
    }
}
