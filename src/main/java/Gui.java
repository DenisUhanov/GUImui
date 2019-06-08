import javax.swing.*;

public class Gui {
   static void action (int width,int height){
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        jFrame.setBounds(500,500,width,height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        jFrame.revalidate();
    }

    /**
     *
     * @param jTabbedPane в эти вкладки будем насовывать панели
     */
    void panelLoad (JTabbedPane jTabbedPane){


    }
}
