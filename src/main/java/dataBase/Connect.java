package dataBase;
import java.sql.*;


public class Connect {
    //для того что бы обращаться к ней из любого метода
    Connection connection = null;

    //берем данные из настроек для подключения к бд.
    String host = settings.Gather.readProperties.getProperty("host");
    String bdName = settings.Gather.readProperties.getProperty("bdName");
    String user = settings.Gather.readProperties.getProperty("user");
    String pass = settings.Gather.readProperties.getProperty("pass");


    //метод выполняющий подключение к бд
    Connection bd() throws SQLException {
        String prefBd = "jdbc:mysql://";
        try {
            connection = DriverManager.getConnection(prefBd+host+"/"+bdName+user+pass);

        }catch (SQLException sqlEx){
            GUI.SettingPane.windowsError("Не могу в БД");
        }

        return  connection;
    }

    //Метод который выполняет sql
    public ResultSet getSomeThing (String sql){
        ResultSet resultSet = null;
        try{
            Statement statement = bd().createStatement();
            resultSet = statement.executeQuery(sql);


        } catch (SQLException e) {
            GUI.SettingPane.windowsError("statement показал бибу");
        }
        return resultSet;
    }


}
