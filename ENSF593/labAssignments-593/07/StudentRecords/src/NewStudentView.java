import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class NewStudentView extends JFrame {

    private JLabel titleLabel = new JLabel("Insert a new Node",SwingConstants.CENTER);
    private JLabel stID = new JLabel("Insert a new Node",SwingConstants.LEFT);
    private JLabel stFac = new JLabel("Enter Facility",SwingConstants.LEFT);
    private JLabel stMajor = new JLabel("Enter Student's Major",SwingConstants.LEFT);
    private JLabel stYear = new JLabel("Enter Year",SwingConstants.LEFT);

    private JTextField id = new JTextField(10);
    private JTextField facility = new JTextField(10);
    private JTextField major = new JTextField(10);
    private JTextField year = new JTextField(10);

    private JButton goButton = new JButton("Insert");
    private JButton returnButton = new JButton("Return");

    public NewStudentView() {
        super("Add a New Node");
        setLayout(new GridLayout(5,2));
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(stID);
        add(id);

        add( stFac);
        add( facility);

        add(stMajor);
        add( major);

        add(stYear);
        add( year);
        add(goButton);
        add(returnButton);
        pack();



    }

    void addGoListener(ActionListener actionListener) {
        goButton.addActionListener(actionListener);
    }

    void addReturnListener(ActionListener actionListener) {
        returnButton.addActionListener(actionListener);
    }

    public String[] getResponse() {
        String[] r = new String[4];
        r[0] = id.getText();
        r[1] = facility.getText();
        r[2] = major.getText();
        r[3] = year.getText();

        for (String s: r) {
            if(s.length() == 0){
                return null;
            }
        }
        return r;
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
