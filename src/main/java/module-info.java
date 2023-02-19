module com.example.unibanco {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.unibanco to javafx.fxml;
    exports com.example.unibanco;
}