package QSR;

import java.awt.AWTException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class RunCheck extends Check{
	
	WebDriver product;
	
	
	@BeforeClass
	
	public void Login() throws AWTException, InterruptedException, IOException, SQLException, ClassNotFoundException {
		
		//lounchApp("http://resterpbeta.v.local/");
		lounchApp("http://resterpsandbox.v.local/");


	}

	@Test(priority =1)
	public void HTM() throws Exception {
		QSR();
	}
}