import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {

    public AnchorPane context;

    public void startGameOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) context.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("ReadyWeaponForm.fxml"))));
        window.setTitle("Battle Field");


    }
}
