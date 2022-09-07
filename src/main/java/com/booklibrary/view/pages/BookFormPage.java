package com.booklibrary.view.pages;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static com.booklibrary.utils.Utils.scrollableRoot;

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
    protected String ownerControlText;

    public BookFormPage(Set<Book> books) {
        this.books = books;
    }

    @Override
    public Node create(Stage stage){
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        HBox hBox = new HBox(createBookInfoHBox(), createLocalInfoHBox());
        hBox.setSpacing(100);
        hBox.setAlignment(Pos.CENTER);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(hBox);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        BorderPane.setMargin(pageTitle, new Insets(30));

        return scrollableRoot(borderPane);
    }

    private HBox createBookInfoHBox() {
        List<String> msgs = Arrays.asList(
                "Título:",
                "Autor(es):",
                "Edição:",
                "Ano de publicação:"
        );
        List<String> fields = Arrays.asList(
                this.titleControlText,
                this.authorControlText,
                this.editionControlText,
                this.yearControlText
        );

        VBox msgsVBox = this.createTextVBox(msgs, true, 15);
        VBox fieldsVBox = this.createTextFieldVBox(fields, 15);

        HBox bookInfo = new HBox(msgsVBox, fieldsVBox);
        bookInfo.setSpacing(20);
        bookInfo.setAlignment(Pos.CENTER);

        return bookInfo;
    }

    private HBox createLocalInfoHBox() {
        List<String> msgs = Arrays.asList(
                "Dono:",
                "Morada:",
                "Divisão:",
                "Armário:",
                "Prateleira:"
        );
        List<String> fields = Arrays.asList(
                this.ownerControlText,
                this.addressControlText,
                this.roomControlText,
                this.cabinetControlText,
                this.shelfControlText
        );

        VBox msgsVBox = this.createTextVBox(msgs, true, 15);
        VBox fieldsVBox = this.createTextFieldVBox(fields, 15);

        HBox bookInfo = new HBox(msgsVBox, fieldsVBox);
        bookInfo.setSpacing(20);
        bookInfo.setAlignment(Pos.CENTER);

        return bookInfo;
    }

    private VBox createTextVBox(List<String> texts, boolean bold, int spacing) {
        List<Text> textsText = new ArrayList<>();
        for (String text : texts) {
            textsText.add(this.createText(text, bold));
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(textsText);
        vBox.setSpacing(spacing);
        vBox.setAlignment(Pos.CENTER_LEFT);

        return vBox;
    }

    private VBox createTextFieldVBox(List<String> texts, int spacing) {
        List<TextField> textsText = new ArrayList<>();
        for (String text : texts) {
            textsText.add(new TextField(text));
        }

        VBox vBox = new VBox();
        vBox.getChildren().addAll(textsText);
        vBox.setSpacing(spacing);
        vBox.setAlignment(Pos.CENTER_LEFT);

        return vBox;
    }
}
