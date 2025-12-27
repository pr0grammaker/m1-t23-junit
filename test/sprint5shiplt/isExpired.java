package sprint5shiplt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint5.shiplt.ParcelType;
import sprint5.shiplt.PerishableParcel;

public class isExpired {
    @Test
    public void shouldReturnFalseIfParcelIsNotExpired(){
        PerishableParcel perishableParcel = new PerishableParcel("Дыня", 10, "Улица Молокова 23",
                5, ParcelType.PERISHABLE,10);

        boolean exepted = perishableParcel.isExpired(6);
        Assertions.assertFalse(exepted);
    }

    @Test
    public void shouldReturnFalseIfParcelIsNotExpiredMaxDay(){
        PerishableParcel perishableParcel = new PerishableParcel("Дыня", 10, "Улица Молокова 23",
                5, ParcelType.PERISHABLE,7);

        boolean exepted = perishableParcel.isExpired(12);
        Assertions.assertFalse(exepted);
    }

    @Test
    public void shouldReturnTrueIfParcelIsExpired(){
        PerishableParcel perishableParcel = new PerishableParcel("Дыня", 10, "Улица Молокова 23",
                5, ParcelType.PERISHABLE,3);

        boolean exepted = perishableParcel.isExpired(10);
        Assertions.assertTrue(exepted);
    }

    @Test
    public void shouldReturnTrueIfParcelIsExpiredMinDay(){
        PerishableParcel perishableParcel = new PerishableParcel("Дыня", 10, "Улица Молокова 23",
                5, ParcelType.PERISHABLE,3);

        boolean exepted = perishableParcel.isExpired(9);
        Assertions.assertTrue(exepted);
    }
}
