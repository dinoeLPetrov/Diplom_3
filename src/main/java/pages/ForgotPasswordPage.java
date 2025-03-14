package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static utils.Urls.RECOVERY_PASSWORD_URL;

public class ForgotPasswordPage {

    private final By signInButton = By.xpath(".//a[text()='Войти']"); //локатор кнопки Войти на странице восстановления пароля
    private final WebDriver driver;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Страница восстановления пароля")
    public void open() {
        driver.get(RECOVERY_PASSWORD_URL);
    }

    @Step("Клик на кнопку Войти")
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}