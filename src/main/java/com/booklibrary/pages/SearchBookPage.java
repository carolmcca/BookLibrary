package com.booklibrary.pages;

import com.booklibrary.model.Book;
import com.booklibrary.model.BookOccurrences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SearchBookPage extends Page {

    private Text pageTitle;
    private Text titleMsg;
    private TextField titleControl;

    private Button searchButton;
    private HBox hBox;
    private Group layout;
    private Scene scene;
    private Set<Book> books;
    private boolean isCreate;

    public SearchBookPage(Set<Book> books) {
        this.books = books;
        this.title = "Procurar Livro";
        this.isCreate = true;
    }


    @Override
    public Scene create(Stage stage){
        this.isCreate = false;

        this.pageTitle = this.createTitle();
        this.titleMsg = this.createText("Título");
        this.titleControl = new TextField();

        this.searchButton = this.createButton(stage, "Procurar");

        this.hBox = new HBox(this.titleMsg, this.titleControl, this.searchButton);
        this.hBox.setSpacing(20);
        this.hBox.setPadding(new Insets(100));

        this.layout = new Group(this.pageTitle, this.hBox);
        this.scene = new Scene(layout, 500, 500);
        return this.scene;
    }

    @Override
    public void execute(Stage stage){
        //if (this.isCreate){
        if (true) {
            stage.setScene(this.create(stage));
        }
        var hbox = (HBox)stage.getScene().getRoot().getChildrenUnmodifiable().get(1);
        var textField = (TextField) hbox.getChildren().get(1);
        String field = textField.getText();
        //String field = ((TextField)((HBox)stage.getScene().getRoot().getChildrenUnmodifiable().get(1)).getChildren().get(1)).getText();
        List<Book> searchedBooks = this.searchBooks(field, this.books);
        TableView<Book> table = this.showBooks(searchedBooks);
        stage.getScene().getRoot().getChildrenUnmodifiable().add(table);
        stage.setScene(scene);
        stage.show();
    }

    private TableView<Book> showBooks(List<Book> books){
        TableView<Book> table = new TableView<Book>();
        ObservableList<Book> bookObservableList = FXCollections.observableArrayList(books);

        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        TableColumn authorCol = new TableColumn("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
        table.setItems(bookObservableList);
        table.getColumns().addAll(titleCol, authorCol);

        return table;
    }

    private List<Book> searchBooks(String field, Set<Book> books) {
        if (field.isEmpty()) {
            return books.stream().toList();
        }
        else {
            Set<BookOccurrences> bookOccurrencesSet = new TreeSet<>();
            String[] words = field.split(" ");
            for (Book book : books) {
                int occurrences = 0;
                for (String word : words) {
                    if (book.getTitle().contains(word) || book.getAuthor().contains(word)) occurrences++;
                }
                if (occurrences > 0) bookOccurrencesSet.add(new BookOccurrences(book, occurrences));
            }
            return bookOccurrencesSet.stream().map(BookOccurrences::getBook).toList();
        }
    }


}
