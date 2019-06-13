import settings.Gather;
import javax.swing.*;
import java.io.IOException;


public class Main {
    public static void main(String[] argv) throws IOException {

        //получить настроки
        settings.Gather gather = new Gather();
        gather.read();

        JFrame jFrame = new JFrame();
        jFrame.setBounds(600, 600, 700, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jFrame.setVisible(true);

    }
}

