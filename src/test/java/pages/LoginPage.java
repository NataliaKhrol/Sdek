package pages;

import com.codeborne.selenide.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private static final String CITY_PATTERN = ("//button[text()='%s']");
    private static final String SIZE_PATTERN = ("//p[text()='%s']");
    private SelenideElement loginBtn = $x("//*[@data-test='auth-login-btn']");
    private SelenideElement okBtn = $x("//*[text()='ОК']");
    private ElementsCollection arrows = $$x("//label[text()='Размер посылки']");
    private SelenideElement parcelSizeS = $x("//p[text()='Короб S']");
    private SelenideElement countParcel = $x("//button[text()='Рассчитать']");

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
