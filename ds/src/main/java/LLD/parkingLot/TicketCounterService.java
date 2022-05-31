package LLD.parkingLot;

public class TicketCounterService {


    public ParkingTicket generateTicketForVehicle(Vehicle vehicle, ParkingSpace space){

        ParkingTicket ticket = new ParkingTicket(vehicle.getVehicleNumber(),space);
        return ticket;
    }

}
