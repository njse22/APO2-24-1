module org.icesi.demofx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.demofx to javafx.fxml;
    exports org.icesi.demofx;
    exports org.icesi.demofx.control;
    opens org.icesi.demofx.control to javafx.fxml;
}