
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewStudentController {

    private Model theModel;
    private NewStudentView theView;
    private Controller ogController;

    public NewStudentController(Model theModel, NewStudentView theView, Controller ogController) {

        this.theModel = theModel;
        this.theView = theView;
        this.ogController = ogController;

        theView.addGoListener(new GoButtonListener());
        theView.addReturnListener(new ReturnButtonListener());

    }


    private class GoButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                System.out.println("go button pressed!");
                String[] response = new String[4];
                response = theView.getResponse();
                theModel.insert(response[0], response[1], response[2], response[3]);
                theView.setVisible(false);
                ogController.setVisible(true);

            }  catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }

    private class ReturnButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
               theView.setVisible(false);

            }  catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }



}

