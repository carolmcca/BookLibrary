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
import javafx.stage.Stage;

public class AddBook {
    private Text pageTitle;
    private TextField titleControl;
    private TextField authorControl;
    private TextField editionControl;
    private VBox controls;
    private Text titleMsg;
    private Text authorMsg;
    private Text editionMsg;
    private VBox msgs;

    private String title; //cenas

    private Button submitButton;
    private Scene scene;
    private Group layout;

    private HBox hBox;

    public Scene getScene() {
        return this.scene;
    }

    public String getTitle() {
        return title;
    }

    private Text createMsg(String text){
        Text msg = new Text(text);
        msg.setFill(Color.SANDYBROWN);
        msg.setFont(Font.font("Arial Narrow", 15));
        return msg;
    }

    public AddBook(){}

    public Scene create(){
        this.pageTitle = new Text();
        this.pageTitle.setText("Adicionar Livro");
        this.pageTitle.setFill(Color.SANDYBROWN);
        this.pageTitle.setFont(Font.font("Arial Black", 20));
        this.pageTitle.relocate(180, 20);

        this.titleMsg = this.createMsg("Título:");
        this.titleControl = new TextField();

        this.authorMsg = this.createMsg("Autor(es):");
        this.authorControl = new TextField();

        this.editionMsg = this.createMsg("Edição:");
        this.editionControl = new TextField();

        this.submitButton = new Button();
        this.submitButton.setText("Adicionar Livro");
        this.submitButton.setStyle("-fx-background-color: SandyBrown");
        this.submitButton.setFont(Font.font("Arial Narrow", 15));
        this.submitButton.relocate(350, 420);
        this.submitButton.setOnAction(e -> {this.title = this.titleControl.getText();
            System.out.println(this.title);}); //claramente isto não devia estar aqui


        this.msgs = new VBox(this.titleMsg, this.authorMsg, this.editionMsg);
        this.msgs.setAlignment(Pos.CENTER_LEFT);
        this.msgs.setSpacing(30);

        this.controls = new VBox(this.titleControl, this.authorControl, this.editionControl);
        this.controls.setAlignment(Pos.CENTER_LEFT);
        this.controls.setSpacing(30);

        this.hBox = new HBox(this.msgs, this.controls);
        this.hBox.setSpacing(10);
        this.hBox.setPadding(new Insets(100));


        this.layout = new Group();
        this.layout.getChildren().addAll(this.pageTitle, this.hBox, this.submitButton);
        this.scene = new Scene(this.layout, 500, 500, Color.LIGHTGOLDENRODYELLOW);

        return this.scene;
    }

    public static void draw(Stage stage, Scene scene){
        stage.setScene(scene);
        stage.show();
    }
}
