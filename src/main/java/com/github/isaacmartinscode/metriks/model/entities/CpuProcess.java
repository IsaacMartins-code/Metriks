package com.github.isaacmartinscode.metriks.model.entities;

import oshi.software.os.OSProcess;
import java.time.Duration;

public class CpuProcess extends Process {

    private String cpuUsageTime;
    private double cpuUsagePercentage;
    private boolean firstTick = true;

    public CpuProcess(String name, int pId, int threads, String user, long cpuMsUsageTime) {
        super(name, pId, threads, user);
        convertCpuUsageTime(cpuMsUsageTime);
    }

    public String getCpuUsageTime() {
        return cpuUsageTime;
    }

    public double getCpuUsagePercentage() {
        return cpuUsagePercentage;
    }

    public boolean isFirstTick() {
        return firstTick;
    }

    public void setFirstTick(boolean firstTick) {
        this.firstTick = firstTick;
    }

    public void convertCpuUsageTime(long cpuMsUsageTime) {
        Duration duration = Duration.ofMillis(cpuMsUsageTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        cpuUsageTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void calcUsagePercentage(OSProcess previousTick, OSProcess currentTick, int totalLogicCore) {
        cpuUsagePercentage = currentTick.getProcessCpuLoadBetweenTicks(previousTick) * 100.0 / totalLogicCore;
    }
}
