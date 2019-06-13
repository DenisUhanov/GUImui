package dataBase;
import java.sql.*;


public class Connect {
    //для того что бы обращаться к ней из любого метода
    static Connection connection = null;

    //берем данные из настроек для подключения к бд.
    static String host = settings.Gather.readProperties.getProperty("host");
    static String bdName = settings.Gather.readProperties.getProperty("bdName");
    static String userBD = settings.Gather.readProperties.getProperty("userBD");
    static String passBD = settings.Gather.readProperties.getProperty("passBD");


    //метод выполняющий подключение к бд
    static Connection connectDB() throws SQLException {
        String prefBd = "jdbc:mysql://";
        try {
            connection = DriverManager.getConnection(prefBd+host+"/"+bdName,userBD,passBD);

        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
            GUI.SettingPane.windowsError("Не могу в БД");
        }

        return  connection;
    }


}
