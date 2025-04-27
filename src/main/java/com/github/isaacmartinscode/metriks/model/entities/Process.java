package com.github.isaacmartinscode.metriks.model.entities;

public abstract class Process {

    private String name;
    private int pId;
    private int threads;
    private String user;

    public Process(String name, int pId, int threads, String user) {
        this.name = name;
        this.pId = pId;
        this.threads = threads;
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public abstract double calcUsagePercentage();
}
