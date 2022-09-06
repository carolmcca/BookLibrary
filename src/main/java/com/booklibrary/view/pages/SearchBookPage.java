package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.OpenBookDetailsPageAction;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.controller.actions.SearchBookAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Config;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;
import java.util.Set;

import static com.booklibrary.utils.Utils.scrollableRoot;

public class SearchBookPage extends Page {
    private final Set<Book> books;
    private final Config config;

    public SearchBookPage(Config config, Set<Book> books) {
        this.title = "Procurar Livro";
        this.config = config;
        this.books = books;
    }


    @Override
    public Node create(Stage stage){
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        TextField searchControl = new TextField();
        Button searchButton = new SearchBookAction(this.books).createButton(stage, "Procurar");
        searchButton.setDefaultButton(true);

        HBox hBox = new HBox(searchControl, searchButton);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        TableView<Book> table = this.buildBooksTable(stage, this.books.stream().toList());

        VBox vBox = new VBox(hBox, table);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);

        Button backButton = new OpenMainPageAction(this.config, this.books).createButton(stage, "Voltar");

        borderPane.setTop(pageTitle);
        borderPane.setCenter(vBox);
        borderPane.setBottom(backButton);

        BorderPane.setAlignment(pageTitle, Pos.CENTER);
        BorderPane.setAlignment(vBox, Pos.CENTER);
        BorderPane.setAlignment(backButton, Pos.CENTER);

        BorderPane.setMargin(pageTitle, new Insets(50));
        BorderPane.setMargin(vBox, new Insets(0, 50, 0, 50));
        BorderPane.setMargin(backButton, new Insets(50));

        return scrollableRoot(borderPane);
    }

    private TableView<Book> buildBooksTable(Stage stage, List<Book> books){
        TableView<Book> table = new TableView<>();
        TableColumn titleCol = new TableColumn("Título");
        titleCol.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
        TableColumn authorCol = new TableColumn("Autor(es)");
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
                    new OpenBookDetailsPageAction(book, config, this.books).execute(stage);
                }
            });
            return row ;
        });

        ObservableList<Book> bookObservableList = FXCollections.observableArrayList(books);
        table.setItems(bookObservableList);

        return table;
    }
}
