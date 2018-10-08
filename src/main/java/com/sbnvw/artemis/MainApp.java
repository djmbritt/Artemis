package com.sbnvw.artemis;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.cats.smallCats.Cat;
import com.sbnvw.artemis.controllers.MainSearchWindowController;
import com.sbnvw.artemis.controllers.MainWindowController;
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

    public static Stage getMainStage(){
        return mainStage;
    }
    
    public static void setMainStage(Stage setStage){
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
     * Returns the main search window controller. this can be used to acces the
     * fields and atributes of the search window.
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
        
        /**
         * Loads the root window to be set as the first element of the scene.
         * This should always be the mainWindow for the program.
         */
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        /**
         * Fetches the primary screen of the user. It will then get the bounds
         * and sets them to the bounds variable. this results in the program
         * always starting up at the correct size of the screen
         */
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        /**
         * Sets the scene with the root as the startup window. the root should
         * be the mainWindow loaded by the FXML loader at the top of the method.
         */
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        /*
        * Sets the stage to the size of the users screen
         */
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        /*
        * Loads the stage and sets the stage title.
         */
        stage.getIcons().add(new Image("/img/index.png"));
        stage.setTitle("Artemis");
        stage.setScene(scene);
        stage.show();

        Cat cat = new Cat("CAT");

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
}
