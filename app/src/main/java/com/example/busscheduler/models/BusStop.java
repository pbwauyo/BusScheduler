package com.example.busscheduler.models;

public class BusStop {
    private String busStopName, buStopId, busStopLocation;

    public BusStop() {
    }

    public BusStop(String busStopName, String buStopId, String busStopLocation) {
        this.busStopName = busStopName;
        this.buStopId = buStopId;
        this.busStopLocation = busStopLocation;
    }

    public String getBusStopName() {
        return busStopName;
    }

    public void setBusStopName(String busStopName) {
        this.busStopName = busStopName;
    }

    public String getBuStopId() {
        return buStopId;
    }

    public void setBuStopId(String buStopId) {
        this.buStopId = buStopId;
    }

    public String getBusStopLocation() {
        return busStopLocation;
    }

    public void setBusStopLocation(String busStopLocation) {
        this.busStopLocation = busStopLocation;
    }
}
