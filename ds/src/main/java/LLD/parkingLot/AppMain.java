package LLD.parkingLot;

public class AppMain {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot();

        Vehicle vehicle1 = new Vehicle("HR4298",VehicleType.FOUR_WHELLER);


        parkingLot.entry(vehicle1);
        parkingLot.exit(vehicle1);
    }
}
