package loaders;


import dataBase.Get;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaderElement {
    public int valueButtons;
    public int valuePanles;

    //После инициализации экземпляра LoaderElement я должен знать сколько там чего лежит
    public LoaderElement() throws SQLException {
        Get get = new Get();
        ResultSet resultSetButton = get.runSQL("SELECT id FROM serverList");
        while (resultSetButton.next()){
            valueButtons++;
        }

        ResultSet resultSetPanel = get.runSQL("SELECT id FROM panelList");
        while (resultSetPanel.next()){
            valuePanles++;

        }
    }

    public JTabbedPane jPanelArray (){
        //массив под панели
        JPanel jPanel[] = new JPanel[valuePanles];
        //Подготовка к обертке с прокруткой для панелей
        JScrollPane jScrollPane = null;

        //позволяет добавлять элементы в отдельные вкладки.
        JTabbedPane jTabbed = new JTabbedPane();
        /**
         * создаем цикл который загоняет панели в обертку
         * с прокруткой и далее в обхект с вкладками
         * возвращаем объект с готовыми вкладками в которых панели с прокруткой
         */
        for (int i=0;i<valuePanles; i++){
                //добавляем панели в обертку с прокруткой
                jScrollPane = new JScrollPane(jPanel[i]);
                //устанавливаем политики скролл баров
                jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                //уст. скорость прокрутки
                jScrollPane.getVerticalScrollBar().setUnitIncrement(16);
                //добавляем панели с прокруткой в объект со вкладками
                jTabbed.addTab("text",jScrollPane);


            }
        return  jTabbed;
    }



}
