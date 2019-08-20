/***
 * GUIMUI
 * @author Uhanov Denis
 * @version 1.0
 */

import Core.DataBase;
import Interface.Settings;
import Interface.WindowMain;
import TuneUP.Parameter;

import javax.swing.*;
import java.sql.SQLException;


/** Главный класс собирающий все параметры и создающий интерфейс*/
public class Main {
    public static void main(String[] argv) throws SQLException {
        /**@see Parameter
         * Создаем объект для работы с настроками */
        Parameter parameter = new Parameter();

        /** @see Parameter#readSettings
         * Читаем настройки*/
        parameter.readSettings();

        /** Если ошибок в настройках и БД нет - собираем интерфейс, загружаем программу*/
        if(DataBase.errorFlag == 0){

            /**@see WindowMain
             * Создаем объект с интерфейсом, кнопками, вкладками серверов*/
            WindowMain windowMain = new WindowMain();

            /**Создаем главное окно программы */
            JFrame jFrame = new JFrame();

            /**Окно программы имеет размер 700 на 30, размещено на экране в координатах 600, 600 */
            jFrame.setBounds(600, 600, 700, 300);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setTitle("GUIMUI");

            /** Создаем главный объект с вкладками*/
            JTabbedPane serverList = new JTabbedPane();
            serverList.addTab("Сервера",windowMain.globalTabled(new JTabbedPane()));
            serverList.addTab("Управление",Interface.ControlPanel.addOrDell());
            serverList.addTab("Настройки",Interface.Settings.mainSettings());

            /** Добавляем главный объект с вкладками в главное окно программы */
            jFrame.add(serverList);
            jFrame.setVisible(true);

        }
        /**@see Settings#settingsWindow()
         * Если есть ошибки, выводим окно с настроками*/
        else {
            System.out.println(DataBase.errorFlag);
            Settings.settingsWindow();
        }
    }
}