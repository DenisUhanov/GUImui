package GUI;

import dataBase.Connect;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServerPanel {
    //подготавливаем листы под данные для кнопок
    List<Integer> lServerID = new ArrayList<Integer>();
    List<String> lServerIPaddr = new ArrayList<String>();
    List<String> lServerNameServer = new ArrayList<String>();
    List<Integer> lServerPanelSet = new ArrayList<Integer>();
    List<Integer> lServerPORT = new ArrayList<Integer>();
    List<String>  lServerUser= new ArrayList<String>();

    Connect connect = new Connect();

    void listLoader() throws SQLException {
        //получили все составные части для создания кнопок отправив запрос в бд
        ResultSet buttonElement = connect.getSomeThing("SELECT * FROM serverList");

        //заносим все полученные части в листы
        while (buttonElement.next()) {
            lServerID.add(buttonElement.getInt("id"));
            lServerIPaddr.add(buttonElement.getString("ip"));
            lServerNameServer.add(buttonElement.getString("nameserver"));
            lServerPanelSet.add(buttonElement.getInt("panel"));
            lServerPORT.add(buttonElement.getInt("port"));
            lServerUser.add(buttonElement.getString("user"));
        }

    }

    public void serverPanels (int sum, JFrame jFrame){

        for(int i = 0; i < sum; i++){

        }

    }

}
