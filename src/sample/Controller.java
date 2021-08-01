package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import javafx.event.ActionEvent;

public class Controller {

    @FXML
    private Text output;            // вывод

    private int number1, number2;   // числа
    private boolean flagOperation;  // флаг на действия
    private String operator = "";
    private Model model = new Model();


    @FXML
    private void processNumber(ActionEvent event) {
        if (flagOperation) {
            output.setText("");
            flagOperation = false;
        }
        String value = ((Button) event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    @FXML
    private void processOperation(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            number1 = Integer.parseInt(output.getText());
            output.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            output.setText(String.valueOf(model.calculation(number1, Integer.parseInt(output.getText()), operator)));
            operator = "";
            flagOperation = true;
        }
    }

}
