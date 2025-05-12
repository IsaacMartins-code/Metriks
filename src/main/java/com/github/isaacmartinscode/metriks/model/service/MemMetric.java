package com.github.isaacmartinscode.metriks.model.service;

import com.github.isaacmartinscode.metriks.model.entities.MemProcess;
import com.github.isaacmartinscode.metriks.model.entities.Process;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;
import oshi.hardware.PhysicalMemory;
import oshi.software.os.OSProcess;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MemMetric {

    private static final List<PhysicalMemory> physicalMemories = SystemService.hardware.getMemory().getPhysicalMemory();
    private static double totalMemory = convertTotalMemory();
    private static double usableMemory = SystemService.hardware.getMemory().getTotal() / Math.pow(1024, 3);
    private static double hardwareReserved = totalMemory - usableMemory;
    private static double usedMemory;
    private static int usedMemoryPercentage;
    private static int frequency = convertMemoryFrequency();
    private static int totalSlotsUsed = physicalMemories.size();
    private static String type = physicalMemories.getFirst().getMemoryType();
    private static List<OSProcess> processes = new ArrayList<>();
    private static final HashMap<Integer, MemProcess> processHashMap = new HashMap<>();
    private static final ObservableList<Process> processList = FXCollections.observableArrayList();
    private static final ObservableList<XYChart.Data<Number, Number>> seriePointList = FXCollections.observableArrayList();
    private static final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private static boolean updating = false;
    private static int tickCounter = 0;

    private void convertMemoryUsages() {
        usedMemory = usableMemory - SystemService.hardware.getMemory().getAvailable() / Math.pow(1024, 3);
        usedMemoryPercentage = (int) (usedMemory * 100 / usableMemory);
    }

    private static double convertTotalMemory() {
        long total = 0;
        for(PhysicalMemory memory : physicalMemories) {
            total += memory.getCapacity();
        }
        return total / Math.pow(1024, 3);
    }

    private static int convertMemoryFrequency() {
        long totalHertz = 0;
        for(PhysicalMemory memory : physicalMemories) {
            totalHertz += memory.getClockSpeed();
        }
        totalHertz /= 2;
        return (int) (totalHertz / 1_000_000.0);
    }

    private void refreshProcessList() {
        processes.clear();
        processes = SystemService.os.getProcesses();
        processes.removeIf(p -> p.getState() == OSProcess.State.INVALID || p.getProcessID() == 0);
        for(OSProcess p : processes) {
            MemProcess memProcess;
            int pid = p.getProcessID();
            String user = p.getUser().equals("unknown") ? "Desconhecido" : p.getUser();
            if (updating && processHashMap.containsKey(pid)) {
                memProcess = processHashMap.get(pid);
                memProcess.calcUsagePercentage(p.getResidentSetSize());
            } else {
                memProcess = new MemProcess(p.getName(), pid, p.getThreadCount(), user);
                processHashMap.put(pid, memProcess);
            }
        }
        processList.setAll(processHashMap.values()
                .stream()
                .sorted(Comparator.comparing(MemProcess::getFormattedUsagePercentage).reversed())
                .collect(Collectors.toList())
        );
    }

    private void refreshSeriePointList() {
        seriePointList.forEach(data -> data.setXValue(data.getXValue().intValue() + 1));
        if(updating) {
            seriePointList.addFirst(new XYChart.Data<>(0, usedMemoryPercentage));
        } else {
            seriePointList.addFirst(new XYChart.Data<>(0, 0));
        }
        if (tickCounter > 60) {
            seriePointList.removeLast();
        }
        tickCounter++;
    }

    public void initScheduledRefresh() {
        if(updating) {
            return;
        }
        Runnable refresh = () -> {
            convertMemoryUsages();
            refreshProcessList();
            refreshSeriePointList();
            updating = true;
        };
        scheduler.scheduleAtFixedRate(refresh, 0, (long) 1.5, TimeUnit.SECONDS);
    }

    public double getTotalMemory() {
        return totalMemory;
    }

    public double getUsedMemory() {
        return usedMemory;
    }

    public int getUsedMemoryPercentage() {
        return usedMemoryPercentage;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getTotalSlotsUsed() {
        return totalSlotsUsed;
    }

    public String getType() {
        return type;
    }

    public static double getUsableMemory() {
        return usableMemory;
    }

    public static double getHardwareReserved() {
        return hardwareReserved;
    }

    public ObservableList<Process> getProcessList() {
        return processList;
    }

    public XYChart.Series<Number, Number> getSerie() {
        return new XYChart.Series<>(seriePointList);
    }
}
