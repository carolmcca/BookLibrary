package com.booklibrary.pages;

import com.booklibrary.model.Book;
import com.booklibrary.model.Place;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Set;

public class AddBookSubmitPage extends Page {
    private Set<Book> books;

    public AddBookSubmitPage(Set<Book> books) {
        this.books = books;
        this.title = "Adicionar Livro";

    }

    @Override
    public void execute(Stage stage) {
        this.addBook(stage);
        super.execute(stage);
    }

    private void addBook(Stage stage) {
        HBox hBox = (HBox) stage.getScene().getRoot().getChildrenUnmodifiable().get(1);
        VBox vBox = (VBox) hBox.getChildren().get(1);
        var inputs = vBox.getChildren();
        String aux;
        String bookTitle = ((TextField)inputs.get(0)).getText();
        String bookAuthor = ((TextField)inputs.get(1)).getText();
        aux = ((TextField)inputs.get(2)).getText();
        Integer bookEdition = aux.isBlank() ? null : Integer.parseInt(aux);
        aux = ((TextField)inputs.get(3)).getText();
        Integer bookYear = aux.isBlank() ? null : Integer.parseInt(aux);
        String address = ((TextField)inputs.get(4)).getText();
        String room = ((TextField)inputs.get(5)).getText();
        String cabinet = ((TextField)inputs.get(6)).getText();
        String shelf = ((TextField)inputs.get(7)).getText();
        Place place = new Place(address, room, cabinet, shelf);
        Book book = new Book(bookTitle, bookAuthor, bookEdition, bookYear, place);
        this.books.add(book);

    }

    @Override
    public Scene create(Stage stage) {
        Text text = this.createText("O seu livro foi adicionado com sucesso!");
        Text pageTitle = this.createTitle();
        AddBookPage addBookPage = new AddBookPage(this.books);
        MainPage mainPage = new MainPage(this.books);
        Button button1 = addBookPage.createButton(stage, "Adicionar novo livro");
        Button button2 = mainPage.createButton(stage, "Menu Principal");

        HBox buttonBox = new HBox(button1, button2);
        buttonBox.setSpacing(30);

        VBox vBox = new VBox(text, buttonBox);
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(40);
        vBox.setPadding(new Insets(100));

        Group layout = new Group(pageTitle,vBox);

        return new Scene(layout, Color.LIGHTGOLDENRODYELLOW);

    }
}
