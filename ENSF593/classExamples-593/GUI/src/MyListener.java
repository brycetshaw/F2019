import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyListener implements ActionListener {

    JFrame jFrame;
    MyListener(JFrame frame){
        jFrame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        actionEvent.getSource().getText();

    }
}
