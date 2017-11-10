import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class CalculatorController {

    private CalculatorModel model;

    @FXML
    private TextField calculatorDisplay;
    @FXML
    private Button button7;

    public CalculatorController(){
        this.model = new CalculatorModel();
    }

    @FXML
    private void processNumber(ActionEvent event){
        // Add to display
        calculatorDisplay.appendText(((Button)event.getSource()).getText());
        updateNum2FromDisplay();
    }

    @FXML
    private void processOperation(ActionEvent event){
        String op = ((Button)event.getSource()).getText();
            double num = model.calculate(op);
            calculatorDisplay.setText("");

            if(op.equals("=")) {
                calculatorDisplay.setText(Double.toString(num));
            }
    }

    @FXML
    private void processClear(ActionEvent event){
        model.clear();
        calculatorDisplay.setText("");
    }

    private void updateDisplay(){
        calculatorDisplay.setText(Double.toString(model.calculate("=")));
    }
    private  void updateNum2FromDisplay(){
        model.setNum2(Double.parseDouble(calculatorDisplay.getText()));
    }
}
