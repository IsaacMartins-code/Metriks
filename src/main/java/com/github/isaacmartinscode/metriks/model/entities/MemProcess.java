package com.github.isaacmartinscode.metriks.model.entities;

public class MemProcess extends Process {

    private double memUsagePercentage;

    public MemProcess(String name, int pId, int threads, String user) {
        super(name, pId, threads, user);
    }

    public double getMemUsagePercentage() {
        return memUsagePercentage;
    }

    public void calcUsagePercentage(long memBytesUsage, double totalMemory) {
        double memGbUsage = memBytesUsage / Math.pow(1024, 3);
        memUsagePercentage = memGbUsage * 100.0 / totalMemory;
    }
}
