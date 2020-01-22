import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGame extends JFrame {

    private JComboBox<String> p1;
    private JComboBox<String> p2;
    private JButton go;

    public NewGame() {
        super("Pick player types!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLayout(new BorderLayout());
        String[] playerOptions = {"Human", "Computer Smart"};
        JTextArea p1text = new JTextArea("Player 1");
        JTextArea p2text = new JTextArea("Player 2");
        this.p1 = new JComboBox(playerOptions);
        this.p2 = new JComboBox(playerOptions);
        this.go = new JButton("Go!");
        p1.setSelectedIndex(0);
        p2.setSelectedIndex(1);
        add(p1text, BorderLayout.NORTH);
        add(p2text, BorderLayout.CENTER);
        add(p1,BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
        add(go, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }

    public void addGoListener(ActionListener actionListener) {
        go.addActionListener(actionListener);
    }

    public int[] getGameType() {
        int[] gameType = new int[2];
        gameType[0] = p1.getSelectedIndex();
        gameType[1] =p2.getSelectedIndex();
        return gameType;
    }
}
