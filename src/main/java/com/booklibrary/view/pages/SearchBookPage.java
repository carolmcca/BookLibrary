package com.booklibrary.view.pages;

import com.booklibrary.controller.actions.OpenBookDetailsPageAction;
import com.booklibrary.controller.actions.OpenMainPageAction;
import com.booklibrary.controller.actions.SearchBookAction;
import com.booklibrary.model.Book;
import com.booklibrary.model.Database;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
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

import static com.booklibrary.utils.Utils.scrollableRoot;

public class SearchBookPage extends Page {
    private final Database database;

    public SearchBookPage(Database database) {
        this.database = database;
        this.title = "Procurar Livro";
    }

    @Override
    public Node create(Stage stage){
        BorderPane borderPane = new BorderPane();

        Text pageTitle = this.createTitle();

        TextField searchControl = new TextField();
        Button searchButton = new SearchBookAction(this.database.getBooks()).createButton(stage, "Procurar");
        searchButton.setDefaultButton(true);

        HBox hBox = new HBox(searchControl, searchButton);
        hBox.setSpacing(20);
        hBox.setAlignment(Pos.CENTER);

        TableView<Book> table = this.buildBooksTable(stage, this.database.getBooks().stream().toList());

        VBox vBox = new VBox(hBox, table);
        vBox.setSpacing(30);
        vBox.setAlignment(Pos.CENTER);

        Button backButton = new OpenMainPageAction(this.database).createButton(stage, "Voltar");

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
        TableColumn collectionCol = new TableColumn("Coleção");
        collectionCol.setCellValueFactory(new PropertyValueFactory<Book, String>("collection"));
        TableColumn roomCol = new TableColumn("Divisão");
        roomCol.setCellValueFactory(cellData -> new SimpleStringProperty(((TableColumn.CellDataFeatures<Book, String>)cellData).getValue().getPlace().getRoom()));
        TableColumn lendCol = new TableColumn("Emprestado");
        lendCol.setCellValueFactory(cellData -> {
            String lend = ((TableColumn.CellDataFeatures<Book, String>)cellData).getValue().getLend();
            return new SimpleStringProperty(lend == null ? "" : lend);
        });

        table.getColumns().addAll(titleCol, authorCol, collectionCol, roomCol, lendCol);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.prefHeightProperty().bind(stage.heightProperty());
        table.prefWidthProperty().bind(stage.widthProperty());


        table.setRowFactory(tv -> {
            TableRow<Book> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    Book book = row.getItem();
                    new OpenBookDetailsPageAction(this.database, book).execute(stage);
                }
            });
            return row ;
        });

        ObservableList<Book> bookObservableList = FXCollections.observableArrayList(books);
        table.setItems(bookObservableList);

        return table;
    }
}
