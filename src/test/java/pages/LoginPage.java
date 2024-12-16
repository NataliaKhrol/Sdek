package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private static final String CITY_PATTERN = ("//button[text()='%s']");
    private static final String SIZE_PATTERN = ("//p[text()='%s']");
    private final SelenideElement loginBtn = $x("//*[@data-test='auth-login-btn']");
    private final SelenideElement okBtn = $x("//*[text()='ОК']");
    private final ElementsCollection arrows = $$x("//label[text()='Размер посылки']");
    private final SelenideElement countParcel = $x("//button[text()='Рассчитать']");

    public LoginPage openPage() {
        open("ru/");
        loginBtn.shouldBe(Condition.visible);
        return this;
    }

    public LoginPage closeCookiesField() {
        okBtn.click();
        return this;
    }

    public LoginPage fillInParcelFields(String fromCity, String toCity, String parcelSize) {
        $$x(String.format(CITY_PATTERN, fromCity)).get(0).click();
        $$x(String.format(CITY_PATTERN, toCity)).get(1).click();
        arrows.get(0).click();
        $x(String.format(SIZE_PATTERN, parcelSize)).click();
        countParcel.click();
        return this;
    }
}
