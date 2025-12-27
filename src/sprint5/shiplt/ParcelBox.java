package sprint5.shiplt;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox {

    private final List<StandardParcel> standartBox = new ArrayList<>();
    private final List<PerishableParcel> perishableBox = new ArrayList<>();
    private final List<FragileParcel> fragileBox = new ArrayList<>();

    private final int maxWeight;

    public ParcelBox(int maxWeight) {
        this.maxWeight = maxWeight;
    }


    private boolean canAddParcel(List<? extends Parcel> box, int maxWeight, Parcel parcel) {
        int totalWeight = 0;
        for (Parcel p : box) {
            totalWeight += p.getWeight();
        }

        if (totalWeight + parcel.getWeight() > maxWeight) {
            System.out.printf("Невозможно добавить посылку: превышен максимальный вес %s ! ", parcel.getParcelType());
            return false;
        }

        return true;
    }


    public void addParcel(Parcel parcel) {
        if (parcel instanceof StandardParcel) {
            if (!canAddParcel(standartBox, maxWeight, parcel)) return;
            standartBox.add((StandardParcel) parcel);

        } else if (parcel instanceof PerishableParcel) {
            if (!canAddParcel(perishableBox, maxWeight, parcel)) return;
            perishableBox.add((PerishableParcel) parcel);

        } else if (parcel instanceof FragileParcel) {
            if (!canAddParcel(fragileBox, maxWeight, parcel)) return;
            fragileBox.add((FragileParcel) parcel);
        }
    }


    public List<Parcel> getAllParcels() {
        List<Parcel> allParcels = new ArrayList<>();
        allParcels.addAll(standartBox);
        allParcels.addAll(perishableBox);
        allParcels.addAll(fragileBox);
        return allParcels;
    }

}
