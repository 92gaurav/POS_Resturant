package HomeDeliveryInvoices;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class All_Invoices extends Common_Class.Action_Clas{

	Common_Class.Xls_Reader reader = 
		//	new Common_Class.Xls_Reader("D:\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\Restaurant_Project.xlsx");
	new Common_Class.Xls_Reader("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Excel\\Restaurant_Project.xlsx");

	//	Xls_Reader reader = new Xls_Reader("D:\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\BetaSheet.xlsx");
	Random rand = new Random();
	int rand_int1 = rand.nextInt(100);
	String OrderNumber = null;
	String Orderno = null;

	public void HomeDelivery() throws Exception {
		dyNamic("HomeDelivery");
	}
	
	String nk = null;
	String rk = null;
	String kk = null;
	float f1;
	float f3;
	float f2;
	float f4;
	float f6;
	String cash;
	String card;
	String quickpay;
	String oncredit;
	String customername;
	String Cash;
	String dicountpercentage;
	String DiscountProduct;
	String discountPerTotal;
	String orderNumber;
	String UserName;
	String POSTerminal;
	String Void;
	String TotalVoid;
	String MultiCash;
	String CurrencyType;
	String multiCard;
	String ReturnWithoutInvoice; 
	String DriverName;
	String duebillpayment;
	String driverin;
	String modifier;
	String modifierproduct;
	String onCredit;
	String CreditAmount;
	String discountPerTotalamount;
	String discountamount;
	String discountPerTotalpercentage;
	 String OnCreditKeyPad;
	 String CreditKeyPadDenominationValue;
	 String CreditSettelment;
	 String OnCreditDenominaion;
	 String runOn;
	 String Prefix;
	 String OccupiedTermninal;
	 
	public void dyNamic(String SheetName) throws Exception {

		int rowCount = reader.getRowCount(SheetName);
		int rowCount2 = reader.getRowCount("HomeDelivery_Data");
		for (int i = 2; i <= rowCount; i++) {
			runOn = reader.getCellData(SheetName, "RUN", i);
			String ref1 = reader.getCellData(SheetName, "Refrence Id", i);
			String param1 = reader.getCellData(SheetName, "Expected Total Price", i);
			if (runOn.equals("ON")) {
				for (int j = 2; j <= rowCount2; j++) {

					String ref = reader.getCellData("HomeDelivery_Data", "Refrence Id", j);
					if (ref1.equalsIgnoreCase(ref)) {
						UserName = reader.getCellData("HomeDelivery_Data", "UserName", j);
						String HTMLPassword = reader.getCellData("HomeDelivery_Data", "HtmlPassword", j);
						POSTerminal = reader.getCellData("HomeDelivery_Data", "Pos Terminal", j);
						String POSTerminalUser = reader.getCellData("HomeDelivery_Data", "Pos Temrinal User", j);
						String course = reader.getCellData("HomeDelivery_Data", "Course", j);
						String cate = reader.getCellData("HomeDelivery_Data", "Category", j);
						String paro = reader.getCellData("HomeDelivery_Data", "PRODUCT", j);
						Cash = reader.getCellData("HomeDelivery_Data", "Cash", j);
						card = reader.getCellData("HomeDelivery_Data", "Card", j);
						multiCard = reader.getCellData("HomeDelivery_Data", "CardMultiCurrency", j);
						oncredit = reader.getCellData("HomeDelivery_Data", "OnCredit", j);
						customername = reader.getCellData("HomeDelivery_Data", "CustomerName", j);
						dicountpercentage = reader.getCellData("HomeDelivery_Data", "Discount Percentage", j);
						discountamount = reader.getCellData("HomeDelivery_Data", "Discount Amount", j);
						discountPerTotalamount = reader.getCellData("HomeDelivery_Data", "Total Discount Amount", j);
						discountPerTotalpercentage = reader.getCellData("HomeDelivery_Data", "Total Discount Percentage", j);
						DiscountProduct = reader.getCellData("HomeDelivery_Data", "Discounted Product", j);
						discountPerTotal = reader.getCellData("HomeDelivery_Data", "Discount Total", j);
						Void = reader.getCellData("HomeDelivery_Data", "Void", j);
						TotalVoid = reader.getCellData("HomeDelivery_Data", "Full OrderVoid", j);
						MultiCash = reader.getCellData("HomeDelivery_Data", "CashMultiDenomination", j);
						CurrencyType = reader.getCellData("HomeDelivery_Data", "CashMulti Curency", j);
						driverin = reader.getCellData("HomeDelivery_Data", "Driver In", j);
						System.out.println("Value of Driver In : "+driverin);
						duebillpayment = reader.getCellData("HomeDelivery_Data", "Due Bill Payment", j);
						modifier = reader.getCellData("HomeDelivery_Data", "Modifier", j);
						modifierproduct = reader.getCellData("HomeDelivery_Data", "Modifier Product", j);
						onCredit = reader.getCellData("HomeDelivery_Data", "On Credit", j);
						CreditAmount = reader.getCellData("HomeDelivery_Data", "Credit Amount", j);
						 ReturnWithoutInvoice =  reader.getCellData("HomeDelivery_Data", "ReturnWithoutInvoice", j);
						 CreditKeyPadDenominationValue = reader.getCellData("HomeDelivery_Data", "OnCreditVirtual KeypadAmount", j);
						 OnCreditKeyPad = reader.getCellData("HomeDelivery_Data", "OnCreditVirtual Keypad", j);
						 CreditSettelment =  reader.getCellData("HomeDelivery_Data", "Credit Card Settlement", j);
						 OccupiedTermninal= reader.getCellData("HomeDelivery_Data", "POS Terminal ON HTML", j);
						 Prefix=  reader.getCellData("HomeDelivery_Data", "OrderPrefix", j);
						 System.out.println("Value in Order Prefixs : "+Prefix);
						 String Password = reader.getCellData("HomeDelivery_Data", "Password", j);
						WebDriverWait wait = new WebDriverWait(driver, 30);
						// lOGIN Page
						login_Html(UserName, HTMLPassword,OccupiedTermninal);
					
						// LoginPagePOS
						loginPage(POSTerminal, Password, POSTerminalUser);
						// SelectArea
						Area();
						// SelectCustomer
						selectcustomer(customername);
						// Save OrderNumber
						OrderNumberInfo(Prefix);
						// Add Product
						//return
						 ReturnWithoutInvoices();
						 
						String[] arrSplit = paro.split(",");
						productSelection(course, cate, arrSplit);
						
						
						AddModifier(modifierproduct);
						// Discount Percantage
						String[] arrSplit3 = dicountpercentage.split(",");
						Dicountper(DiscountProduct, arrSplit3);
						// Discount Amount
						String[] arrSplit4 = discountamount.split(",");
						Discountamount(DiscountProduct, arrSplit4);
						
						// Total Amoint
						
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@id='POS_Tot']//input")));
						nk = driver.findElement(By.xpath("//h3[@id='POS_Tot']//input")).getAttribute("value");
						f1 = Float.parseFloat(nk);
						// Savebill
						if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
						click_On_Button("xpath", "//a[text()='Save Bill']");
						// hold Area
						HoldOrder(1);
						}
						// logout
						logout();
						// kitchen
						kitchen();
						// delivery
						delivery();
						// roundtrip
						RoundTrip();
						// durbillpayment
						DueBillPayment();
						// DriveIn
						DriverIN();
					}
				}

				// total discount percentage
				String[] arrSplit5 = discountPerTotalpercentage.split(",");
				DiscountPerTotal(arrSplit5);
				// total discount amoount
				String[] arrSplit6 = discountPerTotalamount.split(",");
				DiscountAmountTotal(arrSplit6);
				
				
				// cash
				String[] arrSpli21 = CreditAmount.split(",");
				OnCredit(arrSpli21);
				String[] arrSplit = Cash.split(",");
				String[] arrSplit1 = MultiCash.split(",");
				cash(arrSplit);
				// card
				multiCash(arrSplit1);

				cardPay(card);
				CardMulti(multiCard);

				if(ReturnWithoutInvoice.equalsIgnoreCase("YES")){
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_CLLogout")));
				Thread.sleep(5000);
				click_On_Button("id", "POS_CLLogout");
				}
				orderlog();

				
				f2 = Float.parseFloat(param1);
				//
				if (f1 == f2) {
					reader.setCellData(SheetName, "Status", i, "Passed");
					reader.setCellData(SheetName, "Actual Amount", i, nk);
					reader.setCellData(SheetName, "OrderNumber", i, orderNumber);

				} else {
					reader.setCellData(SheetName, "Status", i, "Failed");

					reader.setCellData(SheetName, "Actual Amount", i, nk);
					reader.setCellData(SheetName, "OrderNumber", i, orderNumber);
				}

			}

		}
		
		SyncData();
		
		InvoiceCustomer();

	}

	public void lounchApp(String link) throws IOException {

		openbrowser("Chrome");
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		System.out.println("Running All Invoice");
	}

	// Login to HTML
	public void login_Html(String uname, String pwd,String OccupiedTerminal) throws AWTException, InterruptedException {
		if (UserName.equals("NA") == false) {
			inputdata("id", "loginName", uname);
			inputdata("id", "txtPwd", pwd);
			click_On_Button("id", "btnLogin1");
			click_On_Button("id", "vis_appMenu");
			inputdata("id", "vis_menuSearch", "POS Terminal");
			click_On_Button("id", "ui-id-2");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			inputdata("xpath", "//input[@class='vis-apanel-search ui-autocomplete-input']", OccupiedTerminal);
			click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//img[@src='/Areas/VIS/Images/base/Multi16.png']")));
			Thread.sleep(2000);
			click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Multi16.png']");
			boolean kam = driver.findElement(By.xpath("//input[@name='VAPOS_IsOccupied']")).isSelected();
			if (kam) {
				driver.findElement(By.xpath("//input[@name='VAPOS_IsOccupied']")).click();
				driver.findElement(By.xpath("//img[@src='/Areas/VIS/Images/base/Save24.png']")).click();
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_T);
				Thread.sleep(2000);
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1)); // switches to new tab
				//driver.get("http://restposbeta.v.local/");
				driver.get("http://restpossandbox.v.local/");
			//	driver.get("http://138.201.234.236:8099/");

			} else {

				Thread.sleep(1000);
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_CONTROL);
				r.keyPress(KeyEvent.VK_T);
				r.keyRelease(KeyEvent.VK_CONTROL);
				r.keyRelease(KeyEvent.VK_T);
				Thread.sleep(2000);
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				System.out.println(tabs);
				driver.switchTo().window(tabs.get(1)); // switches to new tab
				//driver.get("http://restposbeta.v.local/");
				driver.get("http://restpossandbox.v.local/");
				//driver.get("http://138.201.234.236:8099/");
			}

		}
	}

	// Login to POS
	public void loginPage(String terminal, String pwd,String pOSTerminalUser) throws AWTException, InterruptedException {
		if (POSTerminal.equals("NA") == false) {
			
			inputdata("id", "POS_cmbTerm", terminal);
			click_On_Button("xpath", "//select[@id='POS_cmbTermUser']//option[@value=" + pOSTerminalUser + "]");
			driver.findElement(By.id("POS_txtPwd")).clear();
			inputdata("id", "POS_txtPwd", pwd);
			click_On_Button("id", "POS_btnLogin");
			Thread.sleep(1000);
		//	click_On_Button("id", "POS_btnCloseInfoAlert");
			/*WebDriverWait wait = new WebDriverWait(driver, 60);
			//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='posva019-setting-url']")));
			Thread.sleep(3000);
			System.out.println("Is it working");
			click_On_Button("xpath", "//*[@id=\"POSVA019_Setting\"]/div");
			System.out.println("yes working");
			Thread.sleep(3000);
			//driver.findElement(By.xpath("//input[@class='posva019-setting-url']")).clear();
			driver.findElement(By.xpath("")).clear();

			Thread.sleep(3000);
			inputdata("xpath", "//input[@class='posva019-setting-url']", "http://192.168.0.159:60600/api/");
			wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='glyphicon glyphicon-remove']")));
			click_On_Button("xpath", "//span[@class='glyphicon glyphicon-remove']");
			Thread.sleep(3000);
			click_On_Button("id", "va019_btnDRPwdOK");*/
		}
	}

	public void Area() {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_H']")));
		click_On_Button("xpath", "//div[@data-mode='POSVA019_H']");
		
	}

	public void selectcustomer(String CustomerName) throws InterruptedException {

		inputdata("id", "POS_txtCustSearch", CustomerName);
		click_On_Button("id", "POS_BtnCustSearch");
		Thread.sleep(2000);
		click_On_Button("xpath", "//div[@class='third-p']");
	}

	public void OrderNumberInfo(String Prefix) throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_OrdNo")));
		String we3 = driver.findElement(By.id("POS_OrdNo")).getText();
		String OrderPrefix = Prefix;
		System.out.println("prefix for order : "+OrderPrefix);
		orderNumber = OrderPrefix + we3;

	}

	public void productSelection(String Course, String Category, String a[]) throws InterruptedException {
		// Selecting Courses...
		Thread.sleep(1000);
		click_On_Button("xpath", "//ul[@id='POSVA019_Courses']//li[contains(text(),'" + Course + "') ]");
		// Selecting Category....
		Thread.sleep(1000);
		click_On_Button("xpath", "//ul[@id='POSVA019_ULRightPanel']//li[contains(text(),'" + Category + "') ]");
		// Clicking on Product......
		for (int i = 0; i < a.length; i++) {
			Thread.sleep(1000);
			click_On_Button("xpath",
					" //div[@class='pos-fontRightProductBottom'][contains(text(),'" + a[i].toString() + "')]");
		}

	}

	public void HoldOrder(int colnum) throws InterruptedException {
		Thread.sleep(2000);

		// to see wheather order avaiable
		click_On_Button("id", "POS_HoldOrder");
		String Holdorder = driver.findElement(By.xpath("//td[@style='text-align: left; padding-left: 10px;']"))
				.getText();
		if (orderNumber.equalsIgnoreCase(Holdorder)) {
			reader.setCellData("HomeDelivery", "HoldOrder", colnum, "pass");
		} else {
			reader.setCellData("BaseHomeDelivery", "HoldOrder", colnum, "Fail");
		}
		click_On_Button("id", "POS_btnCancelHoldOrder");

		// void linr wise
		if (Void.equals("NA") == false) {

			click_On_Button("id", "POS_HoldOrder");
			driver.findElements(By.xpath("//img[@src='/Areas/POS/Content/Images/plus.png']")).get(0).click();

			click_On_Button("xpath", Void);
			click_On_Button("id", "POS_BtnProdVoid");
			click_On_Button("id", "POS_CLAddVReason");
			click_On_Button("xpath", "//a[text()='Save Bill']");
		}

		// void full order
		if (TotalVoid.equals("NA") == false) {
			click_On_Button("id", "POS_HoldOrder");
			driver.findElements(By.xpath("//img[@src='/Areas/POS/Content/Images/plus.png']")).get(0).click();
			click_On_Button("id", "POS_Reset");
			click_On_Button("id", "POS_btnAddVReason");
			
		}

	}

	public void logout() throws InterruptedException {
		if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_CLLogout")));
		Thread.sleep(5000);
		click_On_Button("id", "POS_CLLogout");
		}
	}
	
	

	public void kitchen() throws InterruptedException, FindFailed {
		 Screen s = new Screen();
//		  Pattern p = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Start.PNG");
//		  Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");
//		  Pattern p2 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Stop.PNG");
//		  Pattern p3 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\NonWaste.PNG");
		  
		  Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Start.PNG");
		  Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Close.PNG");
		  Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Stop.PNG");
		  Pattern p3 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\NonWaste.PNG");
		// kitchen
		click_On_Button("id", "POSVA019_KitchenLI");
		click_On_Button("xpath", "//a[@class='posva019-d-validate']");
	
		while (s.exists(p) != null) {
			 s.click(p);
			 }
		
		while (s.exists(p2) != null) {
			 s.click(p2);
			 }
		
		while (s.exists(p3) != null) {
			 s.click(p3);
			 }
		 s.click(p1);
		 Thread.sleep(100);
		
	}

	
	public void delivery() throws InterruptedException, Exception {
		if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
		 //ImagePath.setBundlePath("src/test/java/SikuliImages");
		 Screen s = new Screen();
//		  Pattern p = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\DeliveryDone.PNG");
//		  Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");

		 Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\DeliveryDone.PNG");
		  Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Close.PNG");
		 click_On_Button("id", "POSVA019_DeliveryLI");
		 click_On_Button("xpath", "//a[@class='posva019-d-validate']");
		 
		 while ( s.exists(p) != null){
		      s.click(p);
		    Thread.sleep(200);
		   }
		 s.click(p1);
		} 
		}
	
	
	public void RoundTrip() throws InterruptedException, FindFailed {
		
		if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
		click_On_Button("id", "POSVA019_NewRoundTrip");
		Thread.sleep(2000);
		
		DriverName = driver.findElement(By.xpath("//li[@data-item='1000050']")).getAttribute("data-item");
		System.out.println("Value of Driver Name : "+DriverName);
		
		String DriverName1 = driver.findElement(By.xpath("//li[@data-item='1000051']")).getAttribute("data-item");
		System.out.println("Value of Driver Name1 : "+DriverName1);
		
		/*String DriverName2 = driver.findElement(By.xpath("//li[@data-item='1000054']")).getAttribute("data-item");
		System.out.println("Value of Driver Name2 : "+DriverName2);*/
		
		
		//DriverName = driver.findElement(By.xpath("//li[@data-item='1000003']")).getAttribute("driver-status");
		if (DriverName.equalsIgnoreCase("1000050")) {
			click_On_Button("xpath", "//li[@data-item='1000050']");
			Thread.sleep(5000);
			click_On_Button("id", "POSVA019_SelectAll");
			//assign order
			click_On_Button("id", "POS_CLOrderAssign");
			System.out.println("First one run");
			//print
			 Screen s = new Screen();
//			  Pattern p = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\PrintButtonRT.PNG");
//			  Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
	     	  
			 Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\PrintButtonRT.PNG");
			  Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
			 s.click(p);	 
	     	  Thread.sleep(4000);
			 while ( s.exists(p1) != null){
			      s.click(p1);
			    Thread.sleep(1000);
			   }
			 
		//direct logout
			click_On_Button("id", "POS_CLDriverLogout");
			Thread.sleep(2000);
			click_On_Button("id", "POSVA019_RoundTripClose");
		} 
		
		else if (DriverName1.equalsIgnoreCase("1000051")) {
			click_On_Button("xpath", "//li[@data-item='1000051']");
			
			//click_On_Button("xpath", "//li[@data-item='1000004']");
			Thread.sleep(2000);
			click_On_Button("id", "POSVA019_SelectAll");
			click_On_Button("id", "POS_CLDriverLogout");
			Thread.sleep(2000);
			click_On_Button("id", "POSVA019_RoundTripClose");
			System.out.println("Second one run");

		}
		
		else {
			click_On_Button("xpath", "//li[@data-item='1000054']");
			
			//click_On_Button("xpath", "//li[@data-item='1000004']");
			Thread.sleep(2000);
			click_On_Button("id", "POSVA019_SelectAll");
			click_On_Button("id", "POS_CLDriverLogout");
			Thread.sleep(2000);
			click_On_Button("id", "POSVA019_RoundTripClose");
			System.out.println("Third one run");

		}
		
		}
	}

	public void DueBillPayment() throws InterruptedException {
		if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
		if (duebillpayment.equals("Y")){
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("POSVA019_DueBillPay")));
			click_On_Button("id", "POSVA019_DueBillPay");
			String Count = driver.findElement(By.id("POSVA019_HomeDeliveryCount")).getText();
			click_On_Button("id", "POSVA019_CLHomeDelivery");
			Thread.sleep(2000);
			inputdata("id", "POSVA019_DueBillOrderSearch", orderNumber);
			click_On_Button("id", "POSVA019_DueBillSearchOrder");
			Thread.sleep(2000);

			click_On_Button("xpath", "//input[@name='chkDriveinOrderno']");

			if (Cash.equals("NA") && (card.equals("NA") && (Void.equals("NA") && (onCredit.equals("NA"))))) {

				Thread.sleep(3000);
				driver.findElement(By.xpath("//h3[@style='width:5%;']//img[@src='/Areas/POS/Content/Images/close-3.png']")).click();
				click_On_Button("id", "POS_btnReasonOK");
				Thread.sleep(2000);
				click_On_Button("id", "POSVA019_DueBillPaymentClose");
			} 
			else {
				click_On_Button("id", "POSVA019_btnDueBillPayOK");
			}
		}
		}
	}

	public void DriverIN() throws InterruptedException {
		if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
		if (!driverin.equals("NA") && (driverin.equals("Y"))) {
			{
				if (DriverName.equalsIgnoreCase("I")) {
					click_On_Button("id", "POSVA019_DriverIn");
					inputdata("id", "POSVA019_DriveInOrderSearch", orderNumber);
					click_On_Button("id", "POSVA019_DriveInSearchOrder");
					Thread.sleep(2000);
					click_On_Button("xpath", "//input[@name='chkDriveinOrderno']");
					click_On_Button("id", "POSVA019_CLDriverInOK");

				}

				else {
					click_On_Button("id", "POSVA019_LogoutMod");
					click_On_Button("xpath",
							"//div[@class='pos-PopupBtn pull-right pos-confirm-alert']//a[@class='btn pos-btn pos-AddProBtn']");
					Thread.sleep(2000);
					click_On_Button("xpath", "//select[@id='POS_cmbTermUser']//option[@value='1005418']");
					driver.findElement(By.id("POS_txtPwd")).clear();
					inputdata("id", "POS_txtPwd", "123");
					click_On_Button("id", "POS_btnLogin");
					click_On_Button("id", "POSVA019_DriverIn");
					inputdata("id", "POSVA019_DriveInOrderSearch", orderNumber);
					click_On_Button("id", "POSVA019_DriveInSearchOrder");
					Thread.sleep(2000);
					click_On_Button("xpath", "//input[@name='chkDriveinOrderno']");
					click_On_Button("id", "POSVA019_CLDriverInOK");
					// click_On_Button("id", "POSVA019_btnClsDriverIn");
					/*
					 * click_On_Button("id", "POSVA019_LogoutMod");
					 * click_On_Button(
					 * "xpath","//div[@class='pos-PopupBtn pull-right pos-confirm-alert']//a[@class='btn pos-btn pos-AddProBtn']"
					 * ); Thread.sleep(2000); click_On_Button("xpath",
					 * "//select[@id='POS_cmbTermUser']//option[@value='1005417']"
					 * ); driver.findElement(By.id("POS_txtPwd")).clear();
					 * inputdata("id", "POS_txtPwd", "123");
					 * click_On_Button("id", "POS_btnLogin");
					 */
				}

			}
		}
		}
	}

	public void orderlog() throws InterruptedException {
		if(ReturnWithoutInvoice.equalsIgnoreCase("NO")){
		
		Thread.sleep(3000);
		click_On_Button("id", "POSVA019_OrdersLog");
		Thread.sleep(2000);
		inputdata("id", "POS_OrderLogtxtInvoice", orderNumber);
		Thread.sleep(1000);
		click_On_Button("id", "POS_OrdLogSearchOrder");
		Thread.sleep(1000);
		click_On_Button("id", "POS_btnCloseOrdersLog");
		}
	}
	 Screen s = new Screen();
