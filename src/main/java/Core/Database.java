package Core;

import java.sql.*;

public class Database {


    public static Connection connection = null;

    //метод выполняющий подключение к бд
    static Connection connectDB() throws SQLException {

        //Это загрузит драйвер MySQL
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("MySQL JDBC Driver зарегистрирован!");
        } catch (ClassNotFoundException e) {
            System.out.println("Нет драйвера?");
            e.printStackTrace();
        }

        //Подключение к БД
        try {
            connection = DriverManager.getConnection("jdbc:mysql://91.224.23.227/javatest","userjava","8S0r9G9v");

        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение! Проверьте консоль");
            e.printStackTrace();

        }

        //Статус соеденения
        if (connection != null) {
            System.out.println("Соединение установлено!");
        } else {
            System.out.println("Не удалось установить соединение!");
        }
        //Возвращаем коннект
    return connection;
    }




    public ResultSet runSQL (String sql){
        ResultSet resultSet = null;
        try{
            Statement statement = connectDB().createStatement();
            resultSet = statement.executeQuery(sql);


        } catch (SQLException e) {
            System.out.println("statemetn биба");
            e.printStackTrace();
        }
        return resultSet;
    }
}
