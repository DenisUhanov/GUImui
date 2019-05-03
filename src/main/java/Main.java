import javax.swing.*;

public class Main {
    public static void main(String[] argv) {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(750,250,700,200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jFrame.revalidate();
    }
}

