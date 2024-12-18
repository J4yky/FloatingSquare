module org.floatingsquare.floatingsquare {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires javafx.graphics;


    opens org.floatingsquare.floatingsquare to javafx.fxml;
    exports org.floatingsquare.floatingsquare;
}