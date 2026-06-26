module com.vtt.quizappv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.vtt.quizappv2 to javafx.fxml;
    exports com.vtt.quizappv2;
    exports com.vtt.pojo;
}
