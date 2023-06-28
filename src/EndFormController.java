import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EndFormController implements Initializable {

    public AnchorPane context3;
    public Label winnerLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ArrayList win = ReadyWeaponFormController.getWinner();
        winnerLabel.setText("Player "+win.get(0)+" Win!"+"  Score : "+win.get(1));

    }

    public void playAgainOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) context3.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("MainForm.fxml"))));
        window.setTitle("Battle Field");
    }

}
