package Core;

import Interface.Settings;
import TuneUP.Parameter;
import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
public static int errorFlag = 0;

    public static Connection connection = null;

    //метод выполняющий подключение к бд
    Connection connectDB() throws SQLException {

        //Подключение к БД
        try {
            String host = Parameter.settingsMap.get("host");
            String nameDB = Parameter.settingsMap.get("nameDB");
            String userBD = Parameter.settingsMap.get("userBD");
            String passBD = Parameter.settingsMap.get("passBD");
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://"+ host +"/"+nameDB,userBD,passBD);

        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение! Проверьте консоль");
            errorFlag = 1;
            Settings.settingsWindow();

        }

        //Статус соеденения
        if (connection != null) {
            System.out.println("Соединение установлено!");
        } else {
            System.out.println("Не удалось установить соединение!");
            errorFlag = 2;
        }
        //Возвращаем коннект
        return connection;
    }



    //Ввыполняем SQL
    public ResultSet runSQL (String sql){
        ResultSet resultSet = null;
        try{
            Statement statement = connectDB().createStatement();
            resultSet = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("statemetn биба");
            e.printStackTrace();
            errorFlag = 3;
        }
        return resultSet;
    }
}
