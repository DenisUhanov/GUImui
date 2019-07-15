package Interface;

import javax.swing.*;
import java.awt.*;

public class ControlPanel {

    public static JTabbedPane addOrDell(){
        JTabbedPane tableCP = new JTabbedPane();
        JPanel addKnopJP = new JPanel();
        JPanel addPanelJP = new JPanel();

        addKnop(addKnopJP);
        addPanel(addPanelJP);

        tableCP.addTab("Добавить сервер", Interface.Preset.jsSet(addKnopJP));
        tableCP.addTab("Добавить панель", Interface.Preset.jsSet(addPanelJP));

        return tableCP;
    }

    static void addKnop(JPanel jPanel){
        jPanel.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel ip =new JLabel("IP сервера:");
        JTextField ipFie = new JTextField();
        jPanel.add(ip);
        jPanel.add(ipFie);

        JLabel name =new JLabel("Имя сервера:");
        JTextField nameFie = new JTextField();
        jPanel.add(name);
        jPanel.add(nameFie);

        JLabel panel =new JLabel("Номер панели:");
        JTextField panelFie = new JTextField();
        jPanel.add(panel);
        jPanel.add(panelFie);

        JLabel port =new JLabel("Порт:");
        JTextField portFie = new JTextField();
        jPanel.add(port);
        jPanel.add(portFie);

        JLabel userSSH =new JLabel("Пользователь SSH:");
        JTextField userSSHFie = new JTextField();
        jPanel.add(userSSH);
        jPanel.add(userSSHFie);

        JButton save = new JButton();
        save.setText("Добавить");
        jPanel.add(save);

        JButton clear = new JButton();
        clear.setText("Очистить");
        jPanel.add(clear);

    }

    static void addPanel(JPanel jPanel){
        jPanel.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel name =new JLabel("Имя Панели:");
        JTextField nameFie = new JTextField();
        jPanel.add(name);
        jPanel.add(nameFie);

        JButton save = new JButton();
        save.setText("Добавить");
        jPanel.add(save);

        JButton clear = new JButton();
        clear.setText("Очистить");
        jPanel.add(clear);
    }

}
