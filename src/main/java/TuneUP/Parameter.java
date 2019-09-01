package TuneUP;

import Core.DataBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/***
 * Класс работающий с настройками
 */
public class Parameter {


    public static Map<String, String> settingsMap = new HashMap<String,String>();
    /**saveProperties обьект для сохранения настроек*/
    public static Properties saveProperties = new Properties();

    /**readProperties объект дял загрузки настроек*/
    public static Properties readProperties = new Properties();

    /**filePath файл в котором хранятся настройки*/
    static String filePath = "settings.xml";

    /** Метод читающий настройки из файла settings.xml и заносящий их в Карту settingsMap
     *
     * */
    public static void readSettings() {
        try {
            /** Считываем настроки  */
            readProperties.loadFromXML(new FileInputStream(filePath));

            /** Закидываем значение в Карту */
            settingsMap.put("terminal", readProperties.getProperty("terminal"));
            settingsMap.put("arg", readProperties.getProperty("arg"));
            settingsMap.put("host", readProperties.getProperty("host"));
            settingsMap.put("nameDB", readProperties.getProperty("nameDB"));
            settingsMap.put("userBD", readProperties.getProperty("userDB"));
            settingsMap.put("passBD", readProperties.getProperty("passDB"));


        } catch (Exception ex) {
            /**  */
           DataBase.errorFlag = 6;

        }
    }

    public static void setSettings(String terminal,String arg,String host,String nameDB,String userDB,String passDB) throws IOException {
        /*** Задаем стандартные значение в настройках */

        saveProperties.setProperty("terminal",terminal);
        saveProperties.setProperty("arg",arg);
        saveProperties.setProperty("host",host);
        saveProperties.setProperty("nameDB",nameDB);
        saveProperties.setProperty("userDB",userDB);
        saveProperties.setProperty("passDB",passDB);

        saveProperties.storeToXML(new FileOutputStream(filePath),"");
    }
}