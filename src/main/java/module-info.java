module com.github.isaacmartinscode.metriks {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.github.isaacmartinscode.metriks.views to javafx.fxml;
    exports com.github.isaacmartinscode.metriks.application;
}