package AddNewCustomer;

import java.awt.AWTException;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Run_Common extends Common{

	WebDriver product;
	
	@BeforeClass
	public void Login() throws AWTException, InterruptedException, IOException {
		lounchApp("http://resterpbeta.v.local/");

		//lounchApp("http://resterpsandbox.v.local/");          
	}
	
	
	@Test(priority =1 )
	public void HTML() throws Exception {
		common();
	}

 }