package CreateElements;

import loaders.LoaderElement;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

/**
 * Описываем создание массов под кнопки,панели и создаем непосредственно их
 */
public class Create extends LoaderElement {
    public Create() throws SQLException {
    }
    //Выделяем место под кнопки в массиве
    public JButton[] jbuttonEnter = new JButton[valueButtons];
    public JButton[] jbuttonCupy = new JButton[valueButtons];
    public JButton[] jbuttonPing = new JButton[valueButtons];
    public JButton[] jbuttonError = new JButton[valueButtons];
    //место под панели
    public JPanel[] jPanel = new JPanel[valuePanles];

    /**
     * создаем панели и присваиваем им стиль
     */
    public void createPanels(){
        for(int p = 0; p<valuePanles;p++){
            jPanel[p]=new JPanel(new GridLayout(0,4,5,5));

        }
    }

    /**
     * Создаем кнопки и экшены
     */
    public void createButtons(){
        for(int b = 0; b<valueButtons;b++){
            jbuttonEnter[b] = new JButton(buttonName.get(b));
            jbuttonCupy[b] = new JButton(buttonIP.get(b));
            jbuttonPing[b] = new JButton("Ping");
            jbuttonError[b] = new JButton("Инциндент");
        }
    }
}


