package com.github.isaacmartinscode.metriks.model.entities.process;

import oshi.software.os.OSProcess;
import java.time.Duration;

public class CpuProcess extends Process {

    private String cpuUsageTime;
    private String formattedUsagePercentage = "0,0 %";
    private double cpuUsage;

    public CpuProcess(String name, int pId, int threads, String user, long cpuMsUsageTime) {
        super(name, pId, threads, user);
        convertCpuUsageTime(cpuMsUsageTime);
    }

    public String getCpuUsageTime() {
        return cpuUsageTime;
    }

    public String getFormattedUsagePercentage() {
        return formattedUsagePercentage;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void convertCpuUsageTime(long cpuMsUsageTime) {
        Duration duration = Duration.ofMillis(cpuMsUsageTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        cpuUsageTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void calcUsagePercentage(OSProcess previousTick, OSProcess currentTick, int totalLogicCore) {
        cpuUsage = currentTick.getProcessCpuLoadBetweenTicks(previousTick) * 100.0 / totalLogicCore;
        formattedUsagePercentage = String.format("%.1f", cpuUsage) + " %";
    }
}
