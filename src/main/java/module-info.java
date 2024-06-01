module com.main.codelab6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.main.codelab6 to javafx.fxml;
    exports com.main.codelab6;
}