import Core.Database;
import Core.Knob;

import javax.swing.*;
import java.sql.SQLException;


public class Main {
    public static void main(String[] argv) throws SQLException {
        Database database = new Database();
        database.runSQL("SELECT * FROM panelList");

        //Если коннект с базой данных есть отрисовываем графику
        if (database.connection != null){
            JFrame jFrame = new JFrame();
            jFrame.setBounds(600, 600, 700, 200);
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.setTitle("GUIMUI");


            jFrame.setVisible(true);
        }
        else {
            System.out.println("Биба с бд");
        }

    }

}

