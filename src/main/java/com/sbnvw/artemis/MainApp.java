package com.sbnvw.artemis;

import com.sbnvw.artemis.account.Administrator;
import com.sbnvw.artemis.animal_kingdom.traits.Trait;
import com.sbnvw.artemis.animal_kingdom.traits.TraitBehaviour;
import com.sbnvw.artemis.animal_kingdom.traits.TraitGroup;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Classification;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.classifications.Kingdom;
import com.sbnvw.artemis.controllers.MainSearchWindowController;
import com.sbnvw.artemis.controllers.MainWindowController;
import com.sbnvw.artemis.io.IOContext;
import com.sbnvw.artemis.io.IOUsers;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class MainApp extends Application {

    private static Stage mainStage;
    private static MainWindowController mainWindowController;
    private static MainSearchWindowController mainSearchWindowController;

    public static Stage getMainStage() {
        return mainStage;
    }

    public static void setMainStage(Stage setStage) {
        mainStage = setStage;
    }

    /**
     * Returns the main window controller. this can be used to set and get
     * loaded panes into the main window.
     *
     * @return mainWindowController
     */
    public static MainWindowController getMainWindowController() {
        return mainWindowController;
    }

    /**
     * sets the main window controller. This should only happen on the fist boot
     * of the program.
     *
     * @param MainWindowController
     */
    public static void setMainWindowController(MainWindowController MainWindowController) {
        mainWindowController = MainWindowController;
    }

    /**
     * Returns the main search window controller. this can be used to access the
     * fields and attributes of the search window.
     *
     * @return mainSearchWidowController
     */
    public static MainSearchWindowController getMainSearchWindowController() {
        return mainSearchWindowController;
    }

    /**
     *
     * @param aMainSearchWindowController
     */
    public static void setMainSearchWindowController(MainSearchWindowController aMainSearchWindowController) {
        mainSearchWindowController = aMainSearchWindowController;
    }

    /**
     * Starting method
     *
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {

        setMainStage(stage);
        loadMainWindow();

        new IOContext(new IOUsers()).save(new Administrator("user", "pass", "Dave", "Britt", null, "Male", "djmbritt@gmail.com", "0641566887", "PerikWeg", "5", "b", "1025DJ", null));

        new IOContext(new IOUsers()).load().forEach((animal) -> {
            System.out.println(animal);
        });
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }

    /**
     * @param parent This should be the parent pane that should be replaced by
     * the new pane.
     * @param fxmlFileName
     * @return
     */
    public static Object loadFXMLFile(Pane parent, String fxmlFileName) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource(fxmlFileName));
            Pane pane = fxmlLoader.load();

            parent.getChildren().addAll();
            parent.getChildren().add(pane);
            pane.prefWidthProperty().bind(parent.widthProperty());
            pane.prefHeightProperty().bind(parent.heightProperty());

            return fxmlLoader.getController();

        } catch (IOException ex) {
            System.out.println(ex.getClass().getName() + ": " + ex.getMessage());
            return null;
        }

    }

    /**
     * Restart the stage and the root, load the mainwindow to return to the
     * login page.
     */
    public static void loadMainWindow() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("/fxml/mainWindow.fxml"));
            Parent root = fxmlLoader.load();
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
        } catch (IOException e) {
            System.out.println("Exception:: " + e);
        }

    }
}
