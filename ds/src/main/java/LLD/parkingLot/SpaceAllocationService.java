package LLD.parkingLot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpaceAllocationService {

    private List<ParkingSpace> twoWhellerParkingSpaces;
    private List<ParkingSpace> fourWhellerParkingSpaces;
    private List<ParkingSpace> heavyVehicleParkingSpaces;


    public SpaceAllocationService(){

       twoWhellerParkingSpaces = new ArrayList<>(Arrays.asList(new ParkingSpace(1,
                ParkingSpaceStatus.AVAILABLE,
                ParkingLotCategory.TWO_WHELLER_LOT,
                10),new ParkingSpace(2,
                ParkingSpaceStatus.AVAILABLE,
                ParkingLotCategory.TWO_WHELLER_LOT,
                10),new ParkingSpace(3,
                ParkingSpaceStatus.AVAILABLE,
                ParkingLotCategory.TWO_WHELLER_LOT,
                10)));

        fourWhellerParkingSpaces = new ArrayList<>(Arrays.asList(new ParkingSpace(4,
                ParkingSpaceStatus.AVAILABLE,
                ParkingLotCategory.FOUR_WHELLER_LOT,
                50),new ParkingSpace(5,
                ParkingSpaceStatus.AVAILABLE,
                ParkingLotCategory.FOUR_WHELLER_LOT,
                50)));

         heavyVehicleParkingSpaces = new ArrayList<>(Arrays.asList(new ParkingSpace(6,
                ParkingSpaceStatus.AVAILABLE,
                ParkingLotCategory.HEAVY_VEHICLES_LOT,
                100)));




    }

    public List<ParkingSpace> getAvailableParkingSpaceForVehicle(Vehicle vehicle){

        if(vehicle.getVehicleType() == VehicleType.TWO_WHELLER){
            return getAvailableSpaces(twoWhellerParkingSpaces);
        }
        if(vehicle.getVehicleType() == VehicleType.FOUR_WHELLER){
            return getAvailableSpaces(fourWhellerParkingSpaces);
        }
        if(vehicle.getVehicleType() == VehicleType.HEAVY_VEHICLES){
            return getAvailableSpaces(heavyVehicleParkingSpaces);
        }
        return null;
    }

    private List<ParkingSpace> getAvailableSpaces(List<ParkingSpace> parkingSpaces) {

        List<ParkingSpace> availableSpaces = new ArrayList<>();

        for(ParkingSpace space: parkingSpaces){
            if(space.getSpaceStatus() == ParkingSpaceStatus.AVAILABLE){
                availableSpaces.add(space);
            }
        }
        return availableSpaces;
    }

    public ParkingSpace assignParkingLot(Vehicle vehicle){


        List<ParkingSpace> spaces = getAvailableParkingSpaceForVehicle(vehicle);
        if(spaces != null && !spaces.isEmpty()){

            ParkingSpace assignedSpace  = spaces.get(0);
            assignedSpace.setSpaceStatus(ParkingSpaceStatus.OCCUPIED);

            vehicle.setEntryTime(System.currentTimeMillis());

            return assignedSpace;
        }

         return null;
    }

    public void freeUpParkingLot(ParkingSpace parkingSpace){
        parkingSpace.setSpaceStatus(ParkingSpaceStatus.AVAILABLE);
    }
}
