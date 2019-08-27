package com.example.busscheduler.models;

public class BusModel {

    private String busNumber, busName, busStopNumber, busDistance, busCurrentCapacity, busArrivalDuration, busStopPosition, busRoute, busDetails, busUniqueNumber;

    public BusModel() {
    }

    public BusModel(String busNumber, String busName, String busStopID, String busDistance, String busCurrentCapacity, String busArrivalDuration, String busStopParkingPoint, String busRoute, String busDetails, String busUniqueNumber) {
        this.busNumber = busNumber;
        this.busName = busName;
        this.busStopNumber = busStopID;
        this.busDistance = busDistance;
        this.busCurrentCapacity = busCurrentCapacity;
        this.busArrivalDuration = busArrivalDuration;
        this.busStopPosition = busStopParkingPoint;
        this.busRoute = busRoute;
        this.busDetails = busDetails;
        this.busUniqueNumber = busUniqueNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public String getBusStopNumber() {
        return busStopNumber;
    }

    public void setBusStopNumber(String busStopNumber) {
        this.busStopNumber = busStopNumber;
    }

    public String getBusDistance() {
        return busDistance;
    }

    public void setBusDistance(String busDistance) {
        this.busDistance = busDistance;
    }

    public String getBusCurrentCapacity() {
        return busCurrentCapacity;
    }

    public void setBusCurrentCapacity(String busCurrentCapacity) {
        this.busCurrentCapacity = busCurrentCapacity;
    }

    public String getBusArrivalDuration() {
        return busArrivalDuration;
    }

    public void setBusArrivalDuration(String busArrivalDuration) {
        this.busArrivalDuration = busArrivalDuration;
    }

    public String getBusStopPosition() {
        return busStopPosition;
    }

    public void setBusStopPosition(String busStopPosition) {
        this.busStopPosition = busStopPosition;
    }

    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public String getBusDetails() {
        return busDetails;
    }

    public void setBusDetails(String busDetails) {
        this.busDetails = busDetails;
    }

    public String getBusUniqueNumber() {
        return busUniqueNumber;
    }

    public void setBusUniqueNumber(String busUniqueNumber) {
        this.busUniqueNumber = busUniqueNumber;
    }
}