//		Pattern p = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\Done.PNG");
//		 Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\Cancel.PNG");
//		 Pattern p2 = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
	 
	 Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Done.PNG");
	 Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\Sikulli_Images\\Cancel.PNG");
	 Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\Sikulli_Images\\AuthDone.PNG");
	 public void cash(String a[]) throws InterruptedException, FindFailed {
		if (Cash.equals("NA") == false) {
			if(ReturnWithoutInvoice.equalsIgnoreCase("YES")){
			click_On_Button("id", "POS_Pay");
			}
			Thread.sleep(2000);
           click_On_Button("id", "POS_Cash");
			for (int i = 0; i < a.length; i++) {
				Thread.sleep(2000);
				click_On_Button("id", "VAPOS_POSDenominatorValue" + a[i].toString() + "");
			}
			
			
			 s.click(p);
				//click_On_Button("id", "POS_PayDoneCash");

				String RemaningBalance = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
				if (RemaningBalance.equalsIgnoreCase("Please Pay")) {
					click_On_Button("id", "POS_btnCloseInfoAlert");

				}
				
				 Thread.sleep(5000);
				 while ( s.exists(p1) != null){
				      s.click(p1);
				    Thread.sleep(2000);
				   }
				 
				 
				 
				 String ReturnMultiCurrency = driver.findElement(By.id("POS_CLPopReturnAmountMcur")).getText();
				 System.out.println("ReturnMultiCurrency"+ReturnMultiCurrency);
				 if(ReturnMultiCurrency.equalsIgnoreCase("Return Amount")){
					             s.click(p2);
				 }
				 
				 
				 
				 Thread.sleep(5000);
				 while ( s.exists(p1) != null){
				      s.click(p1);
				    Thread.sleep(2000);
				   }

			 
			 
			 
			String ReturnPopup = driver.findElement(By.id("POS_CLPopReturnAmount")).getText();

			if (ReturnPopup.equalsIgnoreCase("Return Amount")) {
				click_On_Button("id", "btnCloseReturnAmt");
			}

			
			Thread.sleep(5000);
			String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
			{
				if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
					click_On_Button("id", "POSVA019_DueBillPaymentClose");
				}
			}

			String driverin = driver.findElement(By.id("POSVA019_CLDriverIn")).getText();
			{
				if (driverin.equalsIgnoreCase("Driver In")) {
					Thread.sleep(2000);
					click_On_Button("id", "POSVA019_btnClsDriverIn");
				}

			}
		}

	}

	public void multiCash(String b[]) throws InterruptedException {

		if (MultiCash.equals("NA") == false) {
			if(ReturnWithoutInvoice.equalsIgnoreCase("YES")){
				click_On_Button("id", "POS_Pay");
			}
			Thread.sleep(2000);
			click_On_Button("id", "POS_ChangeCurrencyP");
			Thread.sleep(2000);
			click_On_Button("xpath", CurrencyType);
			Thread.sleep(2000);
			for (int i = 0; i < b.length; i++) {
				Thread.sleep(2000);
				click_On_Button("id", "VAPOS_POSDenominatorValue" + b[i].toString() + "");
			}
			click_On_Button("id", "POS_PayDoneCash");
		}

		String RemaningBalance = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
		if (RemaningBalance.equalsIgnoreCase("Please Pay")) {
			click_On_Button("id", "POS_btnCloseInfoAlert");
		}

		String ReturnPopup = driver.findElement(By.id("POS_CLPopReturnAmount")).getText();

		if (ReturnPopup.equalsIgnoreCase("Return Amount")) {
			click_On_Button("id", "btnCloseReturnAmt");
		}

		Thread.sleep(2000);
		String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
		{
			Thread.sleep(2000);
			if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
				click_On_Button("id", "POSVA019_DueBillPaymentClose");
			}
		}
		String driverin = driver.findElement(By.id("POSVA019_CLDriverIn")).getText();
		{
			if (driverin.equalsIgnoreCase("Driver In")) {
				Thread.sleep(2000);
				click_On_Button("id", "POSVA019_btnClsDriverIn");
			}

		}
	}
	String ECR =null;
	public void cardPay(String cardNo) throws InterruptedException {
		if (card.equals("NA") == false) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			click_On_Button("id", "POS_Pay");
			click_On_Button("id", "POS_Credit");
			Thread.sleep(1000);
			click_On_Button("xpath", "//li[contains(text(),'" + cardNo + "')]");
		
			click_On_Button("id", "POS_Credit");
			
			Thread.sleep(1000);
			click_On_Button("xpath", "//li[contains(text(),'" + cardNo + "')]");
			ECR= driver.findElement(By.id("POS_ECRCredit")).getText();
			if(ECR.equalsIgnoreCase("ECR")){
				click_On_Button("id", "POS_ECRCredit");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_btnCloseInfoAlert")));
				Thread.sleep(5000);
				click_On_Button("id", "POS_btnCloseInfoAlert");
			
			}
			
			click_On_Button("id", "POS_OkCredit");
			Thread.sleep(2000);
			String Popup = driver.findElement(By.id("POS_CLLblTranscationNo")).getText();
			System.out.println("Pp" + Popup);
			if (Popup.equalsIgnoreCase("Auth. Code")) {
				inputdata("id", "POS_txtTranscationNo", "56575");
				click_On_Button("id", "POS_btnOKTranscationNo");
			}
			Thread.sleep(3000);
			String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
			{
				if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
					Thread.sleep(2000);
					click_On_Button("id", "POSVA019_DueBillPaymentClose");
				}
			}
			String driverin = driver.findElement(By.id("POSVA019_CLDriverIn")).getText();
			{
				if (driverin.equalsIgnoreCase("Driver In")) {
					Thread.sleep(2000);
					click_On_Button("id", "POSVA019_btnClsDriverIn");
				}

			}
		}
	}

	public void CardMulti(String cardNo1) throws InterruptedException {
		if (multiCard.equals("NA") == false) {
			if(ReturnWithoutInvoice.equalsIgnoreCase("YES")){
			click_On_Button("id", "POS_Pay");
			}
			
			Thread.sleep(2000);
			click_On_Button("id", "POS_Credit");
			Thread.sleep(3000);
			click_On_Button("id", "POS_ChangeCurrencyP");
			Thread.sleep(2000);
			click_On_Button("xpath", CurrencyType);
			Thread.sleep(2000);
			click_On_Button("xpath", "//li[contains(text(),'" + cardNo1 + "')]");
			click_On_Button("id", "POS_OkCredit");
			Thread.sleep(2000);
			String Popup = driver.findElement(By.id("POS_CLLblTranscationNo")).getText();
			if (Popup.equalsIgnoreCase("Auth. Code")) {
				inputdata("id", "POS_txtTranscationNo", "56575");
				click_On_Button("id", "POS_btnOKTranscationNo");
			}
			Thread.sleep(2000);
			String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
			{
				if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
					click_On_Button("id", "POSVA019_DueBillPaymentClose");
				}
			}
			String driverin = driver.findElement(By.id("POSVA019_CLDriverIn")).getText();
			{
				if (driverin.equalsIgnoreCase("Driver In")) {
					Thread.sleep(2000);
					click_On_Button("id", "POSVA019_btnClsDriverIn");
				}

			}
		}
	}

	public void Dicountper(String Product, String a[]) throws InterruptedException {
		if (dicountpercentage.equals("NA") == false) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]")));

			click_On_Button("xpath", "//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]");
			click_On_Button("id", "POS_BtnDiscLine");
			click_On_Button("id", "POS_DiscPercntCal");
			for (int i = 0; i < a.length; i++) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_calc_" + a[i].toString() + "");
			}
			click_On_Button("id", "POS_DiscPercntCal");
			Thread.sleep(2000);
			click_On_Button("id", "POS_CLbtnOKDiscLine");

		}
	}
	
	
	public void Discountamount(String Product, String a[]) throws InterruptedException {
		if (discountamount.equals("NA") == false) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]")));

			click_On_Button("xpath", "//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]");
			click_On_Button("id", "POS_BtnDiscLine");
			click_On_Button("id", "POS_DiscAmtCal");
			for (int i = 0; i < a.length; i++) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_calc_" + a[i].toString() + "");
			}
			click_On_Button("id", "POS_DiscAmtCal");
			Thread.sleep(2000);
			click_On_Button("id", "POS_CLbtnOKDiscLine");

		}
	}


	public void DiscountPerTotal(String a[]) throws InterruptedException {
		if (discountPerTotalpercentage.equals("NA") == false) {
			Thread.sleep(2000);
			click_On_Button("id", "POS_Pay"); // click on pay
			click_On_Button("id", "POS_ProDiscount"); // click on discount
			click_On_Button("id", "POS_CalProDiscPer");
			for (int i = 0; i < a.length; i++) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_calc_" + a[i].toString() + "");
			}

			click_On_Button("id", "POS_CalProDiscPer");
			Thread.sleep(1000);

		}

	}
	
	public void DiscountAmountTotal(String a[]) throws InterruptedException {
		if (discountPerTotalamount.equals("NA") == false) {
			Thread.sleep(2000);
			click_On_Button("id", "POS_Pay"); // click on pay
			click_On_Button("id", "POS_ProDiscount"); // click on discount
			click_On_Button("id", "POS_CalProDisc");
			for (int i = 0; i < a.length; i++) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_calc_" + a[i].toString() + "");
			}

			click_On_Button("id", "POS_CalProDisc");
			Thread.sleep(1000);
		}
	}
	public void AddModifier(String Product) {
		if (!modifier.equals("NA") && (modifier.equals("Y"))) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//p[@class='VAPOS_grdNameP'][(text()='" + Product + "')]")));

			click_On_Button("xpath", "//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]");
			click_On_Button("id", "POS_BtnAddModifiers");
			driver.findElements(By.xpath("//div[@class='pos-modifireBtn pos-modiPlus']")).get(0).click();
			driver.findElements(By.xpath("//div[@class='pos-modifireBtn pos-modiPlus']")).get(1).click();
			driver.findElements(By.xpath("//div[@class='pos-modifireBtn pos-modiPlus']")).get(1).click();
			driver.findElements(By.xpath("//div[@class='pos-modifireBtn pos-modiMinus']")).get(1).click();
			driver.findElements(By.xpath("//div[@class='pos-modifireBtn pos-modiPlus']")).get(2).click();
			click_On_Button("id", "pos_modi_setbtn");
		}
	}
	
	

	public void orderlogcomplete() {

		click_On_Button("id", "POSVA019_OrdersLog");
		inputdata("id", "POS_OrderLogtxtInvoice", OrderNumber);
		click_On_Button("id", "POS_OrdLogSearchOrder");

		String Orderlog = driver.findElement(By.xpath("//h3[@data-id='VAPOS_ordLogOrdNo']")).getText();
		System.out.println("Orderlog" + Orderlog);

	}
	
	public void OnCredit(String a[]) throws InterruptedException {
		if (onCredit.equalsIgnoreCase("Y")) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Thread.sleep(2000);
			click_On_Button("id", "POS_OnCredit");

			String popup = driver.findElement(By.id("POS_CLInformationAlert")).getText();
			if (popup.equals("Error")) {
				String CreditNotAllowed = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
				System.out.println(CreditNotAllowed);
				String sub = CreditNotAllowed.substring(0, 24);
				if (sub.equalsIgnoreCase("Credit Not Allowed for :")) {
					click_On_Button("id", "POS_btnCloseInfoAlert");
					click_On_Button("id", "POS_BackCat");
				}
				tab(0);
				driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
				click_On_Button("id", "vis_appMenu");
				inputdata("id", "vis_menuSearch", "Customer Master");
				click_On_Button("linktext", "Customer Master");
				inputdata("xpath", "//input[@placeholder='Search'][@class='vis-apanel-search ui-autocomplete-input']",
						customername);
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Multi16.png']");
				inputdata("xpath",
						"//td[@colspan='2']//select[@name='SOCreditStatus'][@style='display: inline-block;']",
						"Credit OK");
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Save24.png']");
				tab(1);
				click_On_Button("id", "POS_BackCat");
				Thread.sleep(2000);
				click_On_Button("id", "POS_DisplayUtilities");

				click_On_Button("id", "POS_GetMaster");

				click_On_Button("id", "POS_OnCredit");
				click_On_Button("id", "POS_OnCreditDone");

			}

			click_On_Button("id", "POS_ClearOnCreditAmt");
	

			for (int i = 0; i < a.length; i++) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_CreditPay" + a[i].toString() + "");
			}

			click_On_Button("id", "POS_OnCreditDone");
			
			
			String CreditLimit = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
			if (CreditLimit.equals("Credit Limit Reached")) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_btnCloseInfoAlert");
				tab(0);
				driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
				click_On_Button("id", "vis_appMenu");
				inputdata("id", "vis_menuSearch", "Customer Master");
				click_On_Button("linktext", "Customer Master");
				inputdata("xpath", "//input[@placeholder='Search'][@class='vis-apanel-search ui-autocomplete-input']",
						customername);
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Multi16.png']");
				inputdata("xpath","//td[@colspan='3']//input[@name='SO_CreditLimit'][@class='vis-gc-vpanel-table-mandatory']","1000");
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Refresh24.png']");
				Thread.sleep(2000);
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Save24.png']");
				Thread.sleep(2000);
				tab(1);
				click_On_Button("id", "POS_RefreshUtil");
				Thread.sleep(2000);
				click_On_Button("id", "POSVA019_DueBillPaymentClose");

				click_On_Button("id", "POSVA019_Mastersync");

				DueBillPayment();
				Thread.sleep(2000);
				click_On_Button("id", "POS_OnCredit");
				click_On_Button("id", "POS_OnCreditDone");

			}
			
			if(OnCreditDenominaion.equalsIgnoreCase("Y") ){
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_CreditPay" + a[i].toString() + "");
				}

				Thread.sleep(1000);
				click_On_Button("id", "POS_OnCreditDone");
				}
				
				
				if(OnCreditKeyPad.equalsIgnoreCase("Y")){
					click_On_Button("id", "POS_OnCreditPayCal");
					//for (int i = 0; i < b.length; i++) {
						Thread.sleep(1000);
					//	click_On_Button("id", "POS_calc_" + a[i].toString() + "");
					}
					click_On_Button("id", "POS_CLAddOnCreditAmount");
					click_On_Button("id", "POS_OnCreditDone");
					
				
			
			
			String PleasePay = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
			if(PleasePay.equalsIgnoreCase("Please Pay")){
				click_On_Button("id", "POS_btnCloseInfoAlert");
			}
			Thread.sleep(2000);
			if(Cash.equals("NA") && card.equals("NA")){
			click_On_Button("id", "POSVA019_btnDueBillPayCancel");
			}
		}
		}
	//}
	
	public void SyncData() throws InterruptedException{

		 
		 click_On_Button("id", "POSVA019_OrdersLog");
		 String RecordNotFound = driver.findElement(By.id("POS_LogRecordNotFound")).getText();
		 if(RecordNotFound.equalsIgnoreCase("Record Not Found")){
			 tab(0);
				driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
				SalesOrder();
				
		 }
		 
		 else{
			 Thread.sleep(2000);
			 click_On_Button("id", "POS_btnRefreshOrdersLog");
			 Thread.sleep(2000);
			 click_On_Button("id", "POS_btnCloseOrdersLog");
			 click_On_Button("id", "POSVA019_SyncRecords");
			 Thread.sleep(10000);
			 tab(0);
				driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
				SalesOrder();
				
		 }
	 }
	 
		 
	 String  OrderNum=null;
	 String  ActualAmount=null;
	 String  TotalLines=null;
	 String  GrandTotal=null;
	 String DocumentStatus =null;
	 String PaymentMethod = null;
	 String CashPaid= null;
	 String CardPaid = null;
	 String OnCredit= null;
	 
	 public void SalesOrder() throws InterruptedException{
		 
		 click_On_Button("id", "vis_appMenu");
			inputdata("id", "vis_menuSearch", "Sales Order");
			click_On_Button("linktext", "Sales Order");
			
			int rowCount = reader.getRowCount("Retail");
			for (int i = 2; i <= rowCount; i++) {
				runOn = reader.getCellData("QSR", "RUN", i);
				OrderNum = reader.getCellData("QSR", "OrderNumber", i);
				if (runOn.equals("ON")) {
						
				inputdata("xpath", "//input[@class='vis-apanel-search ui-autocomplete-input']",OrderNum);
				click_On_Button("xpath","//img[@src='/Areas/VIS/Images/base/Sear.png']");
				Thread.sleep(2000);
				
				TotalLines = driver.findElement(By.xpath("//input[@name='TotalLines']")).getAttribute("value");
				GrandTotal = driver.findElement(By.xpath("//input[@name='GrandTotal']")).getAttribute("value");
				DocumentStatus = driver.findElement(By.xpath("//option[@value='CO']")).getAttribute("value");
				PaymentMethod = driver.findElements(By.xpath("//select[@name='VA009_PaymentMethod_ID']")).get(0).getAttribute("value");
				System.out.println(DocumentStatus);
				System.out.println(PaymentMethod);
				CashPaid= driver.findElement(By.xpath("//input[@name='VAPOS_CashPaid']")).getAttribute("value");
				CardPaid=driver.findElement(By.xpath("//input[@name='VAPOS_PayAmt']")).getAttribute("value");
				OnCredit=driver.findElement(By.xpath("//input[@name='VAPOS_CreditAmt']")).getAttribute("value");
		
			
		if(DocumentStatus.equalsIgnoreCase("CO")){
			
					reader.setCellData("HomeDelivery", "GrandTotal(Sales Order)",i, TotalLines);
					reader.setCellData("HomeDelivery", "SubTotal(Sales Order)",i, GrandTotal);
					reader.setCellData("HomeDelivery", "Document status of html(Sales Order)",i, DocumentStatus);
					reader.setCellData("HomeDelivery", "Cash(Sales Order)",i, CashPaid);
					reader.setCellData("HomeDelivery", "Card(Sales Order)",i, CardPaid);
					reader.setCellData("HomeDelivery", "ONCredit(Sales Order)",i, OnCredit);
					reader.setCellData("HomeDelivery", "PaymentMethod(Sales Order)",i, PaymentMethod);
					reader.setCellData("HomeDelivery", "HTML Status(Sales Order)",i, "Passed");
					}
				
		else{
			reader.setCellData("HomeDelivery", "GrandTotal(Sales Order)",i, TotalLines);
			reader.setCellData("HomeDelivery", "SubTotal(Sales Order)",i, GrandTotal);
			reader.setCellData("HomeDelivery", "Document status of html(Sales Order)",i, DocumentStatus);
			reader.setCellData("HomeDelivery", "Cash(Sales Order)",i, CashPaid);
			reader.setCellData("HomeDelivery", "Card(Sales Order)",i, CardPaid);
			reader.setCellData("HomeDelivery", "ONCredit(Sales Order)",i, OnCredit);
			reader.setCellData("HomeDelivery", "PaymentMethod(Sales Order)",i, PaymentMethod);
			reader.setCellData("HomeDelivery", "HTML Status(Sales Order)",i, "Fail");
				}
				}
			}
		 
	 

			}
	 
	 
	 
	 public void InvoiceCustomer() throws InterruptedException{/*
		 driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
		 click_On_Button("id", "vis_appMenu");
			inputdata("id", "vis_menuSearch", "Invoice (Customer)");
			click_On_Button("linktext", "Invoice (Customer)");
			
			int rowCount = reader.getRowCount("HomeDelivery");
			for (int i = 2; i <= rowCount; i++) {
				runOn = reader.getCellData("HomeDelivery", "RUN", i);
				OrderNum = reader.getCellData("HomeDelivery", "OrderNumber", i);
				ActualAmount = reader.getCellData("HomeDelivery", "Actual Amount", i);
			
				
				if (runOn.equals("ON")) {
					Thread.sleep(5000);
					click_On_Button("xpath", "//h2[text()='Invoice']");
			inputdata("xpath", "//input[@class='vis-apanel-search ui-autocomplete-input']",OrderNum);
			click_On_Button("xpath","//img[@src='/Areas/VIS/Images/base/Sear.png']");
			Thread.sleep(2000);
			TotalLines = driver.findElement(By.xpath("//input[@name='TotalLines']")).getAttribute("value");
			GrandTotal = driver.findElement(By.xpath("//input[@name='GrandTotal']")).getAttribute("value");
			Thread.sleep(3000);
		click_On_Button("xpath", "//h2[text()='Payment Schedule']");
		
		String PayMethod = driver.findElements(By.xpath("//select[@name='VA009_PaymentMethod_ID']")).get(1).getText();
		System.out.println("Payment"+PayMethod);
		if(PayMethod.equalsIgnoreCase("By Cash")){
			CashJournalLine = driver.findElement(By.xpath("//select[@name='C_CashLine_ID']")).getText();
			System.out.println("CashJournalLine"+CashJournalLine);
		}
		
		
		if (PayMethod.equalsIgnoreCase("Card")){
			Payment = driver.findElement(By.xpath("//select[@name='C_Payment_ID']")).getText();
			System.out.println("Payment"+Payment);
		}
		
		
		
		
		
		if(TotalLines.equalsIgnoreCase(GrandTotal)&&(GrandTotal.equalsIgnoreCase(ActualAmount))){
			
			reader.setCellData("HomeDelivery", "TotalLines(Invoice)",i, TotalLines);
			reader.setCellData("HomeDelivery", "GrandTotal(Invoice)",i, GrandTotal);
			reader.setCellData("HomeDelivery", "Invoice(Status)",i, "Passed");
			reader.setCellData("HomeDelivery", "CashBook line",i, CashJournalLine);
			reader.setCellData("HomeDelivery", "Payment",i, Payment);

			
		}
		else{
            reader.setCellData("HomeDelivery", "TotalLines(Invoice)",i, TotalLines);
			reader.setCellData("HomeDelivery", "GrandTotal(Invoice)",i, GrandTotal);
			reader.setCellData("HomeDelivery", "Invoice(Status)",i, "Failed");
			reader.setCellData("HomeDelivery", "CashBook line",i, CashJournalLine);
			reader.setCellData("HomeDelivery", "Payment",i, Payment);


		}
		
		
		
			
	 
			}

           }
	 */}
	 
	 
	 public void ReturnWithoutInvoices(){
     	if(ReturnWithoutInvoice.equalsIgnoreCase("YES")){
     	click_On_Button("id", "POS_AddReturnsRP");
     	click_On_Button("id", "POS_divReturnWithoutInv");
     	}
}
}

