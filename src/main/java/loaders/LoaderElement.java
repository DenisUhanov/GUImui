package loaders;


import dataBase.Get;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaderElement {
    public int valueButtons;
    public int valuePanles;

    //После инициализации экземпляра LoaderElement я должен знать сколько там чего лежит
    LoaderElement() throws SQLException {
        Get get = new Get();
        ResultSet resultSetButton = get.runSQL("SELECT id FROM serverList");
        while (resultSetButton.next()){
            valueButtons++;
        }

        ResultSet resultSetPanel = get.runSQL("SELECT id FROM panelList");
        while (resultSetButton.next()){
            valuePanles++;
        }
    }



}
