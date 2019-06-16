package GUI;

import javax.swing.*;


public class SettingPane {

    //Оповещение об ошибке
    public static void windowsError(String text){
        JOptionPane.showMessageDialog(null, text,"БИБА!!", JOptionPane.ERROR_MESSAGE);
    }

}
