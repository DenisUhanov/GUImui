package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class SettingPane {

    public void addOtherTabs(JTabbedPane jTabbedPane) {
        JPanel jPanelSettings = new JPanel();
        jPanelSettings.setLayout(new GridLayout(0,4,5,5));

        ArrayList<JLabel> listLabel =new  ArrayList<JLabel>();
        for(int x = 0; x<=7; x++){
            listLabel.add(new JLabel());
            if(x==7){
                System.out.println(x);
                for(int i = 0; i<=7; i++){
                    listLabel.get(i).setText("test");
                    jPanelSettings.add(listLabel.get(i));
                }
            }
        }



        jTabbedPane.addTab("Настройки",jPanelSettings);

    }

    //Оповещение об ошибке
    public static void windowsError(String text){
        JOptionPane.showMessageDialog(null, text,"БИБА!!", JOptionPane.ERROR_MESSAGE);
    }

}