import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class KongaOrdersTest {


    private WebDriver driver;   //import web driver



    @BeforeTest
    public void start() throws InterruptedException {
        //locate the chrome driver
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");


        //chrome driver argument code
        ChromeOptions options = new ChromeOptions();  //add this option to cross allow origins in browser
        options.addArguments("--remote-allow-origins=*");


        //open chrome driver
        driver = new ChromeDriver(options);

        //pass in the url into the get method of the driver for the site under test
        driver.get("https://www.konga.com/");

        Thread.sleep(4000);

        //maximize chrome browser
        driver.manage().window().maximize();
        Thread.sleep(4000);
    }


    @Test(priority = 0)
    public void SignInButtonClicked() throws InterruptedException {
        //click on log in button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

        Thread.sleep(5000);

        //input valid email
        driver.findElement(By.id("username")).sendKeys("lanre.oshiga01@gmail.com");

        //input valid password
        driver.findElement(By.id("password")).sendKeys("Adebolami");

        //click on login button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);

    }

    @Test(priority = 1)
    public void ClickOnCategoriesComputersAndAccessories() throws InterruptedException {
        //click on the categories for computer and accessories using the XPath
        String computersAndAccessoriesXPath = "//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]";
        driver.findElement(By.xpath(computersAndAccessoriesXPath)).click();

        Thread.sleep(6000);

        //click on laptop botton
        String computerXPath = "//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span";
        driver.findElement(By.xpath(computerXPath)).click();

        Thread.sleep(3000);

        //click on apple macbook button
        String macbooXPath = "//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span";
        driver.findElement(By.xpath(macbooXPath)).click();

        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void AddMacBookToCart() throws InterruptedException {
        //This is used to add the selected Macbook to the cart
        String addToCartXPath = "//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button";
        driver.findElement(By.xpath(addToCartXPath)).click();

        Thread.sleep(5000);

    }

    @Test(priority = 3)
    public void ClickOnCart() throws InterruptedException {
        //Click on the cart button to go to cart. Find the Cart button by Xpath
        String cartButtonXPath = "//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]";
        driver.findElement(By.xpath( cartButtonXPath)).click();
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void CheckOutFromCart() throws InterruptedException {
        //This clicks the checkout button to go to address page
        String checkoutButtonXPath = "//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button";
        driver.findElement(By.xpath(checkoutButtonXPath)).click();
        Thread.sleep(6000);

        //select address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div[1]/form/button")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

        //click on pay now button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();

        //click on continue to payment button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();

        Thread.sleep(10000);

    }

    @Test(priority = 5)
    public void iframe() throws InterruptedException {
        
        //locate iframe
        WebElement iframe = driver.findElement(By.id("kpg-frame-component"));

        //switch to iframe
        driver.switchTo().frame(iframe);

        Thread.sleep(5000);


    }


    @Test(priority = 8) //This selects the card payment method
    public void CardButton() throws InterruptedException {
        //click on card button
        driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button")).click();

        Thread.sleep(10000);
        System.out.println("enter card details");

        //input invalid card number
        driver.findElement(By.id("card-number")).sendKeys("123456789");

        //input invalid date
        driver.findElement(By.id("expiry")).sendKeys("0523");

        //input invalid cvv
        driver.findElement(By.id("cvv")).sendKeys("123");

        //click on pay now button
        driver.findElement(By.id("validateCardForm")).click();

        Thread.sleep(5000);

    }


    @Test(priority = 9)
    public void ErrorMessage() throws InterruptedException {
        //print out error message
        String ErrorMessage = driver.findElement(By.id("card-number_unhappy")).getText();
        System.out.println(ErrorMessage);

        Thread.sleep(5000);

        //Close iframe
        driver.findElement(By.xpath("/html/body/section/section/section/div[2]/div[1]/aside")).click();

        Thread.sleep(5000);

    }


    @AfterTest
    public void QuitBrowser(){
        //after all the test completes, close the browser
        driver.quit();
    }




}
