package HomeDeliveryInvoices;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class RunInvoice_Printer extends Invoice_Printer{
	

	@BeforeClass
	public void Login() throws AWTException, InterruptedException, IOException {
		//lounchApp("http://resterpbeta.v.local/");
		lounchApp("http://resterpsandbox.v.local/");
	}

	@Test(priority =1 )
	public void HTML() throws Exception {
		 HomeDelivery();
	}
}