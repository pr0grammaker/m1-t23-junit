package sprint5.shiplt;

public class PerishableParcel extends Parcel {
    private int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay,
                            ParcelType parcelType, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay, parcelType);
        this.timeToLive = timeToLive;
    }


    public boolean isExpired(int currentDay) {
        if (sendDay + timeToLive >= currentDay) {
            return false;
        }
        return true;
    }

}
