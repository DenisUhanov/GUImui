package Interface;

import Core.DataBase;
import Core.Knop;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/*** WindowMain Класс описывающий вкладку Сервера*/
public class WindowMain {

    /**@value presetJP объект для применения "пресетов" к панелям.
     * @see Interface.Preset
     * */
    Preset presetJP = new Preset();

    /**@value knop объект для создания кнопок с серверами
     * @see Core.Knop
     * */
    Knop knop = new Knop();

    /**globalTabled метод собирающий JTabbedPane - Сервера
     * @param jTabbedPane принимает JTabbedPane и добавляет в него вкладки
     * @return отдает готовый JTabbedPane со вкладками
     * */
    public JTabbedPane globalTabled (JTabbedPane jTabbedPane) throws SQLException {
        //опять подключение к БД
        DataBase dataBase = new DataBase();

        //Выполняем SQL
        ResultSet panelParam = dataBase.runSQL("SELECT * FROM panelParam");

        /**Производим сборку и фасовку панелей в цикле
         * Пока есть панели - добавляем в них кнопки
         * id панели должно совпадать с id панели которое указано в БД кнпоки
         * */
        while (panelParam.next()){
            JPanel jPanel = new JPanel();
            knop.getKnops(panelParam.getInt("id"),jPanel);
            jTabbedPane.addTab(panelParam.getInt("id")+": "+panelParam.getString("namepanel"),Interface.Preset.readyPanel(jPanel));

        }

        return jTabbedPane;
    }
}