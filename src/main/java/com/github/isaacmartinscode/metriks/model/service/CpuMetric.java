package com.github.isaacmartinscode.metriks.model.service;

import com.github.isaacmartinscode.metriks.model.entities.CpuProcess;
import com.github.isaacmartinscode.metriks.model.entities.Process;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import oshi.hardware.CentralProcessor;
import oshi.software.os.OSProcess;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CpuMetric {

    private static CentralProcessor.ProcessorIdentifier cpuIdentifier = SystemService.cpu.getProcessorIdentifier();
    private static String cpuName = cpuIdentifier.getName();
    private static double baseClock = cpuIdentifier.getVendorFreq() / 1_000_000_000.0;
    private static double userPercentage, systemPercentage;
    private static int totalCore = SystemService.cpu.getPhysicalProcessorCount();
    private static int totalLogicCore = SystemService.cpu.getLogicalProcessorCount();
    private static int totalProcesses, totalProcessesThreads;
    private static long[] prevTicks;
    private static List<OSProcess> processes = new ArrayList<>();
    private static HashMap<Integer, OSProcess> prevOSProcess;
    private static HashMap<Integer, Process> processHashMap;
    private static ObservableList<Process> processList;
    private static ObservableList<XYChart.Data<Number, Number>> userSeriePointList, systemSeriePointList;
    private static ScheduledExecutorService scheduler;
    private static int tickCounter = 0;
    private static boolean updating = false;

    private void calcUsagePercentage() {
        if(updating) {
            long[] currentTicks = SystemService.cpu.getSystemCpuLoadTicks();
            long userTimeVariation = currentTicks[CentralProcessor.TickType.USER.getIndex()] - prevTicks[CentralProcessor.TickType.USER.getIndex()];
            long systemTimeVariation = currentTicks[CentralProcessor.TickType.SYSTEM.getIndex()] - prevTicks[CentralProcessor.TickType.SYSTEM.getIndex()];
            long totalTimeVariation = 0;

            for (int i = 0; i < currentTicks.length; i++) {
                totalTimeVariation += (currentTicks[i] - prevTicks[i]);
            }

            userPercentage = (double) userTimeVariation / totalTimeVariation;
            systemPercentage = (double) systemTimeVariation / totalTimeVariation;

            prevTicks = currentTicks;
        } else {
            prevTicks = SystemService.cpu.getSystemCpuLoadTicks();
        }
    }

    private void calcProcessInfo() {
        for(OSProcess p : processes) {
            totalProcessesThreads += p.getThreadCount();
            totalProcesses++;
        }
    }

    private void refreshProcessList() {
        processes = SystemService.os.getProcesses();
        processes.removeIf(p -> p.getState() == OSProcess.State.INVALID);
        if(updating) {
            for(OSProcess p : processes) {
                int pid = p.getProcessID();
                CpuProcess cpuProcess;
                if(processHashMap.containsKey(pid)) {
                    cpuProcess = (CpuProcess) processHashMap.get(pid);
                    processList.remove(cpuProcess);
                    cpuProcess.calcUsagePercentage(prevOSProcess.get(pid), p, totalLogicCore);
                    cpuProcess.convertCpuUsageTime(p.getUserTime() + p.getKernelTime());
                } else {
                    cpuProcess = new CpuProcess(p.getName(), pid, p.getThreadCount(), p.getUserID(), p.getUserTime() + p.getKernelTime());
                    processHashMap.put(pid, cpuProcess);
                }
                processList.add(cpuProcess);
                prevOSProcess.put(pid, p);
            }
        } else {
            for(OSProcess p : processes) {
                int pid = p.getProcessID();
                CpuProcess cpuProcess = new CpuProcess(p.getName(), pid, p.getThreadCount(), p.getUserID(), p.getUserTime() + p.getKernelTime());
                processHashMap.put(pid, cpuProcess);
                prevOSProcess.put(pid, p);
            }
            processList.addAll(processHashMap.values());
        }
    }

    private void refreshSeriePointLists() {
        userSeriePointList.add(new XYChart.Data<>(tickCounter, userPercentage));
        systemSeriePointList.add(new XYChart.Data<>(tickCounter, systemPercentage));

        if(tickCounter == 59) {
            userSeriePointList.remove(0);
            systemSeriePointList.remove(0);
            tickCounter = 0;
        } else {
            tickCounter++;
        }
    }

    public void initScheduledRefresh() {
        if(updating) {
            return;
        }
        Runnable refresh = () -> {
            calcUsagePercentage();
            refreshProcessList();
            calcProcessInfo();
            refreshSeriePointLists();
        };
        scheduler.scheduleAtFixedRate(refresh, 0, 1, TimeUnit.SECONDS);
        updating = true;
    }

    public static String getCpuName() {
        return cpuName;
    }

    public static double getBaseClock() {
        return baseClock;
    }

    public static double getUserPercentage() {
        return userPercentage;
    }

    public static double getSystemPercentage() {
        return systemPercentage;
    }

    public static int getTotalCore() {
        return totalCore;
    }

    public static int getTotalLogicCore() {
        return totalLogicCore;
    }

    public static int getTotalProcesses() {
        return totalProcesses;
    }

    public static int getTotalProcessesThreads() {
        return totalProcessesThreads;
    }

    public static ObservableList<Process> getProcessList() {
        return processList;
    }

    public static ObservableList<XYChart.Data<Number, Number>> getUserSeriePointList() {
        return userSeriePointList;
    }

    public static ObservableList<XYChart.Data<Number, Number>> getSystemSeriePointList() {
        return systemSeriePointList;
    }
}
