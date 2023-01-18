package fr.nuggetreckt.nswsync;

import fr.nuggetreckt.nswsync.listeners.OnJoinListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Main instance;

    public JDA jda;

    public Dotenv dotenv;

    private String token;

    public Logger logger = LoggerFactory.getLogger(Main.class);

    public Main() {
        instance = this;

        logger.info("Lancement du bot...");

        logger.info("Chargement du token...");

        dotenv = Dotenv.configure()
                .directory("/env/")
                .filename(".env")
                .load();

        this.setToken(dotenv.get("TOKEN"));

        this.buildJDA();
    }

    public void buildJDA() {
        jda = JDABuilder.createDefault(getToken())
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        this.registerEvents();
    }

    private void registerEvents() {
        jda.addEventListener(new OnJoinListener());
    }

    public static Main getInstance() {
        return instance;
    }

    public JDA getJDA() {
        return jda;
    }

    private String getToken() {
        return token;
    }

    private void setToken(String token) {
        this.token = token;
    }
}
