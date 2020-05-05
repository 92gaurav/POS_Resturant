package QSR;
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
import Common_Class.Action_Clas;
import Common_Class.Xls_Reader;

public class Invoices extends Action_Clas {
	Xls_Reader reader = 
	//	new Xls_Reader("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\Restaurant_Project.xlsx");
			new Xls_Reader("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Excel\\Restaurant_Project.xlsx");

	Random rand = new Random();
	int rand_int1 = rand.nextInt(100);
	String OrderNumber = null;
	String Orderno = null;

	public void QSR() throws Exception {
		QSRs("QSR");
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
	String discountamount;
	String orderNumber;
	String UserName;
	String POSTerminal;
	String MultiCash;
	String CurrencyType;
	String multiCard;
	String modifier;
	String modifierproduct;
	String discountPerTotalamount;
	String discountPerTotalpercentage;
	String onCredit;
	String paro;
	String Area;
	String course;
	String cate;
	String CreditAmount;
	String OnCreditDenominaion;
	String OnCreditKeyPad;
	String CreditKeyPadDenominationValue;
	String CreditSettelment;
	String runOn;

	public void QSRs(String SheetName) throws Exception {

		int rowCount = reader.getRowCount(SheetName);
		int rowCount2 = reader.getRowCount("QSR_Data");
		for (int i = 2; i <= rowCount; i++) {
			runOn = reader.getCellData(SheetName, "RUN", i);
			String ref1 = reader.getCellData(SheetName, "Refrence Id", i);
			String param1 = reader.getCellData(SheetName, "Expected Total Price", i);
			if (runOn.equals("ON")) {
				for (int j = 2; j <= rowCount2; j++) {
					try{
					String ref = reader.getCellData("QSR_Data", "Refrence Id", j);
					System.out.println("QSR_Data Refrence Id : " +ref);
					if (ref1.equalsIgnoreCase(ref)) {
						UserName = reader.getCellData("QSR_Data", "UserName", j);
						String HTMLPassword = reader.getCellData("QSR_Data", "HtmlPassword", j);
						// Pos Terminal Selected
						POSTerminal = reader.getCellData("QSR_Data", "Pos Terminal", j);
						// POS Terminal User
						String POSTerminalUser = reader.getCellData("QSR_Data", "Pos Temrinal User", j);
						// Password
						String Password = reader.getCellData("QSR_Data", "Password", j);

						Area = reader.getCellData("QSR_Data", "Area", j);
						course = reader.getCellData("QSR_Data", "Course", j);
						cate = reader.getCellData("QSR_Data", "Category", j);
						paro = reader.getCellData("QSR_Data", "PRODUCT", j);
						Cash = reader.getCellData("QSR_Data", "Cash", j);
						card = reader.getCellData("QSR_Data", "Card", j);
						multiCard = reader.getCellData("QSR_Data", "CardMultiCurrency", j);
						oncredit = reader.getCellData("QSR_Data", "OnCredit", j);
						customername = reader.getCellData("QSR_Data", "CustomerName", j);
						dicountpercentage = reader.getCellData("QSR_Data", "Discount Percentage", j);
						discountamount = reader.getCellData("QSR_Data", "Discount Amount", j);
						DiscountProduct = reader.getCellData("QSR_Data", "Discount Product", j);
						discountPerTotalamount = reader.getCellData("QSR_Data", "Total Discount Amount", j);
						discountPerTotalpercentage = reader.getCellData("QSR_Data", "Total Discount Percentage", j);
						MultiCash = reader.getCellData("QSR_Data", "CashMultiDenomination", j);
						CurrencyType = reader.getCellData("QSR_Data", "CashMulti Curency", j);
						modifier = reader.getCellData("QSR_Data", "Modifier", j);
						modifierproduct = reader.getCellData("QSR_Data", "Modifier Product", j);
						quickpay = reader.getCellData("QSR_Data", "QuickPayment", j);
						onCredit = reader.getCellData("QSR_Data", "On Credit", j);
						CreditAmount = reader.getCellData("QSR_Data", "Credit Amount", j);
						OnCreditDenominaion = reader.getCellData("QSR_Data", "On Credit Denimation", j);
						OnCreditKeyPad = reader.getCellData("QSR_Data", "OnCreditVirtual Keypad", j);
						CreditKeyPadDenominationValue = reader.getCellData("QSR_Data", "OnCreditVirtual KeypadAmount",
								j);
						CreditSettelment = reader.getCellData("QSR_Data", "Credit Card Settlement", j);
						String OccupiedTermninal = reader.getCellData("QSR_Data", "POS Terminal ON HTML", j);
						String Prefix = reader.getCellData("QSR_Data", "OrderPrefix", j);

						WebDriverWait wait = new WebDriverWait(driver, 30);
						// lOGIN Page
						login_Html(UserName, HTMLPassword, OccupiedTermninal);

						// LoginPagePOS
						loginPage(POSTerminal, Password, POSTerminalUser);

						// SelectArea
						Area();

						// Save OrderNumber
						OrderNumberInfo(Prefix);

						selectcustomer(customername);

						// Add Product
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
						// total discount percentage
						String[] arrSplit5 = discountPerTotalpercentage.split(",");
						DiscountPerTotal(arrSplit5);
						// total discount amoount
						String[] arrSplit6 = discountPerTotalamount.split(",");
						DiscountAmountTotal(arrSplit6);
						// cash
						QuickPay();

						String[] arrSpli21 = CreditAmount.split(",");
						String[] arrSpli3 = CreditKeyPadDenominationValue.split(",");
						OnCredit(arrSpli21, arrSpli3);

						CreditSettlement();
						String[] arrSplit2 = Cash.split(",");
						cash(arrSplit2);

						String[] arrSplit1 = MultiCash.split(",");
						multiCash(arrSplit1);

						cardPay(card);
						CardMulti(multiCard);
						// logout
						logout();
						// kitchen
						kitchen();
						// delivery
						delivery();

					}
				}catch(Exception e){
					driver.navigate().refresh();
					continue;
				} 
				
				
				}
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

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////

	public void lounchApp(String link) throws IOException {

		openbrowser("Chrome");
		driver.get(link);

	}

	// Login to HTML
	public void login_Html(String uname, String pwd, String OccupiedTerminal)
			throws AWTException, InterruptedException {
		try {
			driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
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
					driver.switchTo().window(tabs.get(1)); // switches to new
					// tab
					//driver.get("http://restposbeta.v.local/");
					 driver.get("http://restpossandbox.v.local/");

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
					driver.switchTo().window(tabs.get(1)); // switches to new
					// tab
					driver.get("http://restposbeta.v.local/");
					// driver.get("http://restpossandbox.v.local/");
					// driver.get("http://138.201.234.236:8099/");
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Login to POS
	public void loginPage(String terminal, String pwd, String pOSTerminalUser)
			throws AWTException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		try {
			if (POSTerminal.equals("NA") == false) {
				inputdata("id", "POS_cmbTerm", terminal);
				click_On_Button("xpath", "//select[@id='POS_cmbTermUser']//option[@value=" + pOSTerminalUser + "]");
				driver.findElement(By.id("POS_txtPwd")).clear();
				inputdata("id", "POS_txtPwd", pwd);
				click_On_Button("id", "POS_btnLogin");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void Area() {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_Q']")));
		click_On_Button("xpath", "//div[@data-mode='POSVA019_Q']");
	}

	public void selectcustomer(String CustomerName) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		if (customername.equalsIgnoreCase("NA") == false) {
			try {

				click_On_Button("id", "POS_SearchCustomer");
				inputdata("id", "POS_txtCustSearch", CustomerName);
				click_On_Button("id", "POS_BtnCustSearch");
				Thread.sleep(2000);
				click_On_Button("xpath", "//div[@class='third-p']");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void OrderNumberInfo(String Prefix) throws InterruptedException {
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try{
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_OrdNo")));
		String we3 = driver.findElement(By.id("POS_OrdNo")).getText();
		String OrderPrefix = Prefix;
		orderNumber = OrderPrefix + we3;
		}
		catch(Exception e)
		{
		System.out.println("Ordernumber" +e);
		}
	}

	public void productSelection(String Course, String Category, String a[]) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		if (course.equalsIgnoreCase("NA") == false) {
			// Selecting Courses...
			click_On_Button("xpath", "//ul[@id='POSVA019_Courses']//li[contains(text(),'" + Course + "') ]");
			// Selecting Category....
			click_On_Button("xpath", "//ul[@id='POSVA019_ULRightPanel']//li[contains(text(),'" + Category + "') ]");
			// Clicking on Product......
			for (int i = 0; i < a.length; i++) {
				click_On_Button("xpath",
						" //div[@class='pos-fontRightProductBottom'][contains(text(),'" + a[i].toString() + "')]");
			}
		}
	}

	public void logout() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_CLLogout")));
		Thread.sleep(5000);
		click_On_Button("id", "POS_CLLogout");

	}
	
	
	Screen s = new Screen();
//	Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Start.PNG");
//	Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");
//	Pattern p2 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Stop.PNG");
	
	Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Start.PNG");
	Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Close.PNG");
	Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Stop.PNG");
	
	public void kitchen() throws InterruptedException, FindFailed {
		try{
		// kitchen
		click_On_Button("id", "POSVA019_KitchenLI");
		click_On_Button("xpath", "//a[@class='posva019-d-validate']");
		while (s.exists(p) != null) {
			s.click(p);
			Thread.sleep(1000);
		}
		while (s.exists(p2) != null) {
			s.click(p2);
		}

		s.click(p1);
		Thread.sleep(100);
		}catch (Exception e){
			s.click(p1);
		}
	}

	public void delivery() throws InterruptedException, Exception {
		try{

		// ImagePath.setBundlePath("src/test/java/SikuliImages");
		Screen s = new Screen();
		Pattern p = 
			//	new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\DeliveryDone.PNG");
		
		new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\DeliveryDone.PNG");
		click_On_Button("id", "POSVA019_DeliveryLI");
		click_On_Button("xpath", "//a[@class='posva019-d-validate']");

		while (s.exists(p) != null) {
			s.click(p);
			Thread.sleep(200);
		}
		s.click(p1);
		}catch(Exception e){
			s.click(p1);
		}
	}

	public void orderlog() throws InterruptedException {
		Thread.sleep(5000);
		click_On_Button("id", "POSVA019_OrdersLog");
		Thread.sleep(3000);
		inputdata("id", "POS_OrderLogtxtInvoice", orderNumber);
		Thread.sleep(2000);
		click_On_Button("id", "POS_OrdLogSearchOrder");
		Thread.sleep(1000);
		click_On_Button("id", "POS_btnCloseOrdersLog");
	}

	public void cash(String a[]) throws InterruptedException, FindFailed {
		try{
		if (Cash.equals("NA") == false) {
			Screen s = new Screen();
//			Pattern p = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Done.PNG");
//			Pattern p1 = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
//			Pattern p2 = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
//			
			Pattern p = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Done.PNG");
			Pattern p1 = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
			Pattern p2 = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\AuthDone.PNG");
			
			click_On_Button("id", "POS_Pay");
			click_On_Button("id", "POS_Cash");
			for (int i = 0; i < a.length; i++) {
				Thread.sleep(2000);
				click_On_Button("id", "VAPOS_POSDenominatorValue" + a[i].toString() + "");
			}

			s.click(p);
			// click_On_Button("id", "POS_PayDoneCash");

			String RemaningBalance = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
			if (RemaningBalance.equalsIgnoreCase("Please Pay")) {
				click_On_Button("id", "POS_btnCloseInfoAlert");

			}

			Thread.sleep(5000);
			while (s.exists(p1) != null) {
				s.click(p1);
				Thread.sleep(2000);
			}

			String ReturnMultiCurrency = driver.findElement(By.id("POS_CLPopReturnAmountMcur")).getText();
			System.out.println("ReturnMultiCurrency" + ReturnMultiCurrency);
			if (ReturnMultiCurrency.equalsIgnoreCase("Return Amount")) {
				s.click(p2);
			}

			Thread.sleep(5000);
			while (s.exists(p1) != null) {
				s.click(p1);
				Thread.sleep(2000);
			}

			String ReturnPopup = driver.findElement(By.id("POS_CLPopReturnAmount")).getText();

			if (ReturnPopup.equalsIgnoreCase("Return Amount")) {
				click_On_Button("id", "btnCloseReturnAmt");
			}

		}}
	catch(Exception e)	{
		click_On_Button("id", "POS_Logout");
	}

	}

	public void multiCash(String b[]) throws InterruptedException, FindFailed {

		if (MultiCash.equals("NA") == false) {

			Screen s = new Screen();
//			Pattern p = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Done.PNG");
//			Pattern p1 = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
//			
			Pattern p = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Done.PNG");
			Pattern p1 = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
			
			click_On_Button("id", "POS_Pay");
			click_On_Button("id", "POS_Cash");
			click_On_Button("id", "POS_ChangeCurrencyP");
			Thread.sleep(2000);
			click_On_Button("xpath", CurrencyType);
			Thread.sleep(2000);
			for (int i = 0; i < b.length; i++) {
				Thread.sleep(2000);
				click_On_Button("id", "VAPOS_POSDenominatorValue" + b[i].toString() + "");
			}

			s.click(p);
			// click_On_Button("id", "POS_PayDoneCash");

			String RemaningBalance = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
			if (RemaningBalance.equalsIgnoreCase("Please Pay")) {
				click_On_Button("id", "POS_btnCloseInfoAlert");
			}

			Thread.sleep(5000);
			while (s.exists(p1) != null) {
				s.click(p1);
				Thread.sleep(2000);
			}

			String ReturnPopup = driver.findElement(By.id("POS_CLPopReturnAmount")).getText();

			if (ReturnPopup.equalsIgnoreCase("Return Amount")) {
				click_On_Button("id", "btnCloseReturnAmt");
			}
		}

	}

	String ECR = null;

	public void cardPay(String cardNo) throws InterruptedException, FindFailed {
		try{

		if (card.equals("NA") == false) {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			Screen s = new Screen();
//			Pattern p = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\AuthDone.PNG");
//			Pattern p1 = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
//			
			Pattern p = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\AuthDone.PNG");
			Pattern p1 = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
			
			click_On_Button("id", "POS_Pay");
			click_On_Button("id", "POS_Credit");

			Thread.sleep(1000);
			click_On_Button("xpath", "//li[contains(text(),'" + cardNo + "')]");
			ECR = driver.findElement(By.id("POS_ECRCredit")).getText();
			if (ECR.equalsIgnoreCase("ECR")) {
				click_On_Button("id", "POS_ECRCredit");
				wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_btnCloseInfoAlert")));
				Thread.sleep(5000);
				click_On_Button("id", "POS_btnCloseInfoAlert");

			}

			click_On_Button("id", "POS_OkCredit");
			Thread.sleep(2000);
			String Popup = driver.findElement(By.id("POS_CLLblTranscationNo")).getText();

			if (Popup.equalsIgnoreCase("Auth. Code")) {
				inputdata("id", "POS_txtTranscationNo", "56575");
				// click_On_Button("id", "POS_btnOKTranscationNo");

				s.click(p);
				Thread.sleep(5000);
				while (s.exists(p1) != null) {
					s.click(p1);
					Thread.sleep(2000);
				}
			}
		}
		}catch(Exception e){
			click_On_Button("id", "POS_Logout");
		}
	}

	public void CardMulti(String cardNo1) throws InterruptedException, FindFailed {
		if (multiCard.equals("NA") == false) {
			Screen s = new Screen();
//			Pattern p = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
//			Pattern p1 = new Pattern(
//					"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
//			
			Pattern p = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\AuthDone.PNG");
			Pattern p1 = new Pattern(
					"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
			
			Thread.sleep(2000);
			click_On_Button("id", "POS_Pay");
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
				s.click(p);
				Thread.sleep(5000);
				while (s.exists(p1) != null) {
					s.click(p1);
					Thread.sleep(2000);
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

	public void QuickPay() throws FindFailed, InterruptedException {
		Screen s = new Screen();
//		Pattern p = new Pattern(
//				"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\QuickPayment.PNG");
//		Pattern p1 = new Pattern(
//				"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
//		
		Pattern p = new Pattern(
				"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\QuickPayment.PNG");
		Pattern p1 = new Pattern(
				"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
		
		if (quickpay.equalsIgnoreCase("Y")) {
			click_On_Button("xpath", "//a[text()='Quick Pay']");
			Thread.sleep(2000);
			// click_On_Button("xpath", "//div[@class='pos-PopupBtn pull-right
			// pos-confirm-alert']//a[@class='btn pos-btn pos-AddProBtn']");
			s.click(p);
			Thread.sleep(5000);
			while (s.exists(p1) != null) {
				s.click(p1);
				Thread.sleep(2000);
			}
		}
	}

	public void OnCredit(String a[], String b[]) throws InterruptedException, FindFailed {
		Screen s = new Screen();
//		Pattern p = new Pattern(
//				"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Done.PNG");
//		Pattern p1 = new Pattern(
//				"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
//		
		Pattern p = new Pattern(
				"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Done.PNG");
		Pattern p1 = new Pattern(
				"C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
		if (onCredit.equalsIgnoreCase("Y")) {
			Thread.sleep(2000);
			click_On_Button("id", "POS_Pay");
			click_On_Button("id", "POS_OnCredit");
			click_On_Button("id", "POS_ClearOnCreditAmt");

			if (OnCreditDenominaion.equalsIgnoreCase("Y")) {
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_CreditPay" + a[i].toString() + "");
				}
				s.click(p);
				Thread.sleep(1000);
				// click_On_Button("id", "POS_OnCreditDone");
			}

			if (OnCreditKeyPad.equalsIgnoreCase("Y")) {
				click_On_Button("id", "POS_OnCreditPayCal");
				for (int i = 0; i < b.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + b[i].toString() + "");
				}
				click_On_Button("id", "POS_CLAddOnCreditAmount");
				click_On_Button("id", "POS_OnCreditDone");

			}

			String PleasePay = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
			if (PleasePay.equalsIgnoreCase("Please Pay")) {
				click_On_Button("id", "POS_btnCloseInfoAlert");
			}

			Thread.sleep(5000);
			while (s.exists(p1) != null) {
				s.click(p1);
				Thread.sleep(2000);
			}

		}
	}

	public void SyncData() throws InterruptedException {

		//it is for not interacting the variable
		click_On_Button("id", "POS_Logout");
		
		click_On_Button("id", "POSVA019_OrdersLog");
		String RecordNotFound = driver.findElement(By.id("POS_LogRecordNotFound")).getText();
		if (RecordNotFound.equalsIgnoreCase("Record Not Found")) {
			tab(0);
			driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
			SalesOrder();
			invoice();
		}

		else {
			Thread.sleep(2000);
			click_On_Button("id", "POS_btnRefreshOrdersLog");
			Thread.sleep(2000);
			click_On_Button("id", "POS_btnCloseOrdersLog");
			click_On_Button("id", "POSVA019_SyncRecords");
			Thread.sleep(10000);
			tab(0);
			driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
			SalesOrder();
			invoice();
		}
	}

	String OrderNum = null;
	String ActualAmount = null;
	String TotalLines = null;
	String GrandTotal = null;
	String DocumentStatus = null;
	String PaymentMethod = null;
	String CashPaid = null;
	String CardPaid = null;
	String OnCredit = null;

	public void SalesOrder() throws InterruptedException {

		click_On_Button("id", "vis_appMenu");
		inputdata("id", "vis_menuSearch", "Sales Order");
		click_On_Button("linktext", "Sales Order");

		int rowCount = reader.getRowCount("QSR");
		for (int i = 2; i <= rowCount; i++) {
			runOn = reader.getCellData("QSR", "RUN", i);
			OrderNum = reader.getCellData("QSR", "OrderNumber", i);
			if (runOn.equals("ON")) {

				inputdata("xpath", "//input[@class='vis-apanel-search ui-autocomplete-input']", OrderNum);
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
				Thread.sleep(2000);

				TotalLines = driver.findElement(By.xpath("//input[@name='TotalLines']")).getAttribute("value");
				GrandTotal = driver.findElement(By.xpath("//input[@name='GrandTotal']")).getAttribute("value");
				DocumentStatus = driver.findElement(By.xpath("//option[@value='CO']")).getAttribute("value");
				PaymentMethod = driver.findElements(By.xpath("//select[@name='VA009_PaymentMethod_ID']")).get(0)
						.getAttribute("value");
				System.out.println(DocumentStatus);
				System.out.println(PaymentMethod);
				CashPaid = driver.findElement(By.xpath("//input[@name='VAPOS_CashPaid']")).getAttribute("value");
				CardPaid = driver.findElement(By.xpath("//input[@name='VAPOS_PayAmt']")).getAttribute("value");
				OnCredit = driver.findElement(By.xpath("//input[@name='VAPOS_CreditAmt']")).getAttribute("value");

				if (DocumentStatus.equalsIgnoreCase("CO")) {

					reader.setCellData("QSR", "GrandTotal(Sales Order)", i, TotalLines);
					reader.setCellData("QSR", "SubTotal(Sales Order)", i, GrandTotal);
					reader.setCellData("QSR", "Document status of html(Sales Order)", i, DocumentStatus);
					reader.setCellData("QSR", "Cash(Sales Order)", i, CashPaid);
					reader.setCellData("QSR", "Card(Sales Order)", i, CardPaid);
					reader.setCellData("QSR", "ONCredit(Sales Order)", i, OnCredit);
					reader.setCellData("QSR", "PaymentMethod(Sales Order)", i, PaymentMethod);
					reader.setCellData("QSR", "HTML Status(Sales Order)", i, "Passed");
				}

				else {
					reader.setCellData("QSR", "GrandTotal(Sales Order)", i, TotalLines);
					reader.setCellData("QSR", "SubTotal(Sales Order)", i, GrandTotal);
					reader.setCellData("QSR", "Document status of html(Sales Order)", i, DocumentStatus);
					reader.setCellData("QSR", "Cash(Sales Order)", i, CashPaid);
					reader.setCellData("QSR", "Card(Sales Order)", i, CardPaid);
					reader.setCellData("QSR", "ONCredit(Sales Order)", i, OnCredit);
					reader.setCellData("QSR", "PaymentMethod(Sales Order)", i, PaymentMethod);
					reader.setCellData("QSR", "HTML Status(Sales Order)", i, "Fail");
				}
			}
		}
	}

	String PaymentValue = null;
	String SubTotalInvoice = null;
	String GrandTotalInvoice = null;
	String DocumentStatusInvoice = null;
	String PaidAmount = null;
	String PaymentMethodInvoice = null;

	public void invoice() throws InterruptedException {

		driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
		click_On_Button("id", "vis_appMenu");
		inputdata("id", "vis_menuSearch", "Invoice (Customer)");
		click_On_Button("linktext", "Invoice (Customer)");

		int rowCount = reader.getRowCount("QSR");
		for (int i = 2; i <= rowCount; i++) {
			runOn = reader.getCellData("QSR", "RUN", i);
			OrderNum = reader.getCellData("QSR", "OrderNumber", i);
			if (runOn.equals("ON")) {

				inputdata("xpath", "//input[@class='vis-apanel-search ui-autocomplete-input']", OrderNum);
				click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
				Thread.sleep(2000);

				SubTotalInvoice = driver.findElement(By.xpath("//input[@name='TotalLines']")).getAttribute("value");
				GrandTotalInvoice = driver.findElement(By.xpath("//input[@name='GrandTotal']")).getAttribute("value");
				PaidAmount = driver.findElement(By.xpath("//input[@name='VA009_PaidAmount']")).getAttribute("value");
				DocumentStatusInvoice = driver.findElement(By.xpath("//option[@value='CO']")).getAttribute("value");
				PaymentMethodInvoice = driver.findElements(By.xpath("//select[@name='VA009_PaymentMethod_ID']")).get(0)
						.getAttribute("value");

				click_On_Button("xpath", "//h2[text()='Payment Schedule']");
				if (CardPaid.equalsIgnoreCase("1000000")) {
					PaymentValue = driver.findElement(By.xpath("//input[@name='C_Payment_ID']")).getText();
					System.out.println("PaymentValue" + PaymentValue);
				}

				Thread.sleep(2000);
				click_On_Button("xpath", "//h2[text()='Invoice']");
				if (DocumentStatusInvoice.equalsIgnoreCase("CO")) {

					reader.setCellData("QSR", "SubTotal (Invoice(Customer))", i, SubTotalInvoice);
					reader.setCellData("QSR", "GrandTotal (Invoice(Customer))", i, GrandTotalInvoice);
					reader.setCellData("QSR", "Document status of html (Invoice(Customer))", i, DocumentStatusInvoice);
					reader.setCellData("QSR", "Paid Amount (Invoice(Customer))", i, PaidAmount);
					reader.setCellData("QSR", "Payment Method (Invoice(Customer))", i, PaymentMethodInvoice);
					reader.setCellData("QSR", "Status Invoice(Customer)", i, "Passed");
				}

				else {
					reader.setCellData("QSR", "SubTotal (Invoice(Customer))", i, SubTotalInvoice);
					reader.setCellData("QSR", "GrandTotal (Invoice(Customer))", i, GrandTotalInvoice);
					reader.setCellData("QSR", "Document status of html (Invoice(Customer))", i, DocumentStatusInvoice);
					reader.setCellData("QSR", "Paid Amount (Invoice(Customer))", i, PaidAmount);
					reader.setCellData("QSR", "Payment Method (Invoice(Customer))", i, PaymentMethodInvoice);
					reader.setCellData("QSR", "Status Invoice(Customer)", i, "Fail");
				}

			}

		}

	}

	public void CreditSettlement() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if (CreditSettelment.equalsIgnoreCase("Y")) {
			click_On_Button("id", "POS_SearchCustomer");
			inputdata("id", "POS_txtCustSearch", "AnkitaQSR");
			click_On_Button("id", "POS_BtnCustSearch");
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//img[@src='/Areas/POS/Content/Images/cus-info.png']")));
			click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/cus-info.png']");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("chkShowBusn")));
			click_On_Button("id", "chkShowBusn");
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//div[@class='CUS-table-row selected-row']//input[@type='checkbox']")));
			click_On_Button("xpath", "//div[@class='CUS-table-row selected-row']//input[@type='checkbox']");
			click_On_Button("id", "CST_CLPay");
		}

	}

	public void Return() {

	}

}
