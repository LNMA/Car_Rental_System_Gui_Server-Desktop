package clientfx;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;

public class ControllerNotifyBill {
    public Label massage1;
    public Label massage2;
    public Label massage3;

    public void OK(ActionEvent actionEvent) {
        ControllerMakeAnOrder.alertStage.close();
    }

    public void initialize(){
       massage1.setText(ControllerMakeAnOrder.massage);
       massage2.setText(ControllerMakeAnOrder.massageBills);
       massage3.setText(ControllerMakeAnOrder.massageDiscountBills);
    }
}
