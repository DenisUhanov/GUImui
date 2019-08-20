package Interface;

import Core.DataBase;
import Core.Knop;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/***Класс главного окна программы */
public class WindowMain {

    Preset presetJP = new Preset();
    Knop knop = new Knop();

    //конечный генератор вкладок с панелями
    public JTabbedPane globalTabled (JTabbedPane jTabbedPane) throws SQLException {

        DataBase dataBase = new DataBase();
        ResultSet panelParam = dataBase.runSQL("SELECT * FROM panelParam");

        //Собираем панели и фасуем в них кнопки
        while (panelParam.next()){
            JPanel jPanel = new JPanel();
            knop.getKnops(panelParam.getInt("id"),jPanel);
            jTabbedPane.addTab(panelParam.getInt("id")+": "+panelParam.getString("namepanel"),Interface.Preset.readyPanel(jPanel));

        }

        return jTabbedPane;
    }
}