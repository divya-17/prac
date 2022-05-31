package LLD.parkingLot;

import sun.security.krb5.internal.Ticket;

public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;
    private long entryTime;
    private long exitTime;
    private Ticket parkingTicket;
    private ParkingSpace parkingSpace;


    public Vehicle(String vehicleNumber, VehicleType vehicleType){

        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime(long exitTime) {
        this.exitTime = exitTime;
    }

    public Ticket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(Ticket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(ParkingSpace parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleNumber='" + vehicleNumber + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
