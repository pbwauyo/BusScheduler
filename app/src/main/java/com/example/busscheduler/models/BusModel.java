package com.example.busscheduler.models;

public class BusModel {

    private String arrivalTime, departureTime, stationName, busNumber, arrivalDuration;

    public BusModel(String arrivalTime, String departureTime, String stationName, String busNumber, String arrivalDuration) {
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.stationName = stationName;
        this.busNumber = busNumber;
        this.arrivalDuration = arrivalDuration;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getArrivalDuration() {
        return arrivalDuration;
    }

    public void setArrivalDuration(String arrivalDuration) {
        this.arrivalDuration = arrivalDuration;
    }
}
