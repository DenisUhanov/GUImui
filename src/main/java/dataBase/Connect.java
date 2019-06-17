package dataBase;
import GUI.OtherPanel;

import javax.swing.*;
import java.sql.*;


public class Connect {
    //для того что бы обращаться к ней из любого метода
    static Connection connection = null;

    //берем данные из настроек для подключения к бд.
    static String host = settings.Gather.readProperties.getProperty("HostBD");
    static String bdName = settings.Gather.readProperties.getProperty("NameBD");
    static String userBD = settings.Gather.readProperties.getProperty("UserBD");
    static String passBD = settings.Gather.readProperties.getProperty("PassBD");


    //метод выполняющий подключение к бд
    static Connection connectDB() throws SQLException {
        String prefBd = "jdbc:mysql://";
        try {
            connection = DriverManager.getConnection(prefBd+host+"/"+bdName,userBD,passBD);

        }catch (SQLException sqlEx){
            GUI.OtherPanel.windowsError("Не могу в БД, Задай или исправь настройки подключения к БД.");

        }

        return  connection;
    }

}
