module org.example.demofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demofx to javafx.fxml;
    exports org.example.demofx;
    exports org.example.demofx.control;
    opens org.example.demofx.control to javafx.fxml;
}