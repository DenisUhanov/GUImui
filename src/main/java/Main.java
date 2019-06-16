import dataBase.Get;
import loaders.LoaderElement;
import settings.Gather;
import javax.swing.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main {
    public static void main(String[] argv) throws IOException, SQLException {

        //получить настроки
        settings.Gather gather = new Gather();
        gather.read();

        JFrame jFrame = new JFrame();
        jFrame.setBounds(600, 600, 700, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LoaderElement loaderElement = new LoaderElement();
        jFrame.add(loaderElement.jPanelArray());

        jFrame.setVisible(true);

    }
}

