package fr.nuggetreckt.susbot.listeners;

import fr.nuggetreckt.susbot.Main;
import net.dv8tion.jda.api.events.GenericEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.EventListener;
import org.jetbrains.annotations.NotNull;

public class OnReadyListener implements EventListener {

    private final Main main = Main.getInstance();

    @Override
    public void onEvent(@NotNull GenericEvent event) {
        if (event instanceof ReadyEvent) {
            main.getLogger().info(main.getJDA().getSelfUser().getName() + " v" + main.getVersion() + " lancé avec succès.");
            main.getLogger().info(main.getJDA().getEventManager().getRegisteredListeners().size() + " listeners chargés.");
            System.out.println("""
                       _____           ____        _  \s
                      / ____|         |  _ \\      | | \s
                     | (___  _   _ ___| |_) | ___ | |_\s
                      \\___ \\| | | / __|  _ < / _ \\| __|
                      ____) | |_| \\__ \\ |_) | (_) | |_\s
                     |_____/ \\__,_|___/____/ \\___/ \\__|
                    """);
        }
    }
}