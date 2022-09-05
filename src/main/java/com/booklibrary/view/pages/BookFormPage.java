package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.AddBookAction;
import com.booklibrary.controller.actions.CompositeAction;
import com.booklibrary.controller.actions.OpenBookAddedPageAction;
import com.booklibrary.model.Book;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

import static com.booklibrary.utils.Utils.setScene;

public class BookFormPage extends Page {
    protected final Set<Book> books;
    protected String titleControlText;
    protected String authorControlText;
    protected String editionControlText;
    protected String yearControlText;
    protected String roomControlText;
    protected String addressControlText;
    protected String cabinetControlText;
    protected String shelfControlText;

    public BookFormPage(Set<Book> books) {
        this.title = "Adicionar Livro";
        this.books = books;
    }

    @Override
    public Scene create(Stage stage){
        BorderPane borderPane = new BorderPane();
        Scene scene = setScene(borderPane);


        Text pageTitle = this.createTitle();

        Text titleMsg = this.createText("Título:");
        TextField titleControl = new TextField(this.titleControlText);
        Text authorMsg = this.createText("Autor(es):");
        TextField authorControl = new TextField(this.authorControlText);
        Text editionMsg = this.createText("Edição:");
        TextField editionControl = new TextField(this.editionControlText);
        Text yearMsg = this.createText("Ano de publicação:");
        TextField yearControl = new TextField(this.yearControlText);
        Text addressMsg = this.createText("Morada:");
        TextField addressControl = new TextField(this.addressControlText);
        Text roomMsg = this.createText("Divisão:");
        TextField roomControl = new TextField(this.roomControlText);
        Text cabinetMsg = this.createText("Armário:");
        TextField cabinetControl = new TextField(this.cabinetControlText);
        Text shelfMsg = this.createText("Prateleira:");
        TextField shelfControl = new TextField(this.shelfControlText);


        VBox msgs = new VBox(titleMsg, authorMsg, editionMsg, yearMsg, addressMsg, roomMsg, cabinetMsg, shelfMsg);
        msgs.setAlignment(Pos.CENTER_LEFT);
        msgs.setSpacing(20);

        VBox controls = new VBox(titleControl, authorControl, editionControl, yearControl, addressControl, roomControl, cabinetControl, shelfControl);
        controls.setAlignment(Pos.CENTER_LEFT);
        controls.setSpacing(20);

        HBox hBox = new HBox(msgs, controls);
        hBox.setSpacing(30);
        hBox.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(hBox);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        BorderPane.setMargin(pageTitle, new Insets(30));

        return scene;
    }
}
