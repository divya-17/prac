package LLD.parkingLot;

public class ParkingSpace {

    private int parkingSpaceId;
    private ParkingSpaceStatus spaceStatus;
    private ParkingLotCategory category;
    private long pricePerHour;

    public ParkingSpace(int parkingSpaceId,ParkingSpaceStatus status, ParkingLotCategory category, long price){

        this.spaceStatus = status;
        this.category = category;
        this.pricePerHour = price;
        this.parkingSpaceId = parkingSpaceId;
    }

    public ParkingSpaceStatus getSpaceStatus() {
        return spaceStatus;
    }

    public void setSpaceStatus(ParkingSpaceStatus spaceStatus) {
        this.spaceStatus = spaceStatus;
    }

    public ParkingLotCategory getCategory() {
        return category;
    }

    public void setCategory(ParkingLotCategory category) {
        this.category = category;
    }

    public long getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(long pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "parkingSpaceId=" + parkingSpaceId +
                ", spaceStatus=" + spaceStatus +
                ", category=" + category +
                ", pricePerHour=" + pricePerHour +
                '}';
    }
}
