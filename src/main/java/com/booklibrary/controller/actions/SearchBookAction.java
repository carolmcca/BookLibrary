package com.booklibrary.controller.actions;

import com.booklibrary.model.Book;
import com.booklibrary.model.BookOccurrences;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.booklibrary.utils.Utils.containsIgnoreCase;

public class SearchBookAction extends ButtonAction {
    private final Set<Book> books;

    public SearchBookAction(Set<Book> books) {
        this.books = books;
    }

    @Override
    public void execute(Stage stage) {
        BorderPane borderPane = (BorderPane) stage.getScene().getRoot();
        String field = ((TextField) ((HBox) ((VBox) borderPane.getCenter()).getChildren().get(0)).getChildren().get(0)).getText();

        List<Book> searchedBooks = this.searchBooks(field, this.books);
        ObservableList<Book> bookObservableList = FXCollections.observableArrayList(searchedBooks);
        TableView<Book> tableView = (TableView<Book>) ((VBox) borderPane.getCenter()).getChildren().get(1);
        tableView.setItems(bookObservableList);

        stage.show();
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
                    if (containsIgnoreCase(book.getTitle(), word) || containsIgnoreCase(book.getAuthor(), word))
                        occurrences++;
                }
                if (occurrences > 0) {
                    bookOccurrencesSet.add(new BookOccurrences(book, occurrences));
                }
            }
            return bookOccurrencesSet.stream().map(BookOccurrences::getBook).toList();
        }
    }

}
