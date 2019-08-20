package Interface;

import javax.swing.*;
import java.awt.*;

/** Preset Класс описывает методы "пресеты" для создания панелей. */
public class Preset {

    /**jsSet метод добавляющий на панель прокрутку
     * @param jPanel панель к которой нужно добавить прокрутку
     * @return jScrollPane возвращает панель у оболочке jScrollPane с установленной прокруткой
     * */
    static public JScrollPane jsSet (JPanel jPanel){
        JScrollPane jScrollPane = new JScrollPane(jPanel);

        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //уст. скорость прокрутки
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        return  jScrollPane;
    }

      /**readyPanel метод добавляющий дефолтный GridLayout для панелей
       * @param jPanel принимает панель к которой нужно добавить GridLayout
       * @return помещает принимаему панель в jsSet и возвращает
       * панель с заданым GridLayout и прокруткой
       * */
    static public JScrollPane readyPanel (JPanel jPanel ) {

        jPanel.setLayout(new GridLayout(0, 5, 5, 5));

        return Interface.Preset.jsSet(jPanel);
    }
}