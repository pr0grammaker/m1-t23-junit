package sprint5.shiplt;

public abstract class Parcel {
    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;
    protected ParcelType parcelType; // базовая стоимость у каждого типа посылки

    public Parcel(String description, int weight, String deliveryAddress, int sendDay, ParcelType parcelType) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
        this.parcelType = parcelType;
    }


    public void packageItem() {
        System.out.printf("Посылка %s упакована", getDescription());
    }

    public void deliver() {
        System.out.printf("Посылка %s доставлена по адресу %s", getDescription(), getDeliveryAddress());
    }


    public int calculateDeliveryCost() {
        return getWeight() * parcelType.getBaseCost();
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public int getSendDay() {
        return sendDay;
    }

    public void setSendDay(int sendDay) {
        this.sendDay = sendDay;
    }

    public ParcelType getParcelType() {
        return parcelType;
    }

    public void setParcelType(ParcelType parcelType) {
        this.parcelType = parcelType;
    }
}
