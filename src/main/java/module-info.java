module com.booklibrary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.booklibrary to javafx.fxml;
    exports com.booklibrary;
}