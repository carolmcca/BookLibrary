module com.booklibrary {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.booklibrary;
    opens com.booklibrary to javafx.fxml;
    exports com.booklibrary.view.pages;
    opens com.booklibrary.view.pages to javafx.fxml;
    exports com.booklibrary.model;
    opens com.booklibrary.model to javafx.fxml;
}