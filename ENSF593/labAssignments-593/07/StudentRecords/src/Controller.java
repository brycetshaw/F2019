
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {

    private Model theModel;
    private MainView theView;

    public Controller(Model theModel, MainView theView, DataBase theDatabase) {

        this.theModel = theModel;
        this.theModel.addDataBase(theDatabase);
        this.theView = theView;

        theView.addInsertListener(new InsertButtonListener());
        theView.addFindListener(new FindButtonListener());
        theView.addBrowseListener(new BrowseListener());
        theView.addInputFileListener(new InputFileListener());
    }

    public Controller(Model theModel, MainView theView) {

        this.theModel = theModel;
        this.theView = theView;

        theView.addInsertListener(new InsertButtonListener());
        theView.addFindListener(new FindButtonListener());
        theView.addBrowseListener(new BrowseListener());
        theView.addInputFileListener(new InputFileListener());
    }

    public String fillDataWindow(String flag){
        return theModel.getData(flag);
    }

    private class InsertButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                NewStudentView newStudentView = new NewStudentView();
                NewStudentController newStudentController= new NewStudentController(theModel, newStudentView, new Controller(theModel, theView));
                newStudentView.setVisible(true);

            }  catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }

    private class FindButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                System.out.println("find");
                theView.displayStudentDetails(theModel.getData(theView.getID().strip()));
//                theModel.addInputFile(theView.getInputFilename());

            }  catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }

    private class BrowseListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                System.out.println("browse");
//                theModel.addInputFile(theView.getInputFilename());
                theView.setDataPaneContents(theModel.getData("*"));

            }  catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }



    private class InputFileListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {

                theModel.addInputFile(theView.getInputFilename());


            }  catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }

    public void setVisible(boolean flag){
        theView.setVisible(flag);
    }
}

