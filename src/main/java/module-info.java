module com.example.haushaltsbuchfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.haushaltsbuchfx to javafx.fxml;
    opens controller to javafx.fxml;
    exports com.example.haushaltsbuchfx;
}