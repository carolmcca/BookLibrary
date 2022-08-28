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

public class Option1Drawer {
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

    public Option1Drawer(){
        this.pageTitle = new Text();
        this.pageTitle.setText("Adicionar Livro");
        this.pageTitle.setFont(Font.font("Arial Black", 20));
        this.pageTitle.relocate(180, 20);

        this.titleMsg = new Text("Título:");
        //this.titleMsg.relocate(30, 70);
        this.titleMsg.setFill(Color.SANDYBROWN);
        this.titleMsg.setFont(Font.font("Arial Narrow", 15));

        this.titleControl = new TextField();
        this.titleControl.relocate(100, 70);

        this.authorMsg = new Text("Autor(es):");
        //this.authorMsg.relocate(30, 110);
        this.authorMsg.setFill(Color.SANDYBROWN);
        this.authorMsg.setFont(Font.font("Arial Narrow", 15));

        this.authorControl = new TextField();
        //this.authorControl.relocate(100, 110);

        this.editionMsg = new Text("Edição:");
        //this.authorMsg.relocate(30, 110);
        this.editionMsg.setFill(Color.SANDYBROWN);
        this.editionMsg.setFont(Font.font("Arial Narrow", 15));

        this.editionControl = new TextField();
        //this.authorControl.relocate(100, 110);

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
    }

    public static void draw(Stage stage, Scene scene){
        stage.setScene(scene);
        stage.show();
    }
}
