package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ParcelPage {
    private SelenideElement placeShipmenSign = $x("//*[text()='Оформить отправление']");

    public boolean checkShipmentPageOpened() {
        placeShipmenSign.shouldBe(Condition.visible);
        return true;
    }
}
