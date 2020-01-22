import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        MainView theView = new MainView();
        Model theModel = new Model();
        DataBase theDataBase = new DataBase();
        Controller theController = new Controller(theModel, theView, theDataBase);

        theView.setVisible(true);
    }
}
