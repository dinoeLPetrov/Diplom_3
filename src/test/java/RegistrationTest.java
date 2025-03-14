import api.Credentials;
import api.User;
import api.UserSteps;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

import static utils.DataGenerator.*;

public class RegistrationTest {
    private WebDriver driver;
    private User user;

    @Before
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/yandexdriver.exe"); //для запуска тестов в Яндекс браузере нужно раскомментировать эту строку
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Проверка правильности пароля при регистрации")
    @Description("Регистрация на главной странице с правильным паролем длиной более 5 символов")
    public void registrationOnMainPageSuccess() {
        user = new User(RANDOM_EMAIL, RANDOM_PASS, RANDOM_NAME);
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickRegisterButton();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
        registrationPage.clickRegister();
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка регистрации с неправильным паролем")
    @Description("Проверка регистрации с использованием неверного пароля, состоящего из 5 символов")
    public void checkRegistrationWithWrongPassError() {
        user = new User(RANDOM_EMAIL, RANDOM_PASS_5_CHAR, RANDOM_NAME);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        Assert.assertTrue(registrationPage.isWrongPasswordDisplayed());
    }

    @After
    public void tearDown() {
        UserSteps userSteps = new UserSteps();
        Credentials credentials = new Credentials(user.getEmail(), user.getPassword());
        ValidatableResponse responseLogin = userSteps.login(credentials);
        String accessToken = userSteps.getAccessToken(responseLogin);
        userSteps.deletingUsersAfterTests(accessToken);
        driver.quit();
    }
}