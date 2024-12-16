package tests;

import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import pages.LoginPage;
import pages.ParcelPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {
    LoginPage loginPage;
    ParcelPage parcelPage;

    @Before
    public void setUp() {
        Configuration.baseUrl = "https://www.cdek.ru/";
        Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
        loginPage = new LoginPage();
        parcelPage = new ParcelPage();
    }

    @After
    public void close() {
        closeWebDriver();
    }
}
