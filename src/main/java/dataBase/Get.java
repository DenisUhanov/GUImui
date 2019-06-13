package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Get {

    //Метод который выполняет sql
    public ResultSet runSQL (String sql){
        ResultSet resultSet = null;
        try{
            Statement statement = dataBase.Connect.connectDB().createStatement();
            resultSet = statement.executeQuery(sql);


        } catch (SQLException e) {
            GUI.SettingPane.windowsError("statement показал бибу");
        }
        return resultSet;
    }
}
