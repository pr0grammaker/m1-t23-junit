package sprint5shiplt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sprint5.shiplt.ParcelBox;
import sprint5.shiplt.ParcelType;
import sprint5.shiplt.StandardParcel;

public class DeliveryApp {

    @Test
    public void shouldNotAddParcelIfWeightExceeded(){
        ParcelBox standartBox = new ParcelBox(100);
        StandardParcel standardParcel1 = new StandardParcel("Ваза", 40, "Улица Пушкина 54",
                4, ParcelType.STANDART);

        StandardParcel standardParcel2 = new StandardParcel("Ваза", 50, "Улица Пушкина 54",
                4, ParcelType.STANDART);

        StandardParcel standardParcel3 = new StandardParcel("Ваза", 50, "Улица Пушкина 54",
                4, ParcelType.STANDART);

        standartBox.addParcel(standardParcel1);
        standartBox.addParcel(standardParcel2);
        standartBox.addParcel(standardParcel3);

        Assertions.assertEquals(2, standartBox.getAllParcels().size());
    }

    @Test
    public void shouldAddParcelIfWeightIsParcelBecomeMax(){
        ParcelBox box = new ParcelBox(50);

        StandardParcel standardParcel3 = new StandardParcel("Ваза", 50, "Улица Пушкина 54",
                4, ParcelType.STANDART);

        box.addParcel(standardParcel3);

        Assertions.assertEquals(1, box.getAllParcels().size());
    }

    @Test
    public void shouldAddParcelIfWeightIsParcelBecomeMin(){
        ParcelBox box = new ParcelBox(1);

        StandardParcel standardParcel3 = new StandardParcel("Ваза", 1, "Улица Пушкина 54",
                4, ParcelType.STANDART);

        box.addParcel(standardParcel3);

        Assertions.assertEquals(1, box.getAllParcels().size());
    }


}
