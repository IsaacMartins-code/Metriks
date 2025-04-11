package com.github.isaacmartinscode.metriks.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Program extends Application {

    private static Scene mainScene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Program.class.getResource("CpuView.fxml"));
        mainScene = new Scene(fxmlLoader.load(), 950, 550);
        stage.setResizable(false);
        stage.setScene(mainScene);
        stage.show();
    }

    public static Scene getMainScene() {
        return mainScene;
    }

    public static void main(String[] args) {
        launch();
    }
}
