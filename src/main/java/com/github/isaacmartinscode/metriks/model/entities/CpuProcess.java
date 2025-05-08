package com.github.isaacmartinscode.metriks.model.entities;

import oshi.software.os.OSProcess;
import java.time.Duration;

public class CpuProcess extends Process {

    private String cpuUsageTime;
    private String cpuUsagePercentage = "0,0";

    public CpuProcess(String name, int pId, int threads, String user, long cpuMsUsageTime) {
        super(name, pId, threads, user);
        convertCpuUsageTime(cpuMsUsageTime);
    }

    public String getCpuUsageTime() {
        return cpuUsageTime;
    }

    public String getCpuUsagePercentage() {
        return cpuUsagePercentage + " %";
    }

    public void convertCpuUsageTime(long cpuMsUsageTime) {
        Duration duration = Duration.ofMillis(cpuMsUsageTime);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();
        long seconds = duration.toSecondsPart();
        cpuUsageTime = String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public void calcUsagePercentage(OSProcess previousTick, OSProcess currentTick, int totalLogicCore) {
        double usage = currentTick.getProcessCpuLoadBetweenTicks(previousTick) * 100.0 / totalLogicCore;
        cpuUsagePercentage = String.format("%.1f", usage);
    }
}
