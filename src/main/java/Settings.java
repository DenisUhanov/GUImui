import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Settings{

    Settings(String file){
        filePath = file;
    }

    String filePath;

    Map<String, String> settingsMap = new HashMap<String,String>();
    Properties saveProperties = new Properties();
    Properties readProperties = new Properties();


    void setDefaultSettings() throws IOException {
        /**
         * Задаем стандартные значение в настройках
         */
        saveProperties.setProperty("konsole","null");
        saveProperties.setProperty("arg","null");
        saveProperties.setProperty("typeBD","null");
        saveProperties.setProperty("host","null");
        saveProperties.setProperty("user","null");
        saveProperties.setProperty("pass","null");

        saveProperties.storeToXML(new FileOutputStream(filePath),"");
    }

    void loadFileSettings() throws IOException {
        /**
         * Загружаем настроки из файла
         */
        try {
            readProperties.loadFromXML(new FileInputStream(filePath));

            if (readProperties.size() != 6){
                windowsError("Не хватает параметров в файле настроек, перезаписываю его на дефолтный","Ошибка");
                 setDefaultSettings();
            }else {
                readSettings();
            }

        }catch (Exception ex){
            //Информация об ошибке
            windowsError(ex.getLocalizedMessage(),"Ошибка");
            setDefaultSettings();
        }

    }

    void readSettings(){
        /**
         * Читаем настройки из файла
         */
        try {
            readProperties.loadFromXML(new FileInputStream(filePath));

            settingsMap.put("konsole", readProperties.getProperty("konsole"));
            settingsMap.put("arg", readProperties.getProperty("arg"));
            settingsMap.put("typeBD", readProperties.getProperty("typeBD"));
            settingsMap.put("host", readProperties.getProperty("host"));
            settingsMap.put("user", readProperties.getProperty("user"));
            settingsMap.put("pass", readProperties.getProperty("pass"));


        }catch (Exception ex){
            windowsError(ex.getLocalizedMessage(),"Ошибка");
        }
    }

    void windowsError(String text, String titleBar){
        JOptionPane.showMessageDialog(null, text,titleBar, JOptionPane.ERROR_MESSAGE);
    }


}
