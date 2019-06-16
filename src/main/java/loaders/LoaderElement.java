package loaders;


import dataBase.Get;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class LoaderElement {
    //Сколько  кнопок
    public int valueButtons;
    //В эти листы будут заносится параметры кнопок (айпишник, название и и тд)
    public ArrayList<String> buttonName = new ArrayList<String>();
    public ArrayList<String> buttonIP = new ArrayList<String>();
    public ArrayList<Integer> buttonPanel = new ArrayList<Integer>();
    public ArrayList<Integer> buttonPort = new ArrayList<Integer>();
    public ArrayList<String> buttonUser = new ArrayList<String>();

    //Сколько панелей
    public int valuePanles;
    //имена панелей
    public ArrayList<String> panelName = new ArrayList<String>();
    //ID панелей
    ArrayList<Integer> panelID = new ArrayList<Integer>();


    //Формируем базовый конструктор, После инициализации экземпляра LoaderElement я должен знать сколько там чего лежит и параметры
    public LoaderElement() throws SQLException {
        Get get = new Get();//обхект для работы с SQL запросами
        ResultSet resultSetButton = get.runSQL("SELECT * FROM serverList");

        //Прогоняем полученный результат от SQL запроса через цикл и заполняем листы
        while (resultSetButton.next()) {
            valueButtons++;
            buttonName.add(resultSetButton.getString("nameserver"));
            buttonIP.add(resultSetButton.getString("ip"));
            buttonPanel.add(resultSetButton.getInt("panel"));
            buttonPort.add(resultSetButton.getInt("port"));
            buttonUser.add(resultSetButton.getString("user"));

        }

        //обхект для работы с SQL запросами
        ResultSet resultSetPanel = get.runSQL("SELECT * FROM panelList");
        //Прогоняем полученный результат от SQL запроса через цикл и заполняем листы
        while (resultSetPanel.next()) {
            valuePanles++;
            panelName.add(resultSetPanel.getString("namepanel"));
            panelID.add(resultSetPanel.getInt("id"));
        }
    }

}


