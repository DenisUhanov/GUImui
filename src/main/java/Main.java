import java.io.IOException;

public class Main {
    public static void main(String[] argv) throws IOException {
        Settings settings = new Settings("settings.xml");
        settings.loadFileSettings();
        settings.readSettings();

        Gui.action(700,250);

    }
}

