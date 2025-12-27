package sprint5shiplt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint5.shiplt.FragileParcel;
import sprint5.shiplt.ParcelType;
import sprint5.shiplt.PerishableParcel;
import sprint5.shiplt.StandardParcel;

public class Parcel {

    @Test
    public void shouldReturnDeliveryCostStandartParcel() {
        StandardParcel standardParcel = new StandardParcel("Ваза", 10, "Улица Пушкина 54",
                4, ParcelType.STANDART);

        int actual = standardParcel.calculateDeliveryCost();
        int expected = 10 * 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeliveryCostPerishableParcel() {
        PerishableParcel perishableParcel = new PerishableParcel("Ваза", 10, "Улица Пушкина 54",
                4, ParcelType.PERISHABLE, 5);

        int actual = perishableParcel.calculateDeliveryCost();
        int expected = 10 * 3;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeliveryCostFragileParcel() {
        FragileParcel fragileParcel = new FragileParcel("Ваза", 10, "Улица Пушкина 54",
                4, ParcelType.FRAGILE);

        int actual = fragileParcel.calculateDeliveryCost();
        int expected = 10 * 4;
        Assertions.assertEquals(expected, actual);
    }
}
