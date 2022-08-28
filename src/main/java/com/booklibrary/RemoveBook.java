package com.booklibrary;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class RemoveBook {

    private model.Book book;
    private Text pageTitle;
    private Text titleMsg;
    private TextField titleControl;

    private Button searchButton;
    private HBox hBox;
    private Group layout;
    private Scene scene;

    public Scene create(){
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
