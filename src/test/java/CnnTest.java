/**
 * Created with IntelliJ IDEA.
 * User: Mohammed Z. Azam
 * Date: 8/17/13
 * Time: 7:57 PM
 * To change this template use File | Settings | File Templates.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CnnTest {
    WebDriver driver = null;

    @Test()
    public void f() {
        clickByCss("#nav-us");
        clickOnMenu(".cnn_sectt1cntnt li");
    }

   @Test
    public void f1() {
        clickByCss("#nav-world");
        clickOnMenu(".cnn_sectt1cntnt li");
    }

    public void clickByCss(String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void clickOnMenu(String locator) {
        List<WebElement> menuList = driver.findElements(By.cssSelector(locator));
        for (int i=1; i<menuList.size(); i++) {
            System.out.println(menuList.get(i).getText());
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://www.cnn.com");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

}

