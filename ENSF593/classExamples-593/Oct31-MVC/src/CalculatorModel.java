import javax.swing.*;

public class CalculatorModel {

    private int value;

    public void subTwoNumbers(int a, int b){
        value = a -b;
    }

    public int getValue() {
        return value;
    }
}
