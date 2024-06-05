package junit_assertion_cases;
import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class JUnitTestCase {
    static WebDriver driver;

    @BeforeClass
    public  static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void case01 (){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully  1
        WebElement logoElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[1]/div/a/img"));
        Assert.assertTrue(logoElement.isDisplayed());

        //4. Click on 'Signup / Login' button
        WebElement signLoginButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signLoginButton.click();

        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        Assert.assertTrue(loginText.isDisplayed());

        //6. Enter correct email address and password
        WebElement emailText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        emailText.sendKeys("enes@naber.com");
        WebElement passwordText = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        passwordText.sendKeys("1234");

        //7. Click 'login' button
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
        loginButton.click();

        //8. Verify that 'Logged in as username' is visible
        WebElement correctLog = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertTrue(correctLog.isDisplayed());

        //9. Click 'Logout' button
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        logoutButton.click();

        //10. Verify that user is navigated to login page
        String expectedUrl = "https://automationexercise.com/login";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        //11. Close driver
        driver.quit();
    }
        @Test
        public void case02() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement logoElement= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logoElement.isDisplayed());
        //4. Click on 'Products' button
        driver.findElement(By.xpath("//a[text()=' Products'] ")).click();
        //5. Verify user is navigated to ALL PRODUCTS page successfully
        String expectedUrl="https://automationexercise.com/products";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
        //6. Enter product name in search input and click search button
        WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search_product']"));
        aramaKutusu.sendKeys("tshirt");
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement aramaYapildiElementi= driver.findElement(By.xpath("//h2[text()='Searched Products']"));
        Assert.assertTrue(aramaYapildiElementi.isDisplayed());
        //8. close driver
        driver.close();

    }
}
