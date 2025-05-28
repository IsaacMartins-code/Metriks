package com.github.isaacmartinscode.metriks.model.entities.hardware;

public class networkAdapter {

    private final String adapterName;
    private final String interfaceName;
    private double gBSent;
    private double gBReceived;
    private final String ipvFour;
    private final String ipvSix;
    private final String mac;
    private long packetsSent;
    private long packetsReceived;
    private double sendSpeed;
    private double receiveSpeed;
    private String formattedGbSent;
    private String formattedGbReceived;
    private String formattedSendSpeed;
    private String formattedReceiveSpeed;

    public networkAdapter(String adapterName, String interfaceName, long bytesSent, long bytesReceived, String ipvFour, String ipvSix, String mac, long packetsSent, long packetsReceived) {
        this.adapterName = adapterName;
        this.interfaceName = interfaceName;
        convertSent(bytesSent);
        convertReceived(bytesReceived);
        this.ipvFour = ipvFour;
        this.ipvSix = ipvSix;
        this.mac = mac;
        this.packetsSent = packetsSent;
        this.packetsReceived = packetsReceived;
    }

    public void calcSentSpeed(long prevBytes, long currentBytes) {
        long bits;
        if(currentBytes >= prevBytes) {
            bits = (currentBytes - prevBytes) * 8;
        } else {
            bits = 0;
        }
        if(bits >= 1_000_000_000) {
            sendSpeed = bits / Math.pow(1000, 3);
            formattedSendSpeed = String.format("%.1f", sendSpeed) + " Gbps";

        } else if (bits >= 1_000_000) {
            sendSpeed = bits / Math.pow(1000, 2);
            formattedSendSpeed = String.format("%.1f", sendSpeed) + " Mbps";

        } else {
            sendSpeed = bits / 1000.0;
            formattedSendSpeed = String.format("%.1f", sendSpeed) + " Kbps";
        }
    }

    public void calcReceivedSpeed(long prevBytes, long currentBytes) {
        long bits;
        if(currentBytes >= prevBytes) {
            bits = (currentBytes - prevBytes) * 8;
        } else {
            bits = 0;
        }
        if(bits >= 1_000_000_000) {
            receiveSpeed = bits / Math.pow(1000, 3);
            formattedReceiveSpeed = String.format("%.1f", receiveSpeed) + " Gbps";

        } else if (bits >= 1_000_000) {
            receiveSpeed = bits / Math.pow(1000, 2);
            formattedReceiveSpeed = String.format("%.1f", receiveSpeed) + " Mbps";

        } else {
            receiveSpeed = bits / 1000.0;
            formattedReceiveSpeed = String.format("%.1f", receiveSpeed) + " Kbps";
        }
    }

    public void convertSent(long sentBytes) {
        gBSent = sentBytes / Math.pow(1024, 3);
        formattedGbSent = String.format("%.1f", gBSent) + " GB";
    }

    public void convertReceived(long receiveBytes) {
        gBReceived = receiveBytes / Math.pow(1024, 3);
        formattedGbReceived = String.format("%.1f", gBReceived) + " GB";
    }

    public String getAdapterName() {
        return adapterName;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public double getGbSent() {
        return gBSent;
    }

    public double getGbReceived() {
        return gBReceived;
    }

    public String getIpvFour() {
        return ipvFour;
    }

    public String getIpvSix() {
        return ipvSix;
    }

    public String getMac() {
        return mac;
    }

    public long getPacketsSent() {
        return packetsSent;
    }

    public long getPacketsReceived() {
        return packetsReceived;
    }

    public double getSendSpeed() {
        return sendSpeed;
    }

    public double getReceiveSpeed() {
        return receiveSpeed;
    }

    public String getFormattedGbSent() {
        return formattedGbSent;
    }

    public String getFormattedGbReceived() {
        return formattedGbReceived;
    }

    public String getFormattedSendSpeed() {
        return formattedSendSpeed;
    }

    public String getFormattedReceiveSpeed() {
        return formattedReceiveSpeed;
    }

    public void setPacketsSent(long packetsSent) {
        this.packetsSent = packetsSent;
    }

    public void setPacketsReceived(long packetsReceived) {
        this.packetsReceived = packetsReceived;
    }
}

