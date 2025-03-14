package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath(".//button[text() = 'Выход']"); //локатор кнопки Выход

    private final By constructorButton = By.xpath(".//p[text()='Конструктор']"); //локатор кнопки Конструктор наверху слева

    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']"); //локатор логотипа

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик на Выход")
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    @Step("Клик на Конструктор")
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    @Step("Клик на Лого")
    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
}