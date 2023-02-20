module com.example.unibanco {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.modelo to javafx.fxml;
    exports com.example.modelo;

    opens com.example.controlador to javafx.fxml;
    exports com.example.controlador;
}