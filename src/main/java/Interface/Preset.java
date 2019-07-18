package Interface;

import javax.swing.*;
import java.awt.*;

public class Preset {

    static public JScrollPane jsSet (JPanel jPanel){
        JScrollPane jScrollPane = new JScrollPane(jPanel);

        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //уст. скорость прокрутки
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        return  jScrollPane;
    }

      //пресет панелей, возвращает готовую панель с прокруткой
    static public JScrollPane readyPanel (JPanel jPanel ) {

        jPanel.setLayout(new GridLayout(0, 5, 5, 5));

        return Interface.Preset.jsSet(jPanel);
    }
}