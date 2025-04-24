package com.github.isaacmartinscode.metriks.controller;

import com.github.isaacmartinscode.metriks.model.util.ChangeView;

public class CpuViewController {

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
