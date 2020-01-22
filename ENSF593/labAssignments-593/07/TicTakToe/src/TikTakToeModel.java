public class TikTakToeModel {
    private Player oPlayer, xPlayer, currentPlayer;
    private Board board;
    private TikTakToeView theView;

    public TikTakToeModel(TikTakToeView theView) {
        this.theView = theView; // I'm so sorry for breaking the MVC model.. it was so tidy until just now.
    }

    public void setGame(int[] gameType) {
        this.board = new Board(theView);
        if (gameType[0] == 0) {
            xPlayer = new HumanPlayer("Human 1", Constants.LETTER_X);
        } else {
            xPlayer = new SmartPlayer("Robot 1", Constants.LETTER_X);
        }

        if (gameType[1] == 0) {
            oPlayer = new HumanPlayer("Human 2", Constants.LETTER_O);
        } else {
            oPlayer = new SmartPlayer("Robot 1", Constants.LETTER_O);
        }
        runTheGame();
    }


    public void markBoard(int i, int j, char theMark) {
        this.board.addMark(i, j, theMark);
    }


    public void runTheGame() {
        oPlayer.setOpponent(xPlayer);
        xPlayer.setOpponent(oPlayer);
        oPlayer.setBoard(board);
        xPlayer.setBoard(board);
        xPlayer.play();
    }

    public Player getCurrentPlayer() {
        return (board.getMarkCount() % 2 == 0) ? xPlayer : oPlayer;
    }
}

