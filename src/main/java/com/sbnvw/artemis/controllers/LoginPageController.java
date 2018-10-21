package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import com.sbnvw.artemis.account.AccountFactory;
import com.sbnvw.artemis.account.UserInformation;
import com.sbnvw.artemis.account.UserLogin;
import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Button loginID;
    @FXML
    private Button forgotID;
    @FXML
    private Button registrationID;
    @FXML
    private Button guestLoginID;

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
            login();
        }

    }

    @FXML
    private void btnGuestLogin(ActionEvent event) {

        AccountFactory.createAccount("guest");

        MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
        MainApp.getMainWindowController().loadCenterPane("/fxml/MainSearchWindow.fxml");

    }

    /**
     *
     * @param event
     */
    @FXML
    public void userKeyLogin(KeyEvent event) {
        if (event.getCode().equals(KeyCode.ENTER)) {
            login();
        }
    }

    private void login() {
        
        if (true) {
            MainApp.getMainWindowController().loadCenterPane("/fxml/MainSearchWindow.fxml");
            MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
        }
        
        
        //THE CODE THAT IS COMMENTED DOES NOT WORK AS IT SHOULD AT THIS POINT.
        //DAVID SHOULD HAVE A LOOK AT THIS BEFORE WE SUBMIT IT. FOR NOW WE JUST
        //LOG IN TO THE MAIN PAGE.
//
//        ObservableList<UserLogin> userList = FXCollections.observableArrayList();
//        userList.addAll(new IOContext(new IOUsers()).load());
//
//        Boolean areFieldsFilledIn = loginFields.getChildren().filtered(node -> node instanceof TextField).filtered(node -> ((TextField) node).getText().isEmpty()).isEmpty();
//        Boolean checkLogin = userList.stream().anyMatch(user -> userNameField.getText().equals(((UserInformation) user).getEmail()) && passwordField.getText().equals(((UserLogin) user).getPassword()));
//        Boolean userExist = userList.stream().anyMatch(user -> userNameField.getText().equals(((UserInformation) user).getEmail()));
//        
//       UserInformation checkedUser =  (UserInformation) userList.filtered(user -> userNameField.getText().equals(((UserInformation) user).getEmail()) && passwordField.getText().equals(((UserLogin) user).getPassword())).get(0);
//       
//       new Alert(Alert.AlertType.INFORMATION, checkedUser.toString()).showAndWait();
//
//        if (!areFieldsFilledIn) {
//            new Alert(Alert.AlertType.ERROR, "Please fill in all fields.").showAndWait();
//        } else if (!userExist) {
//            new Alert(Alert.AlertType.ERROR, "User does not exist, please try another one.").showAndWait();
//        } else if (!checkLogin) {
//            new Alert(Alert.AlertType.ERROR, "Username and or password do not match. Please try again.").showAndWait();
//        } else {
//
//            UserLogin loginInformation = userList.filtered((user) -> {
//                return userNameField.getText().equals(((UserInformation) user).getEmail());
//            }).get(0);
//
//            System.out.println("loginInformation::size: " + userList.size());
//            System.out.println("loginInformation::accounttype: " + loginInformation.toString());
//
//            System.out.println("Username and password check out, running last check for accounttype.");
//            if (loginInformation.getAccountType().equalsIgnoreCase("user")) {
//                MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
//                MainApp.getMainWindowController().loadCenterPane("/fxml/MainSearchWindow.fxml");
//            } else
//
//            if (loginInformation.getAccountType().equalsIgnoreCase("Administrator")) {
//                MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
//                MainApp.getMainWindowController().loadCenterPane("/fxml/UserList.fxml");
//            } else
//
//            if (loginInformation.getAccountType().equalsIgnoreCase("SystemAdministrator")) {
//                MainApp.getMainWindowController().loadLeftPane("/fxml/AdminMenu.fxml");
//                MainApp.getMainWindowController().loadCenterPane("/fxml/UserList.fxml");
//            } else {
//                new Alert(Alert.AlertType.ERROR, "Something went wrong.").showAndWait();
//            }
//
//        }

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

}
