import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.util.concurrent.TimeUnit;

public class ConstructorTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Переход к разделу - Булки")
    @Description("Проверка того, выбрана ли кнопка, путем получения текста")
    public void menuBunIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickBunsButton();
        Assert.assertEquals("Булки", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Переход к разделу -  Соусы")
    @Description("Проверка того, выбрана ли кнопка, путем получения текста")
    public void menuSaucesIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickFillingsButton();
        mainPage.clickSaucesButton();
        Assert.assertEquals("Соусы", mainPage.getTextFromSelectedMenu());
    }

    @Test
    @DisplayName("Переход к разделу - Начинки")
    @Description("Проверка того, выбрана ли кнопка, путем получения текста")
    public void menuFillingIsActiveByClick() {
        mainPage = new MainPage(driver);
        mainPage.open();
        mainPage.clickSaucesButton();
        mainPage.clickFillingsButton();
        Assert.assertEquals("Начинки", mainPage.getTextFromSelectedMenu());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}