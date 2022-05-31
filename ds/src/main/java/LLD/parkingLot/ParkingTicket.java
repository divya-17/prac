package LLD.parkingLot;


public class ParkingTicket {

    private String vehicleNumber;
    private  long totalAmount;
    private  int durationOfParking;
    private ParkingSpace parkingSpace;

    public ParkingTicket(String vehicleNumber, ParkingSpace space){

        this.vehicleNumber = vehicleNumber;
        this.parkingSpace = space;
    }
}
