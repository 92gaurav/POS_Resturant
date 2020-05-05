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



public class Run_AllInvoices extends Invoices{
	
	WebDriver product;
	
	
	@BeforeClass
	
	public void Login() throws AWTException, InterruptedException, IOException, SQLException, ClassNotFoundException {
		
		//lounchApp("http://resterpbeta.v.local/");
       	lounchApp("http://resterpsandbox.v.local/");
		//lounchApp("http://138.201.234.236:8088/");
	}

	@Test(priority =1)
	public void HTM() throws Exception {
		QSR();
	}
}