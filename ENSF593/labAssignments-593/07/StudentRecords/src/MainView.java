import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainView extends JFrame {

    private JLabel titleLabel = new JLabel("An application to Maintain Student Records",SwingConstants.CENTER);
    private JTextPane dataWindow = new JTextPane();

    private JButton insertButton = new JButton("Insert");
    private JButton findButton = new JButton("Find");
    private JButton browseButton = new JButton("Browse");
    private JButton fromFileButton = new JButton("Create Tree From File");

    public MainView() {
        super("Main Window");
        setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        setSize(800, 400);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(BorderLayout.NORTH, titleLabel);
        dataWindow.setBounds(10,10,700,300);
        dataWindow.setPreferredSize(new Dimension(700,300));

        buttonPanel.add(insertButton);
        buttonPanel.add(findButton);
        buttonPanel.add(browseButton);
        buttonPanel.add(fromFileButton);
//        add(dataPanel);
        JScrollPane scroll = new JScrollPane (dataWindow,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        add(BorderLayout.CENTER, scroll);
        add(BorderLayout.PAGE_END, buttonPanel);

    }

    void addInsertListener(ActionListener actionListener) {
        insertButton.addActionListener(actionListener);
    }

    void addFindListener(ActionListener actionListener) {
        findButton.addActionListener(actionListener);
    }

    void addBrowseListener(ActionListener actionListener) {
        browseButton.addActionListener(actionListener);
    }

    void addInputFileListener(ActionListener actionListener) {
        fromFileButton.addActionListener(actionListener);
    }

    public String getInputFilename() {
        return JOptionPane.showInputDialog("Please input file name. ", "input.txt");
    }

    public String getID() {
        return JOptionPane.showInputDialog("Please enter the student's ID");
    }

    private String getStringFromTestBox(JTextField s) {
        //TODO input error checking... must end in .txt, use valid characters.
        return s.getText();
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }


    public void setDataPaneContents(String data) {
        dataWindow.setText(data);
    }

    public void displayStudentDetails(String data) {
        JOptionPane.showMessageDialog(this, data);
    }

    public String[] getNewStudent() {
        System.out.println("how");
        JFrame newStudentFrame = new JFrame();
        JLabel title = new JLabel("Insert a new Node",SwingConstants.CENTER);
        JLabel stID = new JLabel("Insert a new Node",SwingConstants.CENTER);
        JLabel stFac = new JLabel("Enter Facility",SwingConstants.CENTER);
        JLabel stMajor = new JLabel("Enter Student's Major",SwingConstants.CENTER);
        JLabel stYear = new JLabel("Enter Year",SwingConstants.CENTER);

        JTextField id = new JTextField(10);
        JTextField facility = new JTextField(10);
        JTextField major = new JTextField(10);
        JTextField year = new JTextField(10);
        newStudentFrame.add(title, SwingConstants.NORTH);
        newStudentFrame.add(stID, SwingConstants.NEXT);
        newStudentFrame.add(id,SwingConstants.HORIZONTAL);
        newStudentFrame.add(stFac, SwingConstants.NEXT);
        newStudentFrame.add(facility,SwingConstants.HORIZONTAL);
        newStudentFrame.add(stMajor, SwingConstants.NEXT);
        newStudentFrame.add(major,SwingConstants.HORIZONTAL);
        newStudentFrame.add(stYear, SwingConstants.NEXT);
        newStudentFrame.add(year,SwingConstants.HORIZONTAL);


        System.out.println("are");

        JOptionPane.showMessageDialog(this, newStudentFrame);
        String[] newStu = new String[4];
        newStu[0] = id.getText();
        newStu[1] = facility.getText();
        newStu[2] = major.getText();
        newStu[3] = year.getText();
        System.out.println("you");
        return newStu;
    }
}