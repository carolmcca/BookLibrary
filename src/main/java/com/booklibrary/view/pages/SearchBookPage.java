package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.ButtonAction;
import com.booklibrary.controller.actions.OpenBookDetailsPageAction;
import com.booklibrary.controller.actions.SearchBookAction;
import com.booklibrary.model.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Set;

public class SearchBookPage extends Page {
    private Set<Book> books;

    public SearchBookPage(Set<Book> books) {
        this.title = "Procurar Livro";
        this.books = books;
    }


    @Override
    public Scene create(Stage stage){
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, Color.LIGHTGOLDENRODYELLOW);

        Text pageTitle = this.createTitle();

        TextField searchControl = new TextField();
        ButtonAction searchBookAction = new SearchBookAction(this.books);
        Button searchButton = searchBookAction.createButton(stage, "Procurar");
        searchButton.setDefaultButton(true);

        HBox hBox = new HBox(searchControl, searchButton);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        TableView<Book> table = this.buildBooksTable(stage, this.books.stream().toList());

        VBox vBox = new VBox(hBox, table);

        borderPane.setTop(pageTitle);
        borderPane.setCenter(vBox);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(hBox, Pos.CENTER);
        return scene;
    }

    private TableView<Book> buildBooksTable(Stage stage, List<Book> books){
        TableView<Book> table = new TableView<>();
        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        TableColumn authorCol = new TableColumn("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));

        table.getColumns().addAll(titleCol, authorCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.prefHeightProperty().bind(stage.heightProperty());
        table.prefWidthProperty().bind(stage.widthProperty());


        table.setRowFactory(tv -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Book book = row.getItem();
                    new OpenBookDetailsPageAction(book, this.books).execute(stage);
                }
            });
            return row ;
        });

        ObservableList<Book> bookObservableList = FXCollections.observableArrayList(books);
        table.setItems(bookObservableList);

        return table;
    }
}
