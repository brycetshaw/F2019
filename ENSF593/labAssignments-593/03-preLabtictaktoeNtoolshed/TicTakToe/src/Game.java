
import java.io.*;

//STUDENTS SHOULD ADD CLASS COMMENTS, METHOD COMMENTS, FIELD COMMENTS 


public class Game implements Constants {

    private Board theBoard;
    private Referee theRef;

    /**
     * constructor
     */
    public Game( ) {
        theBoard  = new Board();
    }

    /**
     * invokes referee class
     * @param r
     * @throws IOException
     */
    public void appointReferee(Referee r) throws IOException {
        theRef = r;
        theRef.runTheGame();
    }

    /**
     * initiates game play.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Referee theRef;
        Player xPlayer, oPlayer;
        BufferedReader stdin;
        Game theGame = new Game();
        stdin = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("\nPlease enter the name of the \'X\' player: ");
        String name= stdin.readLine();
        while (name == null || name.length() < 1) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

        xPlayer = new Player(name, LETTER_X);
        xPlayer.setBoard(theGame.theBoard);

        System.out.print("\nPlease enter the name of the \'O\' player: ");
        name = stdin.readLine();
        while (name == null || name.length() < 1) {
            System.out.print("Please try again: ");
            name = stdin.readLine();
        }

        oPlayer = new Player(name, LETTER_O);
        oPlayer.setBoard(theGame.theBoard);

        theRef = new Referee();
        theRef.setBoard(theGame.theBoard);
        theRef.setoPlayer(oPlayer);
        theRef.setxPlayer(xPlayer);

        theGame.appointReferee(theRef);
    }


}