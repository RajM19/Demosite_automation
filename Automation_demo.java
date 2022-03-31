package Com.Automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Automation_demo{

		public static WebDriver driver;
		
	public static void main(String[] args) throws AWTException, InterruptedException, IOException {
		


		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muthu\\eclipse-workspace\\Selenium_project\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
	
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		
		WebElement user = driver.findElement(By.id("Email"));
		user.sendKeys("muthu190198@gmail.com");
		Thread.sleep(1000);

		WebElement pass = driver.findElement(By.id("Password"));
		pass.sendKeys("muthuraj");
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
		
		
		WebElement sign = driver.findElement(By.xpath("(//a[@href='/electronics'])[1]")); 
		Actions web = new Actions(driver);
		web.moveToElement(sign).perform();
		Thread.sleep(2000);

		Robot r = new Robot();
	    
	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);		
	    Thread.sleep(2000);
	    
        r.keyPress(KeyEvent.VK_DOWN);
	    r.keyPress(KeyEvent.VK_ENTER);
	    
		driver.findElement(By.xpath("(//a[@href='/cell-phones'])[1]")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 300)");
		
		WebElement select = driver.findElement(By.xpath("//img[@alt='Picture of Nokia Lumia 1020']"));
		select.click();
		
		driver.findElement(By.id("add-to-cart-button-20")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//a[@href='/cart']")).click();
		
		js.executeScript("window.scrollTo(0, 300)");

		driver.findElement(By.name("termsofservice")).click();
		
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
		
		WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
		Select s = new Select(country);
		s.selectByVisibleText("India");
		Thread.sleep(1000);

		WebElement city = driver.findElement(By.id("BillingNewAddress_City"));
		city.sendKeys("Chennai");
		Thread.sleep(1000);

		WebElement address1 = driver.findElement(By.id("BillingNewAddress_Address1"));
		address1.sendKeys("x street");
		Thread.sleep(1000);

		WebElement postal = driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
		postal.sendKeys("600068");
		Thread.sleep(1000);

		WebElement phone = driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
		phone.sendKeys("7530016613");
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement proceed = driver.findElement(By.xpath("//button[@onclick='Billing.save()']"));
		proceed.click();
		
	//	driver.findElement(By.xpath("//label[@for='shippingoption_0']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();

		WebElement shipmethod = driver.findElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
		shipmethod.click();
		Thread.sleep(1000);

		driver.findElement(By.id("paymentmethod_0")).click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement payment = driver.findElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));
		payment.click();
		driver.switchTo().defaultContent();
		Thread.sleep(1000);

		WebElement paymentinfo = driver.findElement(By.xpath("//button[@onclick='PaymentInfo.save()']"));
		paymentinfo.click();
		
		js.executeScript("window.scrollTo(0, 300)");		driver.switchTo().defaultContent();

		WebElement confirmorder = driver.findElement(By.xpath("//button[@onclick='ConfirmOrder.save()']"));
		confirmorder.click();
		Thread.sleep(3000);

		TakesScreenshot ts= (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File path = new File("C:\\Users\\muthu\\eclipse-workspace\\Selenium_project\\Screenshot\\orderconfirm.png");
	
		FileUtils.copyFile(screenshot, path);
		
		Thread.sleep(1000);

		WebElement logout = driver.findElement(By.xpath("//a[@class='ico-logout']"));
		logout.click();
		Thread.sleep(2000);
		
		driver.close();
		
		
	}
	
	
	
	
}
