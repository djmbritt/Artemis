package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class LoginPageController implements Initializable {

    private final String adminName = "Admin";
    private final String adminPass = "Admin";

    @FXML
    private VBox loginPage;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginBtn;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    /**
     *
     * @param event
     */
    @FXML
    public void btnLogin(ActionEvent event) {
        login();
    }

    /**
     *
     * @param event
     */
    @FXML
    public void passLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login();
        }

    }

    /**
     *
     * @param event
     */
    @FXML
    public void userLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login();
        }
    }

    private void login() {

        String userName;
        String passWord;

        if (userNameField.getText().isEmpty()) {
            userName = "";
        } else {
            userName = userNameField.getText();
        }

        if (passwordField.getText().isEmpty()) {
            passWord = "";
        } else {
            passWord = passwordField.getText();
        }

        if (userName.equals(adminName) && passWord.equals(adminPass)) {
            System.out.println("LOGIN!!");
            MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
            MainApp.getMainWindowController().loadCenterPane("/fxml/MainSearchWindow.fxml");
        } else {
            System.out.println("LOGIN FAILED");
        }

    }
    
}
