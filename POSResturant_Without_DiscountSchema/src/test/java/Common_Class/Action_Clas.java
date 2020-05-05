package Common_Class;


import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Clas{
	
protected static WebDriver driver; 
	
	public static void openbrowser(String browser){
		
		//	 String url = System.getProperty("user.dir") + "E:\\Testing\\browserdriver\\chromedriver.exe";
		  String url = System.setProperty("webdriver.chrome.driver", "C:\\Users\\gaurav.raghuwanshi\\Documents\\browser\\chromedriver.exe");
		//	 String url = System.setProperty("webdriver.chrome.driver", "E:\\Gaurav_Data\\browser\\driver\\chromedriver.exe");
				
		  ChromeOptions options = new ChromeOptions();
			options.addArguments("no-sandbox");
			options.addArguments("disable-extensions");
			driver = new ChromeDriver(options);
	
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public static String lounch(String URL){
		driver.get(URL);
		driver.navigate().to(URL);
		String actualURl = driver.getCurrentUrl();
		return actualURl;
	}

	
	public static By locatorValue(String locatortype , String locatorvalue){
		By by;
		switch(locatortype){
		case"id":
			by = By.id(locatorvalue);
			break;
		case"name":
			by = By.name(locatorvalue);
			break;
		case"linktext":
			by = By.linkText(locatorvalue);
			break;
		case"partialLinktext":
			by = By.partialLinkText(locatorvalue);
			break;
		case"xpath":
			by = By.xpath(locatorvalue);
			break;
		case"cssselector":
			by=By.cssSelector(locatorvalue);
			break;
		case"tagname":
			by = By.tagName(locatorvalue);
			break;
		case"classname":
			by = By.className(locatorvalue);
			break;
			
			default: by = null;
		
		}
		return by;
		
	}
	
	
	public static void inputdata(String locatorname , String value , String data){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		By locator = locatorValue(locatorname , value);
		
		wait.until(ExpectedConditions.elementToBeClickable((locator)));
		driver.findElement(locator).sendKeys(data);
		
	}
	public  void click_On_Button(String locatorType, String value) {
		   try {
		    By locator;
		    locator = locatorValue(locatorType, value);
		    WebElement element =  driver.findElement(locator);
		    element.click();
		   } catch (NoSuchElementException e) {
		    System.err.format("No Element Found to perform click" + e);
		   }
		  }
	
	public void product(String product){
		click_On_Button("id", product);
	}
	
	
	public void tab(int count){
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(count));
	}
	
	
	public void busyInd(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		 
		if(driver.findElement(By.id("divfeedbsy")).isDisplayed()){
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divfeedbsy")));
 
	}
		if(driver.findElement(By.id("vis_menuOverlay")).isDisplayed()){
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("vis_menuOverlay")));
		 
			}
		if(driver.findElement(By.xpath("//td[@class='vis-height-full']//div[@class='vis-apanel-busy']")).isDisplayed()){
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[@class='vis-height-full']//div[@class='vis-apanel-busy']")));
			
			}  
		 
	}	
}

