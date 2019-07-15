package Interface;

import javax.swing.*;
import java.awt.*;

public class Preset {
      //пресет панелей, возвращает готовую панель с прокруткой
    static public JScrollPane readyPanel (JPanel jPanel ) {

        jPanel.setLayout(new GridLayout(0, 4, 5, 5));
        JScrollPane jScrollPane = new JScrollPane(jPanel);

        //устанавливаем политики скролл баров
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //уст. скорость прокрутки
        jScrollPane.getVerticalScrollBar().setUnitIncrement(16);

        return jScrollPane;
    }
}
