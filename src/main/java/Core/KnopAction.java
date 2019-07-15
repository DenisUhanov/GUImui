package Core;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;

import static TuneUP.Parameter.readProperties;

public class KnopAction {
    static Runtime rt = Runtime.getRuntime();
    DataBase dataBase = new DataBase();


    static void enterAction(String ip, int port, String userSSH) throws IOException {

        String command;
            //Если порт не указан в бд - не используем его при подключении
            if(port != 0){
                command = readProperties.getProperty("terminal") + " "+readProperties.getProperty("arg")+" ssh "+ userSSH +"@" + ip + " -p" + port;
                System.out.println(command);
            }
            else {
                command = readProperties.getProperty("terminal") + " "+readProperties.getProperty("arg")+" ssh "+ userSSH +"@"+ip;
            }
        Process pr = rt.exec(command);
    }

    public static void ipAction(String ip){
        //копируем ip сервера
        StringSelection stringSelection = new StringSelection(ip);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);

    }

    public static void pingAction(String ip) throws IOException {
        String command;
        command= readProperties.getProperty("terminal") + " "+readProperties.getProperty("arg")+" ping "+ip;
        Process pr = rt.exec(command);

    }

    public static void errorAction(){
        //открыть ссылку
    }

    public void addKnopAction() throws SQLException {
        Statement st = DataBase.connection.createStatement();
        st.executeQuery("");
    }

}
