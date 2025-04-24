package com.github.isaacmartinscode.metriks.controller;

import com.github.isaacmartinscode.metriks.model.util.ChangeView;

public class NetworkViewController {

    public void onCpuButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/CpuView.fxml");
    }

    public void onDiskButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/DiskView.fxml");
    }

    public void onMemButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/MemView.fxml");
    }
}
