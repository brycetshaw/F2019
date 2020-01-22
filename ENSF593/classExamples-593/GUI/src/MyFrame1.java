import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame1  extends JFrame{

    private JButton b1, b2;
    JTextArea box;

    public MyFrame1 (String s) {
        super(s);
        //layout should go first
        setLayout(new BorderLayout());
        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");
        box = new JTextArea();
        add("North", b1);
        add("Center", b2);
        add("South", box);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("submit");
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Cancel");
            }
        });
    }

    public static void main (String [] args) {

        MyFrame1 frame = new MyFrame1 ("Frame 1");
        frame.setVisible(true);
        frame.pack();

    }

}