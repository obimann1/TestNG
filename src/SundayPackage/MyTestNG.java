package SundayPackage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyTestNG {
	String myUrl = "http://www.demo.guru99.com/V4/";
    String driverPath = "C:\\Users\\chromedriver.exe";
    public WebDriver driver;


  	
    @BeforeTest
    public void setUpbrowserFirst(){
        System.out.println("Lauching Google chrome Browser");
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.get(myUrl);
    }
	 
	
	
  
    @Test(priority=0)
	public void VerifyBankTitle() {
	    String expectedTitle = "Guru99 Bank Home Page";
	    String actualTitle = driver.getTitle();
	    System.out.println("This is the actual title of the page" + "\t" + actualTitle);
	    Assert.assertEquals(actualTitle,expectedTitle);
	    System.out.println("Test case1 passed regarding Bank Home Page");
    }
  
    @Test(priority=1)
    public void Login(){
    	driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr126856");
    	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("uvategE");
    	driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
    	String expectedTitle2 = "Guru99 Bank Manager HomePage";
    	String actualTitle2 = driver.getTitle();
    	Assert.assertEquals(actualTitle2,expectedTitle2);
    	System.out.println("Test case2 passed regarding Guru99 Bank Manager HomePage passed");
    }
	
	@Test(priority=2)
	public void AddNewCustomer(){
	  driver.findElement(By.xpath("//a[contains(text(),\"New Customer\")]")).click();
	  String expectedUrl = "http://www.demo.guru99.com/V4/manager/addcustomerpage.php";
	  String actualUrl = driver.getCurrentUrl();
	  Assert.assertEquals(actualUrl, expectedUrl);
	  System.out.println("Test Case 3 passed regarding retriving current URL of the Add New Customer page with the driver getCurrentUrl method");
	}
	

	@Test(priority=3)
	public void Quit(){
		driver.navigate().back();
		driver.findElement(By.xpath("//a[contains(text(),\"Log out\")]")).click();
		String actualLogOutUrl = driver.getCurrentUrl();
		String expectedLogOutUrl = "http://http://www.demo.guru99.com/V4/manager/Logout.php";
		Assert.assertEquals(actualLogOutUrl,expectedLogOutUrl);
		System.out.println("Test Case 4 passed. User was able to successfully LogOut");
	}
	
	
}

