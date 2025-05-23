module com.github.isaacmartinscode.metriks {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.github.oshi;
    requires java.desktop;

    opens com.github.isaacmartinscode.metriks.controller to javafx.fxml;
    opens com.github.isaacmartinscode.metriks.views to javafx.fxml;
    opens com.github.isaacmartinscode.metriks.model.entities.process;
    opens com.github.isaacmartinscode.metriks.model.entities.hardware;
    exports com.github.isaacmartinscode.metriks.application;
}