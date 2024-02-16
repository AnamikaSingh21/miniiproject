package snapdeal;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Implementation {
	
	static WebDriver driver;
	
	//Driver setup
	public static void createDriver(int f) {
		driver = DriverSetup.getBrowser(f);
		
	}
	
	
	//Launching browser
	public void openBrowser() {
		driver.get("https://www.snapdeal.com/");
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.manage().window().maximize();
		
	}
	
	//Searching bluetooth devices on snapdeal
	public static void searchElement(String v) {
		 WebElement search= driver.findElement( By.xpath("//input[@id=\"inputValEnter\"]"));
	     search.click();
	     search.sendKeys(v);
	     driver.findElement( By.xpath("//span[text()=\"Search\"]")).click();
	}
	
	
	//Sorting Bluetooth devices by popularity
	public static void sortByPopularity() {
		
		driver.findElement( By.xpath("//div[@class=\"sort-selected\"]")).click();
		
		driver.findElement( By.xpath("//li[normalize-space()='Popularity']")).click();
	}
	
	
	//Setting price for displayed elements
	public static  void setPrice()throws InterruptedException {
		
		WebElement w= driver.findElement( By.xpath("(//input[@class=\"input-filter\"])[1]"));;
	     w.click();
	     w.clear();
	     w.sendKeys("700");
	     
	     WebElement p= driver.findElement( By.xpath("(//input[@class=\"input-filter\"])[2]"));;
	     p.click();
	     p.clear();
	     p.sendKeys("1400");
	     
	     driver.findElement( By.xpath("//div[@class=\"price-go-arrow btn btn-line btn-theme-secondary\"]")).click();
	  
	}
    
	
	//Closing browser
	public static void closeBrowser() {
		
		driver.quit();
		
	}

	//Printing first five elements in console
	public static void getFirstFiveElement() {
		
		 List<WebElement> list = driver.findElements(By.xpath("//p[contains(@class,'product-title')]"));
		 List<WebElement> price = driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));
		 
		 try {
			 
			 for(int i=0; i<5;i++) {
				 System.out.println( i+1 +" "+list.get(i).getText());
				 System.out.println("  "+"price"+"  "+price.get(i).getText());
			 }
	    	
	        
	     }catch(Exception e) {
	    	 
	     }
		 
	}
	
	
	//Taking screenshot of full screen
	public static void fullScreenShot1(String v) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("C:\\Users\\2303494\\eclipse-workspace\\minproject\\Screenshot\\"+v);
		FileUtils.copyFile(src, trg);
	}
	
	
	
	//Taking screenshot after displaying of products
	public static void screenShot() throws IOException {
		WebElement product = driver.findElement(By.xpath("//section[@data-dppos=\"2\"]"));
		File src= product.getScreenshotAs(OutputType.FILE);
		File trg= new File("C:\\Users\\2303494\\eclipse-workspace\\minproject\\Screenshot\\product.png");
		FileUtils.copyFile(src, trg);
	}
	
	
	//Creating FileIO constructor and passing value in its constructor
	public static void apachi() {
		 List<WebElement> list = driver.findElements(By.xpath("//p[contains(@class,'product-title')]"));
		 List<WebElement> price = driver.findElements(By.xpath("//span[contains(@class,'lfloat product-price')]"));
		 
		 FileIO f= new FileIO(driver, list, price);
	}
	
}
