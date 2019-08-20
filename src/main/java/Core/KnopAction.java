package Core;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static TuneUP.Parameter.readProperties;

/**KnopAction класс описывающий экшены для кнопок */
public class KnopAction {

    /**@value rt выполняет отправленные команды в консоль linux */
    static Runtime rt = Runtime.getRuntime();

    /**@value dataBase объект для рабоыт с БД */
    DataBase dataBase = new DataBase();

    /**enterAction метод который открывает консоль и входит на сервер по SSH
     * @param ip ip сервера
     * @param port порт сервера
     * @param userSSH пользователь сервера
     * */
    static void enterAction(String ip, int port, String userSSH) throws IOException {

        /**@value command
         * Выделяем место под команду которую исполнит консоль Linux */
        String command;

            /** если port  не пуст, тобишь  не равен нулю - добавляем его в исполняемую команду */
            if(port != 0){
                command = readProperties.getProperty("terminal") + " "+readProperties.getProperty("arg")+" ssh "+ userSSH +"@" + ip + " -p" + port;
                System.out.println(command);
            }
            else {
                command = readProperties.getProperty("terminal") + " "+readProperties.getProperty("arg")+" ssh "+ userSSH +"@"+ip;
            }

        /**@value pr
         * Выполняем сформированную команду в терминале Linux*/
        Process pr = rt.exec(command);
    }

    /**ipAction метод который копирует IP сервера в буфер
     * @param ip ip сервера
     *
     * */
    public static void ipAction(String ip){
        StringSelection stringSelection = new StringSelection(ip);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);

    }

    /**pingAction метод который пингует сервер
     * @param ip ip сервера
     * */
    public static void pingAction(String ip) throws IOException {
        /**@value command
         * Выделяем место под команду которую исполнит консоль Linux */
        String command;

        command= readProperties.getProperty("terminal") + " "+readProperties.getProperty("arg")+" ping "+ip;

        /**@value pr
         * Выполняем сформированную команду в терминале Linux*/
        Process pr = rt.exec(command);

    }

    /** deleteAction метод который удаляет сервер из БД */
    public static void deleteAction(String itIsID, JButton remove){
        //и тут опять объект для работы с БД
        DataBase dataBase = new DataBase();

        String sql ="DELETE FROM serverParam WHERE ID=?";

        try {
            PreparedStatement preparedStatement = dataBase.connection.prepareStatement(sql);
            preparedStatement.setString(1, String.valueOf(itIsID));
            preparedStatement.executeUpdate();
            remove.setText("УДАЛЕНО");
            remove.setBackground(Color.green);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /** editAction метод позволяющий менять параметры сервера в БД, так же открывает окно с полями для изменения
     * @param itIsName Имя сервера
     * @param itIsIP IP сервера
     * @param itIsPanel  Номер панели?
     * @param itIsPORT Порт сервера
     * @param itIsUserSSH Пользователь Сервера
     * @param itIsID ID севрера?
     *
     * */
    public static void editAction(String itIsName, String itIsIP, int itIsPanel, int itIsPORT, String itIsUserSSH, final String itIsID){

       //Ну этот метод надо изменить

        JFrame jFrame = new JFrame();
        jFrame.setBounds(500, 500, 700, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new GridLayout(0, 8, 5, 5));

        JDialog jDialog = new JDialog(jFrame, itIsName+" : "+itIsIP);

        final JTextField name = new JTextField();
        name.setText(itIsName);
        jPanel1.add(name);

        final JTextField ip = new JTextField();
        ip.setText(itIsIP);
        jPanel1.add(ip);

        JLabel panelText = new JLabel("Панель->");
        jPanel1.add(panelText);

        final JTextField panel = new JTextField();
        panel.setText(String.valueOf(itIsPanel));
        jPanel1.add(panel);

        JLabel portText = new JLabel("Порт->");
        jPanel1.add(portText);

        final JTextField port = new JTextField();
        port.setText(String.valueOf(itIsPORT));
        jPanel1.add(port);

        final JTextField userSSH = new JTextField();
        userSSH.setText(itIsUserSSH);
        jPanel1.add(userSSH);

        final JButton save = new JButton("Сохранить");
        jPanel1.add(save);

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                DataBase dataBase = new DataBase();
                String sql ="UPDATE serverParam SET ip=?,name=?,panel=?,port=?,userSSH=? WHERE id=?";

                try {
                    PreparedStatement preparedStatement = dataBase.connection.prepareStatement(sql);
                    preparedStatement.setString(1,ip.getText());
                    preparedStatement.setString(2,name.getText());
                    preparedStatement.setInt(3, Integer.parseInt(panel.getText()));
                    preparedStatement.setInt(4, Integer.parseInt(port.getText()));
                    preparedStatement.setString(5,userSSH.getText());

                    preparedStatement.setString(6,itIsID);

                    preparedStatement.executeUpdate();
                    save.setText("Обновил");
                    save.setBackground(Color.green);


                } catch (SQLException e) {
                    e.printStackTrace();
                }



            }
        });

        jDialog.add(jPanel1);

        jDialog.setSize(1000,100);
        jDialog.setVisible(true);
    }

    }