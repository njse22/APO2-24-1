module org.icesi.animation {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.icesi.animation to javafx.fxml;
    exports org.icesi.animation;
    exports org.icesi.animation.control;
    opens org.icesi.animation.control to javafx.fxml;
}