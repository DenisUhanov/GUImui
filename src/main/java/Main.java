import GUI.ServerPanel;
import GUI.SettingPane;
import settings.Gather;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;



public class Main {
    public static void main(String[] argv) throws IOException, SQLException {

        //получить настроки
        settings.Gather gather = new Gather();
        gather.readAll();

        //Создаем главное окно и задаем ему параметры
        JFrame jFrame = new JFrame();
        jFrame.setBounds(600, 600, 700, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создаем объект создающий и собирающий панели
        ServerPanel serverPanel = new ServerPanel();
        //объект имеющий возможность создавать вкладки
        JTabbedPane serverTabs = new JTabbedPane();
        //Помещаем в данный обхект панели в каждую вкладку
        serverTabs.addTab("Сервера",serverPanel.fittingServPanels(new JTabbedPane()));

        SettingPane settingPane = new SettingPane();
        settingPane.addOtherTabs(serverTabs);

        jFrame.add(serverTabs);

        jFrame.setVisible(true);

    }
}

