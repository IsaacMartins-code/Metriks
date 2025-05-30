package com.github.isaacmartinscode.metriks.model.entities.process;

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

    public void calcUsagePercentage(long residentSize, double totalMemory) {
        double gBResidentSize = residentSize / Math.pow(1024, 3);
        memUsage = gBResidentSize / totalMemory * 100.0;
        formattedUsagePercentage = String.format("%.1f", memUsage) + " %";
    }
}
