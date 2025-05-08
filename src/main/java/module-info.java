module com.github.isaacmartinscode.metriks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.oshi;

    opens com.github.isaacmartinscode.metriks.controller to javafx.fxml;
    opens com.github.isaacmartinscode.metriks.views to javafx.fxml;
    opens com.github.isaacmartinscode.metriks.model.entities;
    exports com.github.isaacmartinscode.metriks.application;
}