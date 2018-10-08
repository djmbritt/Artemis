package com.sbnvw.artemis.controllers;

import com.sbnvw.artemis.MainApp;
import static com.sbnvw.artemis.MainApp.getMainStage;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class MainWindowController implements Initializable {

    @FXML
    private BorderPane mainWindow;
    @FXML
    private MenuItem close;
    @FXML
    private AnchorPane centerAnchor;
    @FXML
    private AnchorPane leftAnchor;
    @FXML
    private AnchorPane rightAnchor;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MainApp.loadFXMLFile(centerAnchor, "/fxml/LoginPage.fxml");
        centerAnchor.autosize();
        MainApp.setMainWindowController(this);

    }

    /**
     * Closses the app.
     * @param event 
     */
    @FXML
    void closeApp(ActionEvent event) {

        System.exit(0);

    }

    /**
     *
     * @param path
     */
    public void loadLeftPane(String path) {

        MainApp.loadFXMLFile(leftAnchor, path);

    }

    /**
     *
     * @param path
     */
    public void loadRightPane(String path) {

        MainApp.loadFXMLFile(rightAnchor, path);

    }

    /**
     *
     * @param path
     */
    public void loadCenterPane(String path) {

        MainApp.loadFXMLFile(centerAnchor, path);

    }

    /**
     *
     * @return
     */
    public AnchorPane getCenterAnchor() {
        return centerAnchor;
    }

    /**
     *
     * @param centerAnchor
     */
    public void setCenterAnchor(AnchorPane centerAnchor) {
        this.centerAnchor = centerAnchor;
    }

    /**
     *
     * @return
     */
    public AnchorPane getLeftAnchor() {
        return leftAnchor;
    }

    /**
     *
     * @param leftAnchor
     */
    public void setLeftAnchor(AnchorPane leftAnchor) {
        this.leftAnchor = leftAnchor;
    }

    /**
     *
     * @return
     */
    public AnchorPane getRightAnchor() {
        return rightAnchor;
    }

    /**
     *
     * @param rightAnchor
     */
    public void setRightAnchor(AnchorPane rightAnchor) {
        this.rightAnchor = rightAnchor;
    }

    /**
     * creates pop up to confirm cancelation, if confirmed, returns to the login
     * screen.
     * @param the name of the class calling this method
     */
    public void cancelAndReturnToMainWindow(String className) {
        System.out.println("Canceling and returning to main window from: " + className);
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setContentText("Are you sure you want to cancel?");
        confirmationAlert.setTitle("Confirm cancelation.");

        confirmationAlert.showAndWait().ifPresent((response) -> {
            if (response == ButtonType.OK) {
                try {
                    MainApp.getMainWindowController().loadMainWindow();
                } catch (Exception e) {
                    System.out.println("Exception:: " + e);
                }
            }
        });
    }

    /**
     * clears the current mainwindow, clears it and creates a new scene and
     * stage.
     *
     * @throws Exception
     */
    public void loadMainWindow() throws Exception {
        mainWindow.getChildren().clear();

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        Stage stage = getMainStage();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        stage.getIcons().add(new Image("/img/index.png"));
        stage.setTitle("Artemis");
        stage.setScene(scene);
        stage.show();
    }

}
