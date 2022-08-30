module com.booklibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.booklibrary to javafx.fxml;
    exports com.booklibrary;
    exports com.booklibrary.pages;
    opens com.booklibrary.pages to javafx.fxml;
}