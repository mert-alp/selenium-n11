package Pages;

import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BaseTest {

    @Step("E-posta alanı doldurulur")
    public LoginPage fillEmail(String text){
        WebElement element = driver.findElement(By.id("email"));
        element.clear();
        element.sendKeys(text);
        return this;
    }

    @Step("Parola alanı doldurulur")
    public LoginPage fillPassword(String text){
        driver.findElement(By.id("password")).sendKeys(text);
        return this;
    }

    @Step("Login buttonuna tıklanır")
    public LoginPage clickLogin(){
        driver.findElement(By.id("loginButton")).click();
        return this;
    }

    @Step("Hata mesajı kontrolü")
    public LoginPage errorMessageController(String text){
        String message = driver.findElement(By.cssSelector("[id='loginForm'] [class='error-message']")).getText();
        Allure.addAttachment(message, "");
        screenshot();
        Assert.assertEquals(message, text);
        return this;
    }
    @Step("Search alanı doldurulur")
    public LoginPage SearchingFill(String text){
        driver.findElement(By.id("searchData")).sendKeys(text);
        return this;
    }
}
