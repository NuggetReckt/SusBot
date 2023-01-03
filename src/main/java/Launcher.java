import fr.nuggetreckt.nswsync.Main;

public class Launcher {
    public static void main(String[] args) {
        try {
            new Main();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
