package com.github.isaacmartinscode.metriks.model.entities;

public class MemProcess extends Process {

    private String formattedUsagePercentage = "0,0 %";
    private double memUsage;

    public MemProcess(String name, int pId, int threads, String user) {
        super(name, pId, threads, user);
    }

    public String getFormattedUsagePercentage() {
        return formattedUsagePercentage;
    }

    public double getMemUsage() {
        return memUsage;
    }

    public void calcUsagePercentage(long memBytesUsage, double totalMemory) {
        double memGbUsage = memBytesUsage / Math.pow(1024, 3);
        memUsage = memGbUsage * 100.0 / totalMemory;
        formattedUsagePercentage = String.format("%.1f", memUsage) + " %";
    }
}
