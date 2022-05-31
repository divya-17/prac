package LLD.parkingLot;

import java.util.List;

public class ParkingLot {


    SpaceAllocationService  spaceAllocationService;
    TicketCounterService ticketCounterService;

    public ParkingLot() {
        spaceAllocationService = new SpaceAllocationService();
        ticketCounterService = new TicketCounterService();
    }

    public void entry(Vehicle vehicle) {

        List<ParkingSpace> spaceList = spaceAllocationService.getAvailableParkingSpaceForVehicle(vehicle);
        System.out.println("Available Spaces are -> "+spaceList);

        ParkingSpace assignedParkingSpace = spaceAllocationService.assignParkingLot(vehicle);
        System.out.println("Parking space assigned is "+assignedParkingSpace);

        ticketCounterService.generateTicketForVehicle(vehicle,assignedParkingSpace);



    }

    public void exit(Vehicle vehicle1) {
    }
}
