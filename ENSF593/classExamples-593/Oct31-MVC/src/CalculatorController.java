import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {
    private CalculatorModel theModel;
    private CalculatorView theView;

    public CalculatorController(CalculatorModel theModel, CalculatorView theView){
        this.theModel = theModel;
        this.theView = theView;
        theView.addCalcListener(new CalculateListener());
    }

    private class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                int[] numbers = new int[2];
                numbers[0] = theView.getFirstnumber();
                numbers[1] = theView.getSecondnumber(); //step 1- get values from the view
                theModel.subTwoNumbers(numbers[0], numbers[1]); // step 2- send the values to the model
                theView.setSolution(theModel.getValue());
            } catch (NumberFormatException e) {
                theView.displayErrorMessage("You need two integers!!!");
            } catch (Exception e) {
                theView.displayErrorMessage("error :(");
            }
        }
    }



}

