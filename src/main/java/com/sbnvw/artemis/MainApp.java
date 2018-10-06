package com.sbnvw.artemis;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.chordate.mammalia.carnivora.cats.smallCats.Cat;
import com.sbnvw.artemis.controllers.MainSearchWindowController;
import com.sbnvw.artemis.controllers.MainWindowController;
import com.sbnvw.artemis.managers.AnimalManager;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Zilverdrake
 */
public class MainApp extends Application {
    
    private static MainWindowController mainWindowController;
    
    /**
     *
     * @return
     */
    public static MainWindowController getMainWindowController() {
        return mainWindowController;
    }
    
    /**
     *
     * @param aMainWindowController
     */
    public static void setMainWindowController(MainWindowController aMainWindowController) {
        mainWindowController = aMainWindowController;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
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
        stage.setTitle("Artemis");
        stage.setScene(scene);
        stage.show();

        Animal cat = new Cat("CAT");
        
        

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
     *
     * @param parent
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
            
            if (pane instanceof AnchorPane) {
                System.out.println("I am an AnchorPane");
            }
            
            return fxmlLoader.getController();
            
        } catch (IOException ex) {
            System.out.println(ex.getClass().getName() + ": " + ex.getMessage());
            return null;
        }
        
    }
    
}
