import Base.BaseTest;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {
    LoginPage loginPage = new LoginPage();


    @Test(description = "Başarılı giriş kontrolü")
    public void LoginSuccesfull() throws InterruptedException {
                loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();
        sleep(3000);
    }

    @Test(description = "Başarısız giriş kontrolü")
    public void LoginUnSuccesfull() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword("TestYanlisSifre")
                .clickLogin();
        Thread.sleep(3000);
       loginPage.errorMessageController(errorLoginMessage);
    }

    @Test(description = "Search Giriş Kontrolü Sepete Atış")
    public void SearchingB() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();
            driver.findElement(By.id("searchData")).sendKeys("iphone 16 pro", Keys.ENTER);
             driver.findElement(By.className("plink")).click();
          driver.findElement(By.className("addBasketUnify")).click();
           driver.findElement(By.className("myBasket")).click();
        sleep(1000);
        driver.findElement(By.className("btnHolder")).click();
        sleep(3000);
    }
}
