package bsu.comp152.webdataonwindowmw;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UniversityController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}