package com.github.isaacmartinscode.metriks.controller;

import com.github.isaacmartinscode.metriks.model.util.ChangeView;

public class MemViewController {

    public void onCpuButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/CpuView.fxml");
    }

    public void onDiskButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/DiskView.fxml");
    }

    public void onNetworkButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/NetworkView.fxml");
    }
}
