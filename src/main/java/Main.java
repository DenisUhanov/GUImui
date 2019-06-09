import settings.Gather;

import javax.swing.*;
import java.io.IOException;

import static settings.Gather.*;


public class Main {
    public static void main(String[] argv) throws IOException {

        JFrame jFrame = new JFrame();
        jFrame.setBounds(600,600, windWdth,windHeight);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

        jFrame.revalidate();

    }
}

