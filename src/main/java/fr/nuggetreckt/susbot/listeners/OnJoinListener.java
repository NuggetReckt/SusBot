package fr.nuggetreckt.susbot.listeners;

import fr.nuggetreckt.susbot.utils.Config;
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

        //Setup embed
        embedBuilder.setTitle("\uD83D\uDEEC ・ Un nouveau membre !")
                .setDescription("Bienvenue sur CTOUTPT " + member.getAsMention() + " !")
                .addField("", "Nous sommes maintenant **" + event.getGuild().getMemberCount() + "** membres.", false)
                .setThumbnail(event.getMember().getEffectiveAvatarUrl())
                .setColor(new Color(200, 0, 7))
                .setFooter("SusBot - CTOUPT.fr", "https://play.ctoutpt.fr/assets/images/logo.png")
                .setTimestamp(new Date().toInstant());

        //Send embed message
        new Config().getJoinChannel().sendMessageEmbeds(embedBuilder.build())
                .queue();

        //Give role to member
        event.getGuild().addRoleToMember(member, new Config().getPlayerRole())
                .queue();
    }
}
