package Interface;

import Core.DataBase;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** Класс описывающий вкладку управления */
public class ControlPanel {

    /**addOrDell метод описывающий Панель Управление, содержит вкладки: добавить сервер, добавить панель, удалить панель
     * @return tableCP это JTabbedPane (Управление) содержащий вклади управления
     * */
    public static JTabbedPane addOrDell(){
        JTabbedPane tableCP = new JTabbedPane();

        /** Панели управления которые будут отправлены в методы для заполнения их контентом */
        JPanel addKnopJP = new JPanel();
        JPanel addPanelJP = new JPanel();
        JPanel dellPanelJP = new JPanel();

        /**@see ControlPanel#addKnop(JPanel) метод отвечает за добавление кнопок (серверов)
         * @see ControlPanel#addPanel(JPanel) метод отвечает за добавление панелей
         * @see ControlPanel#dellPanel(JPanel) метод отвечает за удаление панелей
         * */
        addKnop(addKnopJP);
        addPanel(addPanelJP);
        dellPanel(dellPanelJP);

        /**После того как панели управления будут заполнены контентом, можно их добавить как вкладки */
        tableCP.addTab("Добавить сервер", Interface.Preset.jsSet(addKnopJP));
        tableCP.addTab("Добавить панель", Interface.Preset.jsSet(addPanelJP));
        tableCP.addTab("Удалить панель", Interface.Preset.jsSet(dellPanelJP));

        return tableCP;
    }

    /** addKnop метод добавляющий на панель и в БД возможность добавления кнопок (серверов) */
    static void addKnop(JPanel jPanel){
        jPanel.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel status = new JLabel();
        status.setText("Заметка:");
        jPanel.add(status);

        final JTextArea text0 = new JTextArea();
        text0.setText("Нельзя оставлять поля пустыми.\nЕсли порта нет, пиши 0.");
        jPanel.add(text0);

        JLabel ip =new JLabel("IP сервера:");
        final JTextField ipFie = new JTextField();
        jPanel.add(ip);
        jPanel.add(ipFie);

        JLabel name =new JLabel("Имя сервера:");
        final JTextField nameFie = new JTextField();
        jPanel.add(name);
        jPanel.add(nameFie);

        JLabel panel =new JLabel("Номер панели:");
        final JTextField panelFie = new JTextField();
        jPanel.add(panel);
        jPanel.add(panelFie);

        JLabel port =new JLabel("Порт:(0 - нет порта)");
        final JTextField portFie = new JTextField();
        jPanel.add(port);
        jPanel.add(portFie);

        JLabel userSSH =new JLabel("Пользователь SSH:");
        final JTextField userSSHFie = new JTextField();
        jPanel.add(userSSH);
        jPanel.add(userSSHFie);

        /**@value save кнопка которая сохраняет кнопки (сервера) В БД */
        JButton save = new JButton();
        save.setText("Добавить");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataBase dataBase = new DataBase();
                String sql ="INSERT INTO serverParam (ip, name, panel,port,userSSH) VALUES (?,?,?,?,?)";

                try {
                    PreparedStatement preparedStatement = dataBase.connection.prepareStatement(sql);
                    preparedStatement.setString(1,ipFie.getText());
                    preparedStatement.setString(2,nameFie.getText());
                    preparedStatement.setInt(3, Integer.parseInt(panelFie.getText()));
                    preparedStatement.setInt(4, Integer.parseInt(portFie.getText()));
                    preparedStatement.setString(5,userSSHFie.getText());
                    preparedStatement.executeUpdate();

                    text0.setText("Сервер добавлен.\nНо, нужно перезапустить программу -\nдля загррузки кнопок");
                    text0.setBackground(Color.green);

                } catch (SQLException e) {
                   e.printStackTrace();

                }
            }
        });
        jPanel.add(save);

        /** @value clear кнопка очистить */
        JButton clear = new JButton();
        clear.setText("Очистить");
        jPanel.add(clear);

    }

    /** addPanel метод добавляющий на панель элементы добавления новых панелей в БД*/
    static void addPanel(JPanel jPanel){
        jPanel.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel status = new JLabel();
        status.setText("Заметка:");
        jPanel.add(status);

        final JTextArea text0 = new JTextArea();
        text0.setText("Нельзя оставлять поля пустыми.");
        jPanel.add(text0);

        JLabel name =new JLabel("Имя Панели:");
        final JTextField nameFie = new JTextField();
        jPanel.add(name);
        jPanel.add(nameFie);

        JButton save = new JButton();
        save.setText("Добавить");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataBase dataBase = new DataBase();
                String sql ="INSERT INTO panelParam (namepanel) VALUES (?)";

                try {
                    PreparedStatement preparedStatement = dataBase.connection.prepareStatement(sql);
                    preparedStatement.setString(1,nameFie.getText());

                    preparedStatement.executeUpdate();

                    text0.setText("Панель добавил.\nНо, нужно перезапустить программу -\nдля загррузки панели");
                    text0.setBackground(Color.green);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel.add(save);

        /** не активная часть кода?*/
        JButton clear = new JButton();
        clear.setText("Очистить");
        jPanel.add(clear);
    }

    /** dellPanel метод добавляющий на панель элементы позволяющие удалить панели из БД*/
    static void dellPanel(JPanel jPanel){
        jPanel.setLayout(new GridLayout(0, 2, 5, 5));

        JLabel status = new JLabel();
        status.setText("Заметка:");
        jPanel.add(status);

        final JTextArea text0 = new JTextArea();
        text0.setText("Нельзя оставлять поля пустыми.");
        jPanel.add(text0);

        JLabel id =new JLabel("ID Панели:");
        final JTextField idFie = new JTextField();
        jPanel.add(id);
        jPanel.add(idFie);

        JButton save = new JButton();
        save.setText("Удалить");
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DataBase dataBase = new DataBase();
                String sql ="DELETE FROM panelParam WHERE ID=?";

                try {
                    PreparedStatement preparedStatement = dataBase.connection.prepareStatement(sql);
                    preparedStatement.setString(1,idFie.getText());

                    preparedStatement.executeUpdate();

                    text0.setText("Панель Удалил.\nНо, нужно перезапустить программу -\nдля обновления списка");
                    text0.setBackground(Color.green);

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
        jPanel.add(save);

        /** не активная часть кода?*/
        JButton clear = new JButton();
        clear.setText("Очистить");
        jPanel.add(clear);
    }

}
