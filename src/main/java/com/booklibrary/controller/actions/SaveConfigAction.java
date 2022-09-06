package com.booklibrary.controller.actions;

import com.booklibrary.controller.DatabaseManager;
import com.booklibrary.model.Config;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SaveConfigAction extends ButtonAction {
    private final Config config;

    public SaveConfigAction(Config config) {
        this.config = config;
    }

    @Override
    public void execute(Stage stage) {
        HBox hBox = (HBox) ((BorderPane)((ScrollPane)stage.getScene().getRoot()).getContent()).getCenter();
        VBox vBox = (VBox) hBox.getChildren().get(1);
        var inputs = vBox.getChildren();

        String libraryOwner = ((TextField)inputs.get(0)).getText();
        String libraryAddress = ((TextField)inputs.get(1)).getText();

        this.config.setLibraryOwner(libraryOwner);
        this.config.setLibraryAddress(libraryAddress);

        DatabaseManager databaseManager = new DatabaseManager(this.config);
        databaseManager.saveConfig();
    }
}
