package com.github.isaacmartinscode.metriks.controller;

import com.github.isaacmartinscode.metriks.model.util.ChangeView;

public class DiskViewController {

    public void onCpuButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/CpuView.fxml");
    }

    public void onMemButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/MemView.fxml");
    }

    public void onNetworkButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/NetworkView.fxml");
    }
}
