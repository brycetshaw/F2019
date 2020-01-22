import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class B2Listener implements ActionListener{

    MyFrame1 frame;

    B2Listener (MyFrame1 f){
        frame = f;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        //System.out.println("Cancel");
        frame.box.setText("Cancel");
    }

}