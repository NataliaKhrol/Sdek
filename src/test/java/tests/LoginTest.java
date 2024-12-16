package tests;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest {
    private final String fromCity = "Москва";
    private final String destinationCity = "Санкт-Петербург";
    private final String parcelSize = "Короб S";

    @Test
    public void checkOpen() {
        loginPage.openPage()
                .closeCookiesField()
                .fillInParcelFields(fromCity, destinationCity, parcelSize);
        assertTrue(parcelPage.checkShipmentPageOpened(), "Place shipment sign is not visible");
    }
}
