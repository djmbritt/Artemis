package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.account.AccountFactory;
import com.sbnvw.artemis.account.UserInformation;
import com.sbnvw.artemis.account.UserLogin;
import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
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
    private VBox loginFields;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginBtn;
    @FXML
    private Button forgotID;
    @FXML
    private Button registrationID;
    @FXML
    private Button guestLoginBtn;

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
        pseudoLogin();
    }

    /**
     *
     * @param event
     */
    @FXML
    private void btnForgot(ActionEvent event) {
        MainApp.getMainWindowController().loadCenterPane("/fxml/Forgot_Login_Page.fxml");
    }

    /**
     *
     * @param event
     */
    @FXML
    private void btnRegister(ActionEvent event) {
        System.out.println("LoginPageController.java::btnRegister");
        MainApp.getMainWindowController().loadCenterPane("/fxml/Registration_Page.fxml");

    }

    /**
     *
     * @param event
     */
    @FXML
    public void passLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            pseudoLogin();
        }

    }

    /**
     *
     * @param event
     */
    @FXML
    public void userKeyLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            pseudoLogin();
        }
    }

    private void pseudoLogin() {

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

        } else {
            System.out.println("LOGIN FAILED");
            Alert failedLoginAlert = new Alert(Alert.AlertType.ERROR, "Login failed. Please try again.");
            failedLoginAlert.showAndWait();
        }

    }

    private void login() {

        Boolean areFieldsFilledIn = loginFields
                .getChildren()
                .filtered(node -> node instanceof TextField)
                .filtered(node -> ((TextField) node).getText().isEmpty())
                .isEmpty();

        if (!areFieldsFilledIn) {
            new Alert(Alert.AlertType.ERROR, "Please fill in all fields.").showAndWait();
        } else {
            
            new IOContext(new IOUsers()).load().stream().filter(user -> userNameField.equals(((UserInformation)user).getUserName()));
            
            new IOContext(new IOUsers()).load().forEach(user -> {
                
                if (((UserInformation)user).getUserName().equals(userNameField.getText()) && ((UserInformation)user).getUserPassword().equals(passwordField.getText())) {
                    
                    if (user.getClass().getName().equalsIgnoreCase("user")) {
                        MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
                        MainApp.getMainWindowController().loadCenterPane("/fxml/MainSearchWindow.fxml");
                    }

                    if (user.getClass().getName().equalsIgnoreCase("admin")) {
                        MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
                        MainApp.getMainWindowController().loadCenterPane("/fxml/UserList.fxml");
                    }

                    if (user.getClass().getName().equalsIgnoreCase("sysadmin")) {
                        MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
                        MainApp.getMainWindowController().loadCenterPane("/fxml/UserList.fxml");
                    }
                    
                    return;
                }
            });
        }

    }

    @FXML
    private void btnGuestLogin(ActionEvent event) {

        AccountFactory.createAccount("guest");

        MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
        MainApp.getMainWindowController().loadCenterPane("/fxml/MainSearchWindow.fxml");

    }

}
