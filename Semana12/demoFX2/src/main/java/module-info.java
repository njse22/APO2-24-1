module org.example.demofx2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.demofx2 to javafx.fxml;
    exports org.example.demofx2;

    opens org.example.demofx2.control to javafx.fxml;
    exports org.example.demofx2.control;

    opens org.example.demofx2.model to javafx.fxml;
    exports org.example.demofx2.model;
}