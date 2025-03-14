import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ForgotPasswordPage;
import pages.RegistrationPage;

public class EntranceTest extends SetUpAndClose {

    @Test
    @DisplayName("Вход в систему с помощью кнопки Войти в аккаунт на главной странице")
    @Description("Подтверждение входа с помощью кнопки Войти в аккаунт на главной странице с последующей авторизацией")
    public void loginThroughSignInButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Вход в систему с помощью кнопки - Личный кабинет")
    @Description("Подтверждение входа с помощью кнопки Личный кабинет на главной странице с последующей авторизацией")
    public void loginThroughPersonalAccountButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Вход в систему с помощью кнопки Войти в регистрационной форме")
    @Description("Подтверждение входа в систему в регистрационной форме с последующей авторизацией")
    public void loginThroughTheButtonInTheRegistrationForm() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.open();
        registrationPage.registerUser(user);
        registrationPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());
    }

    @Test
    @DisplayName("Проверка логина с помощью кнопки Войти в форме восстановления пароля")
    @Description("Подтверждение логина в форме восстановления пароля с последующей авторизацией")
    public void loginFromRecoveryPage() {
        ForgotPasswordPage passRecoveryPage = new ForgotPasswordPage(driver);
        passRecoveryPage.open();
        passRecoveryPage.clickSignInButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        MainPage mainPage = new MainPage(driver);
        Assert.assertTrue(mainPage.isMainPageOpen());

    }}