package Interface;

import Core.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static TuneUP.Parameter.*;

/** Settings класс описывает методы содержащие интерфейс вкладки настроек */
public class Settings {

   /**mainSettings главная панель настроек
    * @return возвращает готовую панель настроект с прокруткой
    * */
   static public JScrollPane mainSettings (){
       JPanel jPanel = new JPanel();

       jPanel.setLayout(new GridLayout(0, 2, 5, 5));

       JLabel terminal = new JLabel("Терминал:");
       final JTextField terminalFie = new JTextField();
       terminalFie.setText(readProperties.getProperty("terminal"));

       jPanel.add(terminal);
       jPanel.add(terminalFie);

       JLabel arg = new JLabel("Аргумент:");
       final JTextField agrFie = new JTextField();
       agrFie.setText(readProperties.getProperty("arg"));
       jPanel.add(arg);
       jPanel.add(agrFie);

       JLabel host = new JLabel("Хост:");
       final JTextField hostFie = new JTextField();
       hostFie.setText(readProperties.getProperty("host"));
       jPanel.add(host);
       jPanel.add(hostFie);

       JLabel nameDB = new JLabel("Имя БД");
       final JTextField nameDBFIE = new JTextField();
       nameDBFIE.setText(readProperties.getProperty("nameDB"));
       jPanel.add(nameDB);
       jPanel.add(nameDBFIE);

       JLabel userBD = new JLabel("Пользователь БД");
       final JTextField userBDFie = new JTextField();
       userBDFie.setText(readProperties.getProperty("userDB"));
       jPanel.add(userBD);
       jPanel.add(userBDFie);

       JLabel passBD = new JLabel("Пароль БД");
       final JTextField passBDFIE = new JTextField();
       passBDFIE.setText(readProperties.getProperty("passDB"));
       jPanel.add(passBD);
       jPanel.add(passBDFIE);

       /**{@value save} кнопка сохранить */
       final JButton save = new JButton("Сохранить");
       save.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               try {
                   setSettings(terminalFie.getText(),agrFie.getText(),hostFie.getText(),nameDBFIE.getText(),userBDFie.getText(),passBDFIE.getText());
                   readSettings();
                   save.setBackground(Color.green);
                   save.setText("Сохранил,перезапускай");


               } catch (IOException e) {
                   e.printStackTrace();
                   DataBase.errorFlag = 7;
                   save.setBackground(Color.red);
                   save.setText("Не могу сохранить");
               }
           }
       });

       /**{@value clear} кнопка очитсить */
       JButton clear = new JButton("Очистить");
       clear.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               terminalFie.setText("");
               agrFie.setText("");
               hostFie.setText("");
               nameDBFIE.setText("");
               userBDFie.setText("");
               passBDFIE.setText("");

           }
       });


       jPanel.add(save);
       jPanel.add(clear);

       return Interface.Preset.jsSet(jPanel);
    }

    /** settingsWindow окно с настрйоками которое открывается когда прозашла ошибка, когда DataBase.errorFlag не ранов 0 */
    public static void settingsWindow(){
        JFrame jFrame = new JFrame();
        jFrame.setBounds(600, 600, 700, 400);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("Возникла ошибка, проверь настройки");
        jFrame.add(Settings.mainSettings());
        jFrame.setVisible(true);
    }
}
