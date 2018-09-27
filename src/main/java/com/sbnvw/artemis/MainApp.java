package com.sbnvw.artemis;

import com.sbnvw.artemis.animal_kingdom.treeOfLife.Animal;
import com.sbnvw.artemis.animal_kingdom.treeOfLife.mammalia.carnivora.cats.smallCats.Cat;
import com.sbnvw.artemis.controllers.MainSearchWindowController;
import com.sbnvw.artemis.controllers.MainWindowController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Marcel van Wilgenburg
 */
public class MainApp extends Application {

    private static MainWindowController mainWindowController;
    private static MainSearchWindowController mainSearchWindowController;

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

    public static MainSearchWindowController getMainSearchWindowController() {
        return mainSearchWindowController;
    }

    public static void setMainSearchWindowController(MainSearchWindowController aMainSearchWindowController) {
        mainSearchWindowController = aMainSearchWindowController;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/mainWindow.fxml"));

        Screen screen = Screen.getPrimary();        
        Rectangle2D bounds = screen.getVisualBounds();

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());

        stage.setTitle("Artemis");
        stage.setScene(scene);
        stage.show();
        
        Cat cat = new Cat("Cat");
        
        System.out.println(cat.getDiet().diet());
        

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
     * This file
     *
     *
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
