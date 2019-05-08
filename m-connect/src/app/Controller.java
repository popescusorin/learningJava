package app;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private JFXTextField server;
    @FXML
    private JFXTextField user;
    @FXML
    private JFXTextField password;
    @FXML
    public JFXButton connectButton;
    @FXML
    public JFXButton disconnectButton;

    Snx snx;

    @Override
    public void initialize(URL var1, ResourceBundle var2){
        snx = new Snx();
    }

    @FXML
    private void disconnect(ActionEvent actionEvent) {
        snx.close();
    }

    @FXML
    private void connect(ActionEvent actionEvent) {
        String serverName = server.getText();
        String userName = user.getText();
        String userPassword = password.getText();
        if(userName.isEmpty() || serverName.isEmpty() || userPassword.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("All the fields need to be entered!");
            alert.showAndWait();
            return;
        }
        snx.open(serverName, userName, userPassword);

    }

}
