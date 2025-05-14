package com.github.isaacmartinscode.metriks.application;

import com.github.isaacmartinscode.metriks.model.service.CpuMetric;
import com.github.isaacmartinscode.metriks.model.service.MemMetric;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Program extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        CpuMetric cpuMetric = new CpuMetric();
        MemMetric memMetric = new MemMetric();
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("/com/github/isaacmartinscode/metriks/views/CpuView.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 950, 550);
        stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
        cpuMetric.initScheduledRefresh();
        memMetric.initScheduledRefresh();
        stage.setOnCloseRequest(event -> {
            cpuMetric.endScheduledRefresh();
            memMetric.endScheduledRefresh();
        });

    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static void main(String[] args) {launch();}
}
