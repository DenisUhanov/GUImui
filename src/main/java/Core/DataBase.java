package Core;

import Interface.Settings;
import TuneUP.Parameter;
import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DataBase класс для работы с базой данных
 * */
public class DataBase {

    /**{@value errorFlag} счетчик ошибок*/
public static int errorFlag = 0;


    public static Connection connection = null;

    /**connectDB Метод выполняющий подключение к БД
     * @return connection возвращаем готовое соеденение с БД
     * */
    Connection connectDB() throws SQLException {
        try {
            /**
             * Получаем из Карты настроект следующие данные
             * {@value host} хост БД
             * {@value nameDB} Имя БД
             * {@value userBD} Пользователь БД
             * {@value passBD} Пароль БД
             *
             */
            String host = Parameter.settingsMap.get("host");
            String nameDB = Parameter.settingsMap.get("nameDB");
            String userBD = Parameter.settingsMap.get("userBD");
            String passBD = Parameter.settingsMap.get("passBD");

            /** Выполняем подключение к БД */
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://"+ host +"/"+nameDB,userBD,passBD);


        } catch (SQLException e) {

            /**@see Settings#settingsWindow()
             * Если есть ошибки, выводим окно с настроками и увеличиваем счетчик ошибок*/
            errorFlag = 1;
            Settings.settingsWindow();

        }

        /** Определяем статус соеденения */
        if (connection != null) {
            System.out.println("Соединение установлено!");
        } else {
            System.out.println("Не удалось установить соединение!");
            errorFlag = 2;
        }
        return connection;
    }



    //Ввыполняем SQL
    /** runSQL метод который выполняет SQL запросы
     * @param sql запрос SQL (String)
     * @return resultSet результат выполнения SQL
     * */
    public ResultSet runSQL (String sql){
        ResultSet resultSet = null;

        try{
            Statement statement = connectDB().createStatement();
            resultSet = statement.executeQuery(sql);


        } catch (SQLException e) {
            /** Если не можем выполнить запрос, выводим StackTrace и ув. счетчик ошибок */
            e.printStackTrace();
            errorFlag = 3;
        }
        return resultSet;
    }
}
