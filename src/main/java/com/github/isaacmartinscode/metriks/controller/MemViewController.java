package com.github.isaacmartinscode.metriks.controller;

import com.github.isaacmartinscode.metriks.model.util.ChangeView;

public class MemViewController {

    public void onCpuButtonAction() {
        ChangeView.change("/com/github/isaacmartinscode/metriks/views/CpuView.fxml");
    }
}
