package settings;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Gather - Основные функции с использованием файла настроек
 */
public class Gather {
    //Имя и путь до файла настроек
    static String pathFile = "settings.xml";

    //*
    static Properties saveProperties = new Properties();
    public static Properties readProperties = new Properties();


    public static void readAll() throws IOException {
        try {
            readProperties.loadFromXML(new FileInputStream(pathFile));


        }catch (Exception ex){
            //Информация об ошибке
            GUI.OtherPanel.windowsError(ex.getLocalizedMessage());
            //Загружаю дефолтные параметры если возникла ошибка
            String[] param = {"null","null","null","null", "null","null","null","null"};
            setProperty(param);
        }
    }


    public static void setProperty(String[] param) throws IOException {
        /**
        * Задаем стандартные значение в файл настройки
        */
        saveProperties.setProperty("UserBD",param[0]);
        saveProperties.setProperty("PassBD",param[1]);
        saveProperties.setProperty("HostBD",param[2]);
        saveProperties.setProperty("NameBD",param[3]);
        saveProperties.setProperty("TypeBD",param[4]);
        saveProperties.setProperty("Konsole",param[5]);
        saveProperties.setProperty("ArgTerminal",param[6]);
        saveProperties.setProperty("UserTerminal",param[7]);
        saveProperties.storeToXML(new FileOutputStream(pathFile),"");
        saveProperties.clear();
    }

}
