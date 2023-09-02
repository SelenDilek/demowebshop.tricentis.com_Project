package SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Test
public class WebShop {
    WebDriver driver;


    @Test
    @Parameters({"browser"})
    public void SetUp(String browser){
        if(browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        }
        else if(browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1000,TimeUnit.SECONDS);
        driver.get("https://demowebshop.tricentis.com/login");


    }

    @Test(priority = 1)
    public void test2(){

        WebElement title = driver.findElement(By.xpath("/html/head/title"));
        String expected = driver.getTitle();
        String actual = "Demo Web Shop. Login";
        Assert.assertEquals(actual,expected);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);


    }

    @Test(priority = 2)
    public  void test3(){

        WebElement image = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img"));
        Assert.assertTrue(image.isDisplayed());
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

    @Test(priority =3)
    public void test4(){
        WebElement click = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
        click.click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        WebElement register = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[1]/h1"));
        Assert.assertTrue(register.isDisplayed());

    }
    @Test(priority =4)
    public void test(){
        WebElement gender = driver.findElement(By.id("gender-female"));
        gender.click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Assert.assertTrue(gender.isSelected());
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);

    }

    @Test(priority =5)
    @Parameters({"firstname" , "lastname" , "mail" , "password" , "confirm"})
    public void test5(String name , String lastname , String mail , String password ,String confirm){
        driver.findElement(By.id("FirstName")).sendKeys(name);
        driver.findElement(By.id("LastName")).sendKeys(lastname);
        driver.findElement(By.id("Email")).sendKeys(mail);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(confirm);

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        driver.findElement(By.id("register-button")).click();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);


    }
    @Test(priority = 6)
    public void test5(){

        driver.navigate().to("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getCurrentUrl() , "https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(600, TimeUnit.SECONDS);

        WebElement image= driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/div[1]/a/img"));
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        Assert.assertTrue(image.isDisplayed());
    }

    @Test(priority = 7)

    public void test7(){
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a"));
        actions.moveToElement(computer).build().perform();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        WebElement desktop = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a"));
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
        desktop.click();

        WebElement three = driver.findElement(By.xpath("//*[@id=\"products-orderby\"]/option[3]"));
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

        Assert.assertEquals(driver.getCurrentUrl() , "https://demowebshop.tricentis.com/desktops");


    }

    @Test (priority = 8)

    public void test8(){

        WebElement element = driver.findElement(By.xpath("//*[@id=\"products-pagesize\"]"));

       // int count = 0 ;
        Select sel2 = new Select(element);
       // List<WebElement> options = sel2.getOptions();
       // for(WebElement w : options){
       //     System.out.println("w = " + w + count++)  ;
      //  }
        //System.out.println("options.get(0) = " + options.get(0));
       // options.get(2).click();

        sel2.selectByIndex(2);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

        String actual= "https://demowebshop.tricentis.com/desktops?pagesize=12";
        String expected = driver.getCurrentUrl();

        Assert.assertEquals(actual,expected);

        WebElement options = driver.findElement(By.xpath("//*[@id=\"products-orderby\"]"));

       Select sel = new Select(options);
        sel.selectByIndex(0);

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

//INCELE
    }

    @Test (priority = 9)

    public  void test09(){

        WebElement list = driver.findElement(By.xpath("//*[@id=\"products-viewmode\"]"));
        Select sel3 = new Select(list);
        sel3.selectByIndex(1);
        driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);

        String actual1 = "https://demowebshop.tricentis.com/desktops?pagesize=12&viewmode=list";
        String expected1 = driver.getCurrentUrl();

        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        Assert.assertEquals(actual1,expected1);
    }

    @Test(priority = 10)
    public void test10(){

        WebElement cheapComputer = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/h2/a"));
       Assert.assertTrue(cheapComputer.isEnabled());
        cheapComputer.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);

        WebElement text = driver.findElement(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[1]/h1")); //expected
        String text1= "Build your own cheap computer"; //actual

        Assert.assertEquals(text1,text.getText());

    }

    @Test(priority = 11)
    public void test11(){
        WebElement slow = driver.findElement(By.xpath("//*[@id=\"product_attribute_72_5_18_52\"]"));
        slow.click();
        WebElement gb = driver.findElement(By.xpath("//*[@id=\"product_attribute_72_6_19_55\"]"));
        gb.click();
        WebElement officeSuite = driver.findElement(By.xpath("//*[@id=\"product_attribute_72_8_30_94\"]"));
        officeSuite.click();
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        WebElement qty = driver.findElement(By.xpath("//*[@id=\"addtocart_72_EnteredQuantity\"]"));
        qty.sendKeys("2");
        WebElement addToCard = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button-72\"]"));
        addToCard.click();

        //WebElement info = driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/p"));
        //Assert.assertTrue(info.isDisplayed());


    }


}
