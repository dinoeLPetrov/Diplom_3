import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.ProfilePage;

public class SwitchTest extends SetUpAndClose {

    @Test
    @DisplayName("Проверка клика на Личный кабинет")
    @Description("Проверка, что мы попадаем на страницу авторизации, где отображается надпись Вход")
    public void checkClickOnPersonalAccButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginIndicatorDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в Конструктор")
    @Description("Проверка перехода из личного кабинета на главную страницу через кнопку Конструктор")
    public void switchFromProfileByClickDesignerButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickConstructorButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор через логотип")
    @Description("Проверка перехода из личного кабинета на главную страницу, нажав на Лого")
    public void switchFromProfileByClickLogoBurger() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickAccountButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmailAndPassword(user);
        loginPage.clickSignInButton();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickLogoButton();
        Assert.assertTrue(mainPage.isBurgerInscriptionDisplayed());
    }
}