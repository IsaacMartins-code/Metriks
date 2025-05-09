package com.github.isaacmartinscode.metriks.controller;

import com.github.isaacmartinscode.metriks.model.service.CpuMetric;
import com.github.isaacmartinscode.metriks.model.util.ChangeView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class CpuViewController implements Initializable {

    CpuMetric cpuMetric = new CpuMetric();

    @FXML
    private Label cpuName;

    @FXML
    private Label baseClock;

    @FXML
    private Label totalCore;

    @FXML
    private Label totalLogicCore;

    @FXML
    private Label totalProcesses;

    @FXML
    private Label totalProcessesThreads;

    @FXML
    private Label userPercentage;

    @FXML
    private Label systemPercentage;

    @FXML
    private TableView<com.github.isaacmartinscode.metriks.model.entities.Process> tableView;

    @FXML
    private TableColumn<com.github.isaacmartinscode.metriks.model.entities.Process, String> TcName;

    @FXML
    private TableColumn<com.github.isaacmartinscode.metriks.model.entities.Process, Integer> TcPid;

    @FXML
    private TableColumn<com.github.isaacmartinscode.metriks.model.entities.Process, String> TcUsagePercentage;

    @FXML
    private TableColumn<com.github.isaacmartinscode.metriks.model.entities.Process, Integer> TcThreads;

    @FXML
    private TableColumn<com.github.isaacmartinscode.metriks.model.entities.Process, String> TcCpuUsageTime;

    @FXML
    private TableColumn<com.github.isaacmartinscode.metriks.model.entities.Process, String> TcUser;

    @FXML
    private AreaChart<Number, Number> areaChart;
    private final ObservableList<com.github.isaacmartinscode.metriks.model.entities.Process> processList = CpuMetric.getProcessList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cpuMetric.initScheduledRefresh();
        initializeNodes();
        initUIRefresh();
        cpuName.setText(CpuMetric.getCpuName());
        baseClock.setText(String.format("%.2f", CpuMetric.getBaseClock()) + " GHz");
        totalCore.setText(String.valueOf(CpuMetric.getTotalCore()));
        totalLogicCore.setText(String.valueOf(CpuMetric.getTotalLogicCore()));
        totalProcesses.setText(String.valueOf(CpuMetric.getTotalProcesses()));
        totalProcessesThreads.setText(String.valueOf(CpuMetric.getTotalProcessesThreads()));
        userPercentage.setText(String.format("%.2f", CpuMetric.getUserPercentage()) + " %");
        systemPercentage.setText(String.format("%.2f", CpuMetric.getSystemPercentage()) + " %");
    }

    private void initializeNodes() {
        tableView.setItems(processList);
        areaChart.getData().addAll(CpuMetric.getUserSerie(), CpuMetric.getSystemSerie());
        TcName.setCellValueFactory(new PropertyValueFactory<>("name"));
        TcPid.setCellValueFactory(new PropertyValueFactory<>("pId"));
        TcUsagePercentage.setCellValueFactory(new PropertyValueFactory<>("formattedUsagePercentage"));
        TcThreads.setCellValueFactory(new PropertyValueFactory<>("threads"));
        TcCpuUsageTime.setCellValueFactory(new PropertyValueFactory<>("cpuUsageTime"));
        TcUser.setCellValueFactory(new PropertyValueFactory<>("user"));
    }

    private void refreshUI() {
        totalProcesses.setText(String.valueOf(CpuMetric.getTotalProcesses()));
        totalProcessesThreads.setText(String.valueOf(CpuMetric.getTotalProcessesThreads()));
        userPercentage.setText(String.format("%.1f", CpuMetric.getUserPercentage()) + " %");
        systemPercentage.setText(String.format("%.1f", CpuMetric.getSystemPercentage()) + " %");
    }

    private void initUIRefresh() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> refreshUI())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void onMemButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/MemView.fxml");
    }

    public void onDiskButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/DiskView.fxml");
    }

    public void onNetworkButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/NetworkView.fxml");
    }
}
