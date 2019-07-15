package Core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Knop {
    DataBase dataBase = new DataBase();

    public void getKnops(int panel, JPanel jPanel) throws SQLException {
        //Получаем кнопки конкретной панели
        ResultSet serverParam = dataBase.runSQL("SELECT * FROM serverParam WHERE panel="+panel);


        //Добавляем кнопки в панели, заодно определяем для кнопок экшены
        while (serverParam.next()){
            //https://stackoverflow.com/questions/13208755/inside-jbuttons-actionperformed-final-variables-required
            final String itIsIP = serverParam.getString("ip");
            final String itIsUserSSH = serverParam.getString("userSSH");
            final int itIsPORT = serverParam.getInt("port");

            JButton enter = new JButton(serverParam.getString("name"));
            enter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        KnopAction.enterAction(itIsIP, itIsPORT,itIsUserSSH);
                    } catch (IOException e) {
                        e.printStackTrace();
                        DataBase.errorFlag = 4;
                    }
                }
            });

            final JButton ip  = new JButton(serverParam.getString("ip"));
            ip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    KnopAction.ipAction(itIsIP);
                }
            });


            JButton ping = new JButton("Ping");
            ping.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        KnopAction.pingAction(itIsIP);
                    } catch (IOException e) {
                        e.printStackTrace();
                        DataBase.errorFlag = 5;
                    }
                }
            });

            JButton error  = new JButton("Изменить");
            error.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                }
            });

            //Добавляем в панель кнопки
            jPanel.add(enter);
            jPanel.add(ip);
            jPanel.add(ping);
            jPanel.add(error);


        }
    }
}
