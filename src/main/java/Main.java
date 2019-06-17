import GUI.OtherPanel;
import GUI.ServerPanel;
import settings.Gather;
import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;



public class Main {
    public static void main(String[] argv) throws IOException, SQLException {

        //получить настроки
        settings.Gather gather = new Gather();
        gather.readAll();

        //Подгружаем прочие панели, настроки и добавления
        OtherPanel otherPanel = new OtherPanel();

        //Создаем главное окно и задаем ему параметры
        JFrame jFrame = new JFrame();
        jFrame.setBounds(600, 600, 700, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Создаем объект создающий и собирающий панели
        ServerPanel serverPanel = new ServerPanel();
        //объект имеющий возможность создавать вкладки
        JTabbedPane globalTabs = new JTabbedPane();
        //Помещаем в данный обхект панели в каждую вкладку
        globalTabs.addTab("Сервера",serverPanel.fittingServPanels(new JTabbedPane()));

        //Создаем панель настроек и присваиваем ей ссылку settingsPanel
        JPanel settingsPanel= otherPanel.settingPane(new JPanel());
        //Добавляем панель настроек во вкладку настроки
        globalTabs.addTab("Настройки", settingsPanel);

        jFrame.add(globalTabs);
        jFrame.setVisible(true);

    }
}

