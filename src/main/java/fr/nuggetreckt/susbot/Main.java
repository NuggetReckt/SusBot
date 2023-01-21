package fr.nuggetreckt.susbot;

import fr.nuggetreckt.susbot.listeners.OnJoinListener;
import fr.nuggetreckt.susbot.listeners.OnReadyListener;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Main instance;

    public Dotenv dotenv;
    public String version;

    private final Logger logger = LoggerFactory.getLogger(Main.class);

    private JDA jda;
    private String token;


    public Main() {
        instance = this;

        logger.info("Lancement du bot...");
        logger.info("Chargement du token...");

        //Dotenv config
        dotenv = Dotenv.configure()
                .directory("/env/")
                .filename(".env")
                .load();

        this.setToken(dotenv.get("TOKEN"));
        this.buildJDA();
    }

    public void buildJDA() {
        //create JDA instance
        jda = JDABuilder.createDefault(getToken())
                .enableIntents(GatewayIntent.GUILD_MEMBERS)
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        this.registerEvents();
    }

    private void registerEvents() {
        jda.addEventListener(new OnJoinListener());
        jda.addEventListener(new OnReadyListener());
    }

    //return main instance
    public static Main getInstance() {
        return instance;
    }

    public JDA getJDA() {
        return jda;
    }

    public Logger getLogger() {
        return logger;
    }

    private String getToken() {
        return token;
    }

    public String getVersion() {
        version = getInstance().getClass().getPackage().getImplementationVersion();
        return version;
    }

    private void setToken(String token) {
        this.token = token;
    }
}
