module com.vtt.quizapp.englishquizapp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vtt.quizapp.englishquizapp to javafx.fxml;
    exports com.vtt.quizapp.englishquizapp;
}
