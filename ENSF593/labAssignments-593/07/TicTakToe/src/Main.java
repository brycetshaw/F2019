public class Main {

    public static void main(String[] args) {

        TikTakToeView theView = new TikTakToeView();

        TikTakToeModel theModel = new TikTakToeModel(theView);

        TikTakToeController theController = new TikTakToeController(theModel, theView);


    }
}
