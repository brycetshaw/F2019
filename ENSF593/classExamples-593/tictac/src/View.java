import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

class View extends JFrame{
    JButton[] knobs;
    JButton newGame;
    JLabel indicator;


    public View(){
        initComponents();
        setLayout();
        setVisible(true);
        pack();
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void initComponents(){
        this.knobs = new JButton[9];
        //TODO: Czy ini kazdego elementu jest potrzebne
        for (int i = 0;i<this.knobs.length;i++) {
            this.knobs[i] = new JButton(" ");

        }
        this.indicator = new JLabel("X");
        this.newGame = new JButton("←");// DEADLINE
        this.newGame.setEnabled(false);

    }

    private void setLayout(){
        /*Tworze i ustawiam LayoutManagera'a*/
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        /*Automatyczne przestrzenie między komponentami*/
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addComponent(newGame, GroupLayout.Alignment.CENTER)
                .addComponent(indicator, GroupLayout.Alignment.CENTER)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(knobs[0])
                                .addComponent(knobs[1])
                                .addComponent(knobs[2]))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(knobs[3])
                                .addComponent(knobs[4])
                                .addComponent(knobs[5]))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(knobs[6])
                                .addComponent(knobs[7])
                                .addComponent(knobs[8])
                        )));

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(newGame)
                .addComponent(indicator)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(knobs[0])
                                .addComponent(knobs[3])
                                .addComponent(knobs[6]))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(knobs[1])
                                .addComponent(knobs[4])
                                .addComponent(knobs[7]))
                        .addGroup(layout.createParallelGroup()
                                .addComponent(knobs[2])
                                .addComponent(knobs[5])
                                .addComponent(knobs[8])
                        )));
    }

    public void changePlayer() {
        String newPlayer = reverseValue(getCurrentPlayerString());
        this.indicator.setText(newPlayer);
    }

    public void winGame() {
        this.indicator.setText(getCurrentPlayerString() + " wygrał!");
        for(JButton knob : this.knobs) {
            knob.setEnabled(false);
        }
        endGame();
    }

    public String reverseValue(String value) {
        if("X".equals(value)) {
            return "O";
        } else if("O".equals(value)) {
            return "X";
        }
        return null;
    }

    public Value reverseValue(Value value) {
        if(value == Value.X) {
            return Value.O;
        } else if (value == Value.O) {
            return Value.X;
        }
        return null;
    }

    public Value getCurrentPlayerValue() {
        if("X".equals(this.indicator.getText())) {
            return Value.X;
        } else if("O".equals(this.indicator.getText())) {
            return Value.O;
        }
        return null;
    }

    public String getCurrentPlayerString() {
        if("X".equals(this.indicator.getText())) {
            return "X";
        } else if("O".equals(this.indicator.getText())) {
            return "O";
        }
        return null;
    }

    void resetGame() {
        this.indicator.setEnabled(true);
    }
    void setNoWinner() {
        this.indicator.setText(null);
    }
    void endGame() {
        this.newGame.setEnabled(true);
    }

}