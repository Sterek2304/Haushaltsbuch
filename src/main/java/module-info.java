module com.example.haushaltsbuchfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires lombok;
    requires poi;
    requires com.fasterxml.jackson.databind;
    requires poi.ooxml;


    opens com.example.haushaltsbuchfx to javafx.fxml;
    opens controller to javafx.fxml;
    opens model to com.google.gson;
    exports com.example.haushaltsbuchfx;
    exports enums to com.google.gson;
}