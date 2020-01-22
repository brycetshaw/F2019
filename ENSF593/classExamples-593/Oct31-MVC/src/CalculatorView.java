import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame{

    private JTextField firstnumber = new JTextField(10);
    private JLabel subLable = new JLabel("-");
    private JTextField secondnumber = new JTextField(10);
    private JLabel addLable = new JLabel("+");
    private JButton calcButton = new JButton("Calculate");
    private JTextField solution = new JTextField(10);

    public CalculatorView() {
        JPanel calcPanel = new JPanel();
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calcPanel.add(firstnumber);
        calcPanel.add(subLable);
        calcPanel.add(secondnumber);
        calcPanel.add(calcButton);
        calcPanel.add(solution);
        add(calcPanel);

    }

    void addCalcListener(ActionListener listenForCalcButton){
        calcButton.addActionListener(listenForCalcButton);
    }

    public int getFirstnumber() {
        return getIntFromTestBox(firstnumber);
    }

    public int getSecondnumber() {
        return getIntFromTestBox(secondnumber);
    }

    public void setSolution(int solution) {
        this.solution.setText(solution + "");
    }

    private int getIntFromTestBox(JTextField s){
        return Integer.parseInt(s.getText());
    }

    public void displayErrorMessage (String errorMessage) {
        JOptionPane.showMessageDialog(this,errorMessage);
    }


}
