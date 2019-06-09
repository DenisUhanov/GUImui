package settings;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static settings.GUI.GUIsettings.windowsError;

/**
 * Gather - место запуска всех настроек
 */
public class Gather {
    //Имя и путь до файла настроек
    String pathFile = "settings.xml";

    //Размер главного окна
    public static int windWdth = 700;
    public static int windHeight = 200;

    //*
    Properties saveProperties = new Properties();
    Properties readProperties = new Properties();

    /**
     * Начинаем работу с настройками
     * @throws IOException
     */
    public void property () throws IOException {
            ToLoad toLoad = new ToLoad();

            //Считываем настройки
            toLoad.read();

        }

    /**
     * ToLoad - считываем данные из файла настроект
     */
    class ToLoad {

        void read() throws IOException {
            /**
             * считываем настроки из файла
             */
            try {
                readProperties.loadFromXML(new FileInputStream(pathFile));

            }catch (Exception ex){
                //Информация об ошибке
                windowsError(ex.getLocalizedMessage());
                //Загружаю дефолтные параметры
                new ToSet().defaultProperty();
            }

        }
    }

    /**
     * ToSet - задаем данные в файл настроек
     */
    class ToSet {

        void defaultProperty() throws IOException {
            /**
             * Задаем стандартные значение в настройках
             */
            saveProperties.setProperty("konsole","null");
            saveProperties.setProperty("arg","null");
            saveProperties.setProperty("typeBD","null");
            saveProperties.setProperty("host","null");
            saveProperties.setProperty("user","null");
            saveProperties.setProperty("pass","null");

            saveProperties.storeToXML(new FileOutputStream(pathFile),"");
            saveProperties.clear();
        }

    }

}
