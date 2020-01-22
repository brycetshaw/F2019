import java.util.Scanner;

public class Player {
    private String name;
    private Board board;
    private Player opponent;
    private char mark;

    /**
     * Constructor for Player
     * @param name user input name
     * @param letterX marker (X or O)
     */
    public Player(String name, char letterX) {
        this.name = name;
        this.mark = letterX;
    }

    /**
     * aggregated the board to player
     * @param theBoard
     */
    public void setBoard(Board theBoard) {
        this.board = theBoard;
    }

    /**
     * Ends game if the game is over, else player is prompted to move, board is displayed, opponent is called.
     */
    public void play(){
        if (!(board.xWins() || board.oWins() || board.isFull())) {
            this.makeMove();
            board.display();
            this.opponent.play();
            } else{
            concedeGame(selectWinner());
        }
    }

    private boolean checkValidInput(String[] input){
        try {
            for (int j = 0; j < input.length; j++) {
                int num = Integer.parseInt(input[j]);
                if ((num > 2) || (num < 0)) {
                    System.out.println("invalid response.");
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("invalid response.");
           return false;
        }
        return true;
    }

    private int[] convertResponse(String[] input) {
        int[] output = new int[2];
        for (int j = 0; j < input.length; j++) {
           output[j] = Integer.parseInt(input[j]);
        }
        return output;
    }

    /**
     * Loops until a valid move is played.
     */
    public void makeMove(){
        String[] inputsNeeded = {"row", "col"};
        String[] response = new String[2];
        int[] responseInt = new int[2];
        boolean loopFlag = false;
        Scanner scan = new Scanner(System.in);
        System.out.println(this + " Plays.");
        do {
            do {
                for (int i = 0; i < inputsNeeded.length; i++) {
                    System.out.println(inputsNeeded[i]);
                    response[i] = scan.nextLine();
                }
            } while (! checkValidInput(response));
            responseInt = convertResponse(response);
            loopFlag = board.addMark(responseInt[0], responseInt[1], this.mark);
        } while (! loopFlag);
    }

    /**
     * Associates player to opponent
     * @param opponent
     */
    public void setOpponent(Player opponent){
        this.opponent = opponent;
    }

    /**
     * Identifies the winner of the game.
     * @return game winner
     */
    public Player selectWinner() {
        if(!(board.xWins() || board.oWins())){
            return null;
        }
//        if (((this.mark == Constants.LETTER_X) && board.xWins()) ||
//                ((this.mark == Constants.LETTER_O) && board.oWins())){
//            return this;
//        }
        return this.opponent;
    }

    /**
     * Outputs a game over message
     * @param winner winner of the game (player or null)
     */
    public void concedeGame(Player winner) {
        if(winner == null) {

            System.out.println("No winners, no chicken dinners :(");
            return;
        }
            System.out.println(winner.toString() + " is the winner! \n " +
                    "Winner winner chicken dinner.");
            return;
        }

    public String toString() {
        return this.name + " " + Character.toString(this.mark);
    }
}
