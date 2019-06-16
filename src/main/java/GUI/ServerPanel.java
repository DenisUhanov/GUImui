package GUI;

import CreateElements.Create;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Собираем из загруженных данных и созданных элементов интерфейс с кнопками
 */
public class ServerPanel {

    public JTabbedPane ServerPanels(JTabbedPane jTabbed) throws SQLException {

        //инициализируем создание кнопок и панелей
        Create create = new Create();
        create.createPanels();
        create.createButtons();

        //внешний цикл по очереди проганяет панели
        for(int p =0; p<create.valuePanles; p++){
            //внутренний прогоняет кнопки и сортирует их по панелям
            for(int b = 0;b<create.valueButtons; b++ ){
                /**
                 * Если номер указанный в параметрах кнопки(в бд) совпадает
                 * с номером панели - добавляем кнопку на панель
                 */
                if (create.buttonPanel.get(b) == p){
                    create.jPanel[p].add(create.jbuttonEnter[b]);
                    create.jPanel[p].add(create.jbuttonCupy[b]);
                    create.jPanel[p].add(create.jbuttonPing[b]);
                    create.jPanel[p].add(create.jbuttonError[b]);
                }
            }
        }

        /**
         *
         * После создание панелей содержащие кнопки, панели можно оберунть в
         * jScrollPanel - это добавить прокрутку к панелям. Далее можно уже
         * помещать созданные обертки с панелями во вкладки jTabbed
         * каждую панель в свою вкладку
         *
         */
        for(int p =0; p<create.valuePanles; p++){
            //обварачиваем их в скролл бары
            JScrollPane jScrollPanel = new JScrollPane(create.jPanel[p]);
            //устанавливаем политики скролл баров
            jScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            jScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            //уст. скорость прокрутки
            jScrollPanel.getVerticalScrollBar().setUnitIncrement(16);

            jTabbed.addTab(create.panelName.get(p),jScrollPanel);
        }
        return jTabbed;
    }
}


