package GUI;

import settings.Gather;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;




public class OtherPanel {

    public JPanel settingPane(JPanel jPanelSettings){
        jPanelSettings.setLayout(new GridLayout(0,4,2,2));

        //Личты для хранения лейблов и полей
        ArrayList<JTextField> listField = new ArrayList<JTextField>();
        ArrayList<JLabel> listLabel = new ArrayList<JLabel>();

        //Создаение полей,лейблов и добавление их в листы
        for(int x = 0; x<=7; x++){
            listField.add(new JTextField());
            listLabel.add(new JLabel());
            //когда закончили
            if(x==7){
                //Добавляем их на панель
                for(int i = 0; i<=7; i++){
                    jPanelSettings.add(listLabel.get(i));
                    jPanelSettings.add(listField.get(i));
                }
            }
        }

        /**
         * Ебаный пиздей,вывод кнопки, полей и лейблов с настройками
         *
         * Зачем я их загоняю в списки если их финальное количество извесно
         */
        listLabel.get(0).setText("Консоль:");
        listField.get(0).setText((String) Gather.readProperties.get("Konsole"));
        listLabel.get(1).setText("Тип БД:");
        listField.get(1).setText((String) Gather.readProperties.get("TypeBD"));
        listLabel.get(2).setText("Аргумент:");
        listField.get(2).setText((String) Gather.readProperties.get("ArgTerminal"));
        listLabel.get(3).setText("Имя БД:");
        listField.get(3).setText((String) Gather.readProperties.get("NameBD"));
        listLabel.get(4).setText("Хост БД:");
        listField.get(4).setText((String) Gather.readProperties.get("HostBD"));
        listLabel.get(5).setText("Пароль от БД:");
        listField.get(5).setText((String) Gather.readProperties.get("PassBD"));
        listLabel.get(6).setText("Пользователь терминала:");
        listField.get(6).setText((String) Gather.readProperties.get("UserTerminal"));
        listLabel.get(7).setText("Пользователь БД:");
        listField.get(7).setText((String) Gather.readProperties.get("UserBD"));

        //Кнопка сохранить
        JButton jButtonSave = new JButton("Сохранить");
        //По нажитию на кнопку
        jButtonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        jPanelSettings.add(jButtonSave);

        return jPanelSettings;
    }


    //Оповещение об ошибке
    public static void windowsError(String text){
        JOptionPane.showMessageDialog(null, text,"Биба, не смогла отработать", JOptionPane.ERROR_MESSAGE);

        JFrame jFrame = new JFrame();
        jFrame.setBounds(600, 600, 700, 200);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.setTitle("GUIMUI Настройки");

        OtherPanel otherPanel = new OtherPanel();
        JPanel jPanel = otherPanel.settingPane(new JPanel());

        jFrame.add(jPanel);
        //System.exit(0);

    }


}