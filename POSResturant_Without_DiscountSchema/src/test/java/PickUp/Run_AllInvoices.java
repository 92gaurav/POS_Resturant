package PickUp;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class Run_AllInvoices extends All_Invoices{
	
	WebDriver product;
	
	
	@BeforeClass
	public void Login() throws AWTException, InterruptedException, IOException {
		//lounchApp("http://resterpbeta.v.local/");
		lounchApp("http://resterpsandbox.v.local/");
		//lounchApp("http://138.201.234.236:8088/");
	}

	@Test(priority =1 )
	public void HTML() throws Exception {
	           PickUP();
	}
}