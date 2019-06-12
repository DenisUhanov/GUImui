import GUI.ServerPanel;
import settings.Gather;
import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] argv) throws IOException {

        settings.Gather gather = new Gather();
        gather.read();

        JFrame jFrame = new JFrame();
        jFrame.setBounds(600,600, 700,200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        ServerPanel serverPanel = new ServerPanel();
        serverPanel.serverPanels(3,jFrame);

        jFrame.revalidate();

    }
}

