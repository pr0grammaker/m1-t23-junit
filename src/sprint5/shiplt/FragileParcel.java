package sprint5.shiplt;

public class FragileParcel extends Parcel implements Trackable {


    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay, ParcelType parcelType) {
        super(description, weight, deliveryAddress, sendDay, parcelType);
    }

    @Override
    public void packageItem() {
        System.out.printf("Посылка %s обёрнута в защитную плёнку", getDescription());
    }


    @Override
    public void reportStatus(String newLocation) {
        System.out.println();
        System.out.printf("Хрупкая посылка <<%s> изменила местоположение на %s", getDescription(), newLocation);
        System.out.println();
    }
}
