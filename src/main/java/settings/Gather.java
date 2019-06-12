package settings;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static GUI.SettingPane.windowsError;

/**
 * Gather - Основные функции с использованием файла настроек
 */
public class Gather {
    //Имя и путь до файла настроек
    static String pathFile = "settings.xml";

    //*
    static Properties saveProperties = new Properties();
    public static Properties readProperties = new Properties();


    public void read() throws IOException {
        try {
            readProperties.loadFromXML(new FileInputStream(pathFile));


        }catch (Exception ex){
            //Информация об ошибке
            windowsError(ex.getLocalizedMessage());
            //Загружаю дефолтные параметры если возникла ошибка
            String[] param = {"null","null","null","null", "null","null","null",};
            setProperty(param);
        }

    }


    public void setProperty(String[] param) throws IOException {
            /**
             * Задаем стандартные значение в файл настройки
             */
            saveProperties.setProperty("konsole",param[0]);
            saveProperties.setProperty("arg",param[1]);
            saveProperties.setProperty("typeBD",param[2]);
            saveProperties.setProperty("host",param[3]);
            saveProperties.setProperty("bdName",param[4]);
            saveProperties.setProperty("passBD",param[5]);
            saveProperties.setProperty("userBD",param[6]);

            saveProperties.storeToXML(new FileOutputStream(pathFile),"");
            saveProperties.clear();
        }

}
