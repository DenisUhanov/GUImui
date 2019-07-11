package Core;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class Knob {
    Prepere prepere = new Prepere();

    public ArrayList<JButton> enter = new ArrayList<>();
    public ArrayList<JButton> ip = new ArrayList<>();
    public ArrayList<JButton> ping = new ArrayList<>();
    public ArrayList<JButton> error = new ArrayList<>();

    public void createKnob() throws SQLException {
        while (prepere.serverParam.next()){
            enter.add(new JButton(prepere.serverParam.getString("nameserver")));
            ip.add(new JButton(prepere.serverParam.getString("ip")));
            ping.add(new JButton("Ping"));
            error.add(new JButton("Инциндент"));
        }

        for(int i = 0; i< enter.size(); i++){
            //Вход на сервер
            enter.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("enter");
                }
            });

            //Скопировать IP
            ip.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("ip");
                }
            });

            //Пингануть
            ping.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("ping");
                }
            });

            //Открыть задачу в редмайне
            error.get(i).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("error");
                }
            });
        }
    }


    public void createPanel(){

    }

}
