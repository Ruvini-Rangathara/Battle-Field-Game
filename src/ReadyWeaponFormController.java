import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class ReadyWeaponFormController{

    public AnchorPane context2;

    public CheckBox playerAT56;
    public CheckBox playerATank;
    public CheckBox playerAMultiBarrel;
    public CheckBox playerAPistol;
    public CheckBox playerABomb;

    public CheckBox playerBT56;
    public CheckBox playerBTank;
    public CheckBox playerBMultiBarrel;
    public CheckBox playerBPistol;
    public CheckBox playerBBomb;

    public Button battleStartBtn;

    static int a=0;
    static int b=0;

    static ArrayList win = new ArrayList();

    private ObservableSet<CheckBox> selectedCheckBoxesA = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxesA = FXCollections.observableSet();

    private ObservableSet<CheckBox> selectedCheckBoxesB = FXCollections.observableSet();
    private ObservableSet<CheckBox> unselectedCheckBoxesB = FXCollections.observableSet();

    private IntegerBinding numCheckBoxesSelectedA = Bindings.size(selectedCheckBoxesA);
    private IntegerBinding numCheckBoxesSelectedB = Bindings.size(selectedCheckBoxesB);
    private int maxNumSelected =  3;

    public void initialize(){
        battleStartBtn.setDisable(true);

        configureCheckBoxA(playerAT56);
        configureCheckBoxA(playerATank);
        configureCheckBoxA(playerAMultiBarrel);
        configureCheckBoxA(playerAPistol);
        configureCheckBoxA(playerABomb);

        configureCheckBoxB(playerBT56);
        configureCheckBoxB(playerBTank);
        configureCheckBoxB(playerBMultiBarrel);
        configureCheckBoxB(playerBPistol);
        configureCheckBoxB(playerBBomb);

        numCheckBoxesSelectedA.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            if (newSelectedCount.intValue() >= maxNumSelected) {
                unselectedCheckBoxesA.forEach(cb -> cb.setDisable(true));
            } else {
                unselectedCheckBoxesA.forEach(cb -> cb.setDisable(false));
            }
        });

        numCheckBoxesSelectedB.addListener((obs, oldSelectedCount, newSelectedCount) -> {
            if (newSelectedCount.intValue() >= maxNumSelected) {
                unselectedCheckBoxesB.forEach(cb -> cb.setDisable(true));
            } else {
                unselectedCheckBoxesB.forEach(cb -> cb.setDisable(false));
            }
        });


    }

    private void configureCheckBoxA(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            selectedCheckBoxesA.add(checkBox);
        } else {
            unselectedCheckBoxesA.add(checkBox);
        }
        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxesA.remove(checkBox);
                selectedCheckBoxesA.add(checkBox);
            } else {
                selectedCheckBoxesA.remove(checkBox);
                unselectedCheckBoxesA.add(checkBox);
            }
        });

    }


    private void configureCheckBoxB(CheckBox checkBox) {
        if (checkBox.isSelected()) {
            selectedCheckBoxesB.add(checkBox);
        } else {
            unselectedCheckBoxesB.add(checkBox);
        }
        checkBox.selectedProperty().addListener((obs, wasSelected, isNowSelected) -> {
            if (isNowSelected) {
                unselectedCheckBoxesB.remove(checkBox);
                selectedCheckBoxesB.add(checkBox);
            } else {
                selectedCheckBoxesB.remove(checkBox);
                unselectedCheckBoxesB.add(checkBox);
            }
        });
    }

    public void battleStartOnAction(ActionEvent actionEvent) throws IOException {
        PlayerAWeaponStore aStore = new PlayerAWeaponStore();
        if(playerAT56.isSelected()){
            aStore.playerAWeapon.add("T56");
        }if(playerATank.isSelected()){
            aStore.playerAWeapon.add("Tank");
        }if(playerAMultiBarrel.isSelected()){
            aStore.playerAWeapon.add("Multi Barrel");
        }if(playerAPistol.isSelected()){
            aStore.playerAWeapon.add("Pistol");
        }if(playerABomb.isSelected()){
            aStore.playerAWeapon.add("Bomb");
        }

        PlayerBWeaponStore bStore = new PlayerBWeaponStore();
        if(playerBT56.isSelected()){
            bStore.playerBWeapon.add("T56");
        }if(playerBTank.isSelected()){
            bStore.playerBWeapon.add("Tank");
        }if(playerBMultiBarrel.isSelected()){
            bStore.playerBWeapon.add("MultiBarrel");
        }if(playerBPistol.isSelected()){
            bStore.playerBWeapon.add("Pistol");
        }if(playerBBomb.isSelected()){
            bStore.playerBWeapon.add("Bomb");
        }

        a = aStore.scoreCalculate();
        b = bStore.scoreCalculate();

        Stage window = (Stage) context2.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader
                .load(getClass().getResource("EndForm.fxml"))));
        window.setTitle("Battle Field");
    }

     public static ArrayList getWinner(){
         if(a>b){
             win.add(0,"A");
             win.add(1,a);
         }else{
             win.add(0,"B");
             win.add(1,b);
         }
         return win;
     }

    public void btnSetEnabled(){
        if(selectedCheckBoxesA.size()==3 && selectedCheckBoxesB.size()==3){
            battleStartBtn.setDisable(false);
        }else{
            battleStartBtn.setDisable(true);
        }
    }

    public void playerAT56OnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerATankOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerAMultiBarrelOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerAPistolOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerABombOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerBT56OnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerBTankOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerBMultiBarrelOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerBPistolOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }

    public void playerBBombOnAction(ActionEvent actionEvent) {
        btnSetEnabled();
    }
}
