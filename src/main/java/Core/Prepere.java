package Core;

import java.sql.ResultSet;

public class Prepere {
    public ResultSet panelParam;
    public ResultSet serverParam;

    public Prepere(){
        Database database = new Database();
        panelParam = database.runSQL("SELECT * FROM panelParam");
        serverParam = database.runSQL("SELECT * FROM serverParam");
    }



}
