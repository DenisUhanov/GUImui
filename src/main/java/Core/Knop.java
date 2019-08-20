package Core;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**Knop класс создающий кнопки:
 * 1. Подключения к сервер
 * 2. Копирования IP сервера
 * 3. Пинга
 * 4. Изменить
 * 5. Удалить
 * */
public class Knop {

    /** Создаем объект для работы с БД
     * */
    DataBase dataBase = new DataBase();


    /**getKnops метод собирающий кнопки и добавляющий их в панель
     * @param panel номер панели (Нужен для SQL запроса к БД ( поле serverParam )
     * @param jPanel объект панели в которую добавляем кнопки
     * */
    public void getKnops(int panel, final JPanel jPanel) throws SQLException {

        /** Получаем все данные кнопок относящиеся к конкретной панели*/
        ResultSet serverParam = dataBase.runSQL("SELECT * FROM serverParam WHERE panel="+panel);


        /**Добавляем кнопки в панель */
        while (serverParam.next()){
            /** @link https://stackoverflow.com/questions/13208755/inside-jbuttons-actionperformed-final-variables-required
             *
             * Задаем переменным параметры полученные в результате SQL запроса serverParam
             * */
            final String itIsName = serverParam.getString("name");
            final String itIsID = serverParam.getString("id");
            final String itIsIP = serverParam.getString("ip");
            final String itIsUserSSH = serverParam.getString("userSSH");
            final int itIsPORT = serverParam.getInt("port");
            final int itIsPanel = serverParam.getInt("panel");


            /** Начинаем создание экшенов для кнокоп */

            /** enter кнопка входа на сервер */
            JButton enter = new JButton(serverParam.getString("name"));
            enter.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {

                        /**@see KnopAction#enterAction(String, int, String)
                         * Экшен для входа на сервер
                         * */
                        KnopAction.enterAction(itIsIP, itIsPORT,itIsUserSSH);

                    } catch (IOException e) {
                        e.printStackTrace();
                        DataBase.errorFlag = 4;
                    }
                }
            });

            /**ip кнопка для отображения и копирования IP сервера */
            final JButton ip  = new JButton(serverParam.getString("ip"));
            ip.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    /**@see KnopAction#ipAction(String)
                     * Экшен для копирования IP сервера в буфер (на кнопке так же IP отображен) */
                    KnopAction.ipAction(itIsIP);
                }
            });


            /** ping кнопка которая пингует сервер */
            JButton ping = new JButton("Ping");
            ping.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {

                        /**@see KnopAction#pingAction(String)
                         * Экшен для пинга сервера
                         * */
                        KnopAction.pingAction(itIsIP);

                    } catch (IOException e) {
                        e.printStackTrace();
                        DataBase.errorFlag = 5;
                    }
                }
            });

            /** edit кнопка изменить - дает возможноть изменить параметры сервера (название, имя) в БД*/
            JButton edit  = new JButton("Изменить");
            edit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                    /**@see KnopAction#editAction(String, String, int, int, String, String)
                     * Экшен для изменения параметров сервера
                     * */
                    KnopAction.editAction(itIsName, itIsIP, itIsPanel,itIsPORT,itIsUserSSH, itIsID);

                }
            });

            /**remove кнопка удаляющая сервер из БД */
            final JButton remove = new JButton("Удалить");
            remove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    /**@see KnopAction#deleteAction(String, JButton)
                     * Экшен для удаления кнопки
                     * */
                    KnopAction.deleteAction(itIsID, remove);
            }});


            /** Добавляем на панель кнопки */
            jPanel.add(enter);
            jPanel.add(ip);
            jPanel.add(ping);
            jPanel.add(edit);
            jPanel.add(remove);
        }
    }
}
