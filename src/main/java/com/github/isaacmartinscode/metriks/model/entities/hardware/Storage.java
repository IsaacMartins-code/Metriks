package com.github.isaacmartinscode.metriks.model.entities.hardware;

public class Storage {

    private String name;
    private double usedSize;
    private double usableSize;
    private double grossSize;
    private double gBWrites;
    private double gBReads;
    private double writeSpeed;
    private double readSpeed;
    private double uptimePercentage;
    private String formattedUptimePercentage = "0 %";
    private String formattedGrossSize;
    private String formattedGbWrite;
    private String formattedGbRead;
    private String formattedWriteSpeed;
    private String formattedReadSpeed;

    public Storage(String name, long usedSize, long usableSize, long grossSize, long writeBytes, long readBytes) {
        this.name = name;
        this.usedSize = usedSize / Math.pow(1024, 3);
        this.usableSize = usableSize / Math.pow(1024, 3);
        this.grossSize = grossSize / Math.pow(1024, 3);
        formattedGrossSize = String.format("%.1f", this.grossSize) + " GB";
        convertWrites(writeBytes);
        convertReads(readBytes);
    }

    public void calcWriteSpeed(long prevBytes, long currentBytes) {
        long bytes = (currentBytes - prevBytes);
        if(bytes >= 1_000_000_000) {
            writeSpeed = bytes / Math.pow(1024, 3);
            formattedWriteSpeed = String.format("%.1f", writeSpeed) + " GB/s";

        } else if (bytes >= 1_000_000) {
            writeSpeed = bytes / Math.pow(1024, 2);
            formattedWriteSpeed = String.format("%.1f", writeSpeed) + " MB/s";

        } else if(bytes >= 1_000 || bytes < 1_000) {
            writeSpeed = bytes / 1024.0;
            formattedWriteSpeed = String.format("%.1f", writeSpeed) + " KB/s";
        }
    }

    public void calcReadSpeed(long prevBytes, long currentBytes) {
        long bytes = (currentBytes - prevBytes);
        if(bytes >= 1_000_000_000) {
            readSpeed = bytes / Math.pow(1024, 3);
            formattedReadSpeed = String.format("%.1f", readSpeed) + " GB/s";

        } else if (bytes >= 1_000_000) {
            readSpeed = bytes / Math.pow(1024, 2);
            formattedReadSpeed = String.format("%.1f", readSpeed) + " MB/s";

        } else if(bytes >= 1_000 || bytes < 1_000) {
            readSpeed = bytes / 1024.0;
            formattedReadSpeed = String.format("%.1f", readSpeed) + " KB/s";
        }
    }

    public void calcUptimePercentage(long prevTransferTime, long currentTransferTime) {
        uptimePercentage = ((currentTransferTime - prevTransferTime) / 1500.0) * 100.0;
        formattedUptimePercentage = (int) uptimePercentage + " %";
    }

    public void convertWrites(long writeBytes) {
        gBWrites = writeBytes / Math.pow(1024, 3);
        formattedGbWrite = String.format("%.1f", gBWrites) + " GB";
    }

    public void convertReads(long readBytes) {
        gBReads = readBytes / Math.pow(1024, 3);
        formattedGbRead = String.format("%.1f", gBReads) + " GB";
    }

    public String getName() {
        return name;
    }

    public double getUsedSize() {
        return usedSize;
    }

    public double getUsableSize() {
        return usableSize;
    }

    public double getGrossSize() {
        return grossSize;
    }

    public double getGbWrites() {
        return gBWrites;
    }

    public double getGbReads() {
        return gBReads;
    }

    public double getWriteSpeed() {
        return writeSpeed;
    }

    public double getReadSpeed() {
        return readSpeed;
    }

    public double getUptimePercentage() {
        return uptimePercentage;
    }

    public String getFormattedUptimePercentage() {
        return formattedUptimePercentage;
    }

    public String getFormattedGbWrite() {
        return formattedGbWrite;
    }

    public String getFormattedGrossSize() {
        return formattedGrossSize;
    }

    public String getFormattedGbRead() {
        return formattedGbRead;
    }

    public String getFormattedWriteSpeed() {
        return formattedWriteSpeed;
    }

    public String getFormattedReadSpeed() {
        return formattedReadSpeed;
    }
}
