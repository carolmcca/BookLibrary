package com.booklibrary;

import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RemoveBook extends Menu {

    private Book book;
    private Text pageTitle;
    private Text titleMsg;
    private TextField titleControl;

    private Button searchButton;
    private HBox hBox;
    private Group layout;
    private Scene scene;

    public RemoveBook() {
        this.title = "Remover Livro";
    }

    @Override
    public Scene create(Stage stage){
        this.pageTitle = new Text();
        this.pageTitle.setText("Remover Livro");
        this.pageTitle.setFill(Color.SANDYBROWN);
        this.pageTitle.setFont(Font.font("Arial Black", 20));
        this.pageTitle.relocate(180, 20);

        this.titleMsg = new Text("Título");
        this.titleMsg.setFill(Color.SANDYBROWN);
        this.titleMsg.setFont(Font.font("Arial Narrow", 15));

        this.titleControl = new TextField();

        this.searchButton = new Button();
        this.searchButton.setText("Procurar");
        this.searchButton.setStyle("-fx-background-color: SandyBrown");
        this.searchButton.setFont(Font.font("Arial Narrow", 15));
        this.searchButton.setOnAction(e -> {
            System.out.println(this.titleControl.getText());});

        this.hBox = new HBox(this.titleMsg, this.titleControl, this.searchButton);
        this.hBox.setSpacing(20);
        this.hBox.setPadding(new Insets(100));

        this.layout = new Group(this.pageTitle, this.hBox);
        this.scene = new Scene(layout, 500, 500);
        return this.scene;
    }
}
