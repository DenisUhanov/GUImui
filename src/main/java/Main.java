import Core.DataBase;
import Interface.Settings;
import Interface.WindowMain;
import TuneUP.Parameter;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] argv) throws SQLException {

        Parameter parameter = new Parameter();
        parameter.readSettings();

        if(DataBase.errorFlag == 0){
            WindowMain windowMain = new WindowMain();

            JFrame jFrame = new JFrame();
            jFrame.setBounds(600, 600, 700, 300);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setTitle("GUIMUI");

            JTabbedPane serverList = new JTabbedPane();
            serverList.addTab("Сервера",windowMain.globalTabled(new JTabbedPane()));
            serverList.addTab("Управление",Interface.ControlPanel.addOrDell());
            serverList.addTab("Настройки",Interface.Settings.mainSettings());

            jFrame.add(serverList);
            jFrame.setVisible(true);

        }
        else {
            System.out.println(DataBase.errorFlag);
            Settings.settingsWindow();
        }
    }
}