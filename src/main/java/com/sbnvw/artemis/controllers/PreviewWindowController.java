package com.sbnvw.artemis.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Marcel van Wilgenburg
 */
public class PreviewWindowController implements Initializable {

    @FXML
    private Text header;
    @FXML
    private Text name;
    @FXML
    private TextArea textField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public PreviewWindowController getController() {
        return this;

    }

    public Text getName() {
        return name;
    }

    public Text getHeader() {
        return header;
    }

    public TextArea getTextField() {
        return textField;
    }

}
