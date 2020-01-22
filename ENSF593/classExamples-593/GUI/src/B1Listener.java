import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class B1Listener implements ActionListener{

    MyFrame frame;

    public B1Listener (MyFrame f){
        frame = f;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Submit");
    }

}