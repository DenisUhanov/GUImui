import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class GUImui {
    public static void main(String[] argv) {

        System.out.println("-------- MySQL JDBC Тестирование соединения ------------");

        try {
            //Это загрузит драйвер MySQL, каждая БД имеет свой собственный драйвер
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Нет драйвера?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver зарегистрирован!");
        Connection connection = null;

        try {
            connection = (Connection) DriverManager
                    .getConnection("jdbc:mysql://91.224.23.227/javatest","userjava", "user");

        } catch (SQLException e) {
            System.out.println("Не удалось установить соединение! Проверьте консоль");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("Соединение установлено!");
        } else {
            System.out.println("Не удалось установить соединение!");
        }
    }
}

