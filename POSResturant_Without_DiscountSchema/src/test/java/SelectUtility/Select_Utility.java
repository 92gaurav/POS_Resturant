package SelectUtility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import Common_Class.Xls_Reader;

public class Select_Utility extends Common_Class.Action_Clas {
	Xls_Reader reader = 
//			new Xls_Reader("D:\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\Restaurant_Project.xlsx");
	new Xls_Reader("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Excel\\Restaurant_Project.xlsx");

	// Xls_Reader reader = new
	// Xls_Reader("D:\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\SelectUtility.xlsx");

	Random rand = new Random();
	int rand_int1 = rand.nextInt(100);
	String OrderNumber = null;
	String OrderNumber1 = null;
	String UserName;
	String POSTerminal;
	String CustName = null;
	String Area = null;

	public void Run_Method() throws AWTException, InterruptedException, FindFailed {
		Main_Method("Common");
	}

	public void Main_Method(String SheetName) throws AWTException, InterruptedException, FindFailed {
		int rowCount = reader.getRowCount(SheetName);
		int rowCount2 = reader.getRowCount("Common_Data");
		for (int i = 2; i <= rowCount; i++) {
			String runOn = reader.getCellData(SheetName, "RUN", i);
			String ref1 = reader.getCellData(SheetName, "Refrence Id", i);

			if (runOn.equals("ON")) {
				for (int j = 2; j <= rowCount2; j++) {
					String ref = reader.getCellData("Common_Data", "Refrence Id", j);

					if (ref1.equalsIgnoreCase(ref)) {

						UserName = reader.getCellData("Common_Data", "UserName", j);
						System.out.println(UserName);
						// HtmlLink Password
						String HTMLPassword = reader.getCellData("Common_Data", "HtmlPassword", j);

						// Pos Terminal Selected
						POSTerminal = reader.getCellData("Common_Data", "Pos Terminal", j);

						// POS Terminal User
						String POSTerminalUser = reader.getCellData("Common_Data", "Pos Temrinal User", j);

						// Password
						String Password = reader.getCellData("Common_Data", "Password", j);

						Area = reader.getCellData("Common_Data", "Area", j);

						// lOGIN Page
						login_Html(UserName, HTMLPassword);

						// LoginPagePOS
						loginPage(POSTerminal, Password, POSTerminalUser);

						// SelectArea
						Area(Area);

						// AllowAcess
						AllowAcess();

						// Change Pssword
						ChangePassword();

						// ShowTax
						ShowTax();

						// History Record
						HistoryRecord();

						// UPCSCAN
						searchUPCandAllSearch();

						homedeliveryexpectedDate();

					}
				}
			}
		}
	}

	// ******************************************************************************************************************************//

	// LounchApp
	public void lounchApp(String link) throws IOException {
		openbrowser("Chrome");
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	}
	// ******************************************************************************************************************************//

	// HTML login and Open Pos Link
	public void login_Html(String uname, String pwd) throws AWTException, InterruptedException {
		if (UserName.equals("NA") == false) {
			inputdata("id", "loginName", uname);
			inputdata("id", "txtPwd", pwd);
			click_On_Button("id", "btnLogin1");
			click_On_Button("id", "vis_appMenu");
			inputdata("id", "vis_menuSearch", "POS Terminal");
			click_On_Button("id", "ui-id-2");
			WebDriverWait wait = new WebDriverWait(driver, 60);
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
				// driver.get("http://restposbeta.v.local/");
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
				driver.switchTo().window(tabs.get(1)); // switches to new tab
				// driver.get("http://restposbeta.v.local/");
				driver.get("http://restpossandbox.v.local/");
			}

		}
	}

	// ******************************************************************************************************************************//

	// Login to POS
	public void loginPage(String terminal, String pwd, String pOSTerminalUser)
			throws AWTException, InterruptedException {
		if (POSTerminal.equals("NA") == false) {
			inputdata("id", "POS_cmbTerm", terminal);
			click_On_Button("xpath", "//select[@id='POS_cmbTermUser']//option[@value=" + pOSTerminalUser + "]");
			driver.findElement(By.id("POS_txtPwd")).clear();
			inputdata("id", "POS_txtPwd", pwd);
			click_On_Button("id", "POS_btnLogin");
//			WebDriverWait wait = new WebDriverWait(driver, 30);
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='posva019-setting-url']")));
//			driver.findElement(By.xpath("//input[@class='posva019-setting-url']")).clear();
//			inputdata("xpath", "//input[@class='posva019-setting-url']", "http://192.168.0.159:60600/api/");
//			wait.until(
//					ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='glyphicon glyphicon-remove']")));
//			click_On_Button("xpath", "//span[@class='glyphicon glyphicon-remove']");
//			Thread.sleep(3000);
//			click_On_Button("id", "va019_btnDRPwdOK");
		}
	}

	// ******************************************************************************************************************************//

	// Area
	public void Area(String Area) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		if (Area.equalsIgnoreCase("QSR")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_Q']")));
			click_On_Button("xpath", "//div[@data-mode='POSVA019_Q']");
		}

		if (Area.equalsIgnoreCase("HomeDelivery")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_H']")));
			click_On_Button("xpath", "//div[@data-mode='POSVA019_H']");
		}

		if (Area.equalsIgnoreCase("DineIn")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_E']")));
			click_On_Button("xpath", "//div[@data-mode='POSVA019_E']");
		}

		if (Area.equalsIgnoreCase("PickUp")) {
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_P']")));
			click_On_Button("xpath", "//div[@data-mode='POSVA019_P']");
		}
	}

	// ******************************************************************************************************************************//

	public void AllowAcess() throws InterruptedException, AWTException {

		WebDriverWait wait = new WebDriverWait(driver, 60);

		// allow access
		Thread.sleep(10000);

		tab(0);

		driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();

		menu("POS Terminal Users");

		Thread.sleep(5000);
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Find24.png']");
		inputdata("id", "drpColumn_2", "VAPOS_TerminalUsers_ID");
		Thread.sleep(2000);
		driver.findElement(By.id("drpColumn_2")).sendKeys("Terminal User (ID)");
		driver.findElement(By.name("VAPOS_TerminalUsers_ID")).sendKeys("1000050");
		click_On_Button("id", "btnSave_2");
		Thread.sleep(2000);
		click_On_Button("id", "btnOk_2");
		Thread.sleep(5000);
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Multi16.png']");

		Thread.sleep(5000);

		boolean kam = driver.findElement(By.xpath("//input[@name='VAPOS_IsDeletionAccess']")).isSelected();
		System.out.println(kam);
		if (kam) // if kam is true
		{
			driver.findElement(By.xpath("//input[@name='VAPOS_IsDeletionAccess']")).click();
			driver.findElement(By.xpath("//img[@src='/Areas/VIS/Images/base/Save24.png']")).click();
			Thread.sleep(5000);

		}

		boolean kam1 = driver.findElement(By.xpath("//input[@name='VAPOS_IsDiscountAccess']")).isSelected();
		System.out.println(kam1);
		if (kam1) // if kam is true
		{
			driver.findElement(By.xpath("//input[@name='VAPOS_IsDiscountAccess']")).click();
			driver.findElement(By.xpath("//img[@src='/Areas/VIS/Images/base/Save24.png']")).click();
			Thread.sleep(5000);
			tab(1);

		} else {

			tab(1);
		}

		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_GetMaster");
		Thread.sleep(5000);
		Area(Area);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='pos-fontRightProduct'][text()='Tomato Soup']")));
		click_On_Button("xpath", "//div[@class='pos-fontRightProduct'][text()='Tomato Soup']");

		click_On_Button("xpath", "//h3[@class='u-name-1 col-20 mobcol-15']");
		click_On_Button("xpath", "//h3[@class='u-name-1 col-20 mobcol-15']");

		String a1 = driver.findElement(By.id("POS_BtnDiscLine")).getAttribute("style");

		System.out.println(a1);
		if (a1.equalsIgnoreCase("opacity: 0.5; display: block;")) {
			System.out.println("Discount Not given");
		} else {
			System.out.println("Discount is given");

		}

		click_On_Button("xpath", "//div[@class='pic picM']");
		click_On_Button("id", "POS_btnCloseInfoAlert");
		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_AllowAccess");
		driver.findElement(By.id("cmbUserAccess")).sendKeys("Ankita User");
		driver.findElement(By.id("POS_txtUserAccessPwd")).sendKeys("123");
		click_On_Button("id", "POS_btnUserAccessOK");
		click_On_Button("xpath", "//div[@class='pic picM']");
		Thread.sleep(1000);

		String a = driver.findElement(By.id("POS_BtnDiscLine")).getAttribute("style");

		System.out.println(a);
		if (a.equalsIgnoreCase("opacity: 0.5; display: block;")) {
			System.out.println("Discount Not given");
		} else {
			System.out.println("Discount is given");

		}

		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_AllowAccess");
		click_On_Button("id", "POS_CLOKUserAccessLogout");
		tab(0);
		click_On_Button("name", "VAPOS_IsDeletionAccess");
		click_On_Button("xpath", "//input[@name='VAPOS_IsDiscountAccess']");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Save24.png']");

		Thread.sleep(5000);

		boolean kam4 = driver.findElement(By.xpath("//input[@name='VAPOS_IsReturnAccess']")).isSelected();
		System.out.println(kam4);
		if (kam4) // if kam is true
		{
			driver.findElement(By.xpath("//input[@name='VAPOS_IsReturnAccess']")).click();
			driver.findElement(By.xpath("//img[@src='/Areas/VIS/Images/base/Save24.png']")).click();
			Thread.sleep(5000);
			tab(1);

		} else {

			tab(1);
		}

		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_GetMaster");
		Thread.sleep(8000);
		Area(Area);
		click_On_Button("id", "POS_AddReturnsRP");
		click_On_Button("id", "POS_divReturnWithoutInv");
		click_On_Button("id", "POS_btnCloseInfoAlert");
		click_On_Button("id", "POS_btnCloseReturnModuleNo");

		tab(0);

		boolean kam5 = driver.findElement(By.xpath("//input[@name='VAPOS_IsReturnAccess']")).isSelected();
		System.out.println(kam5);
		if (kam5) // if kam is true
		{

			tab(1);

		} else {
			driver.findElement(By.xpath("//input[@name='VAPOS_IsReturnAccess']")).click();
			driver.findElement(By.xpath("//img[@src='/Areas/VIS/Images/base/Save24.png']")).click();
			Thread.sleep(5000);
			tab(1);
		}
	}

	public void PowerUser() {
		tab(0);
		click_On_Button("", "");

	}

	// ****************************************************************************************************************************//
	public void ChangePassword() throws InterruptedException {
		// change password
		WebDriverWait wait = new WebDriverWait(driver, 60);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_DisplayUtilities")));
		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_ChangePassword");
		click_On_Button("id", "POS_OldChangePwd");
		click_On_Button("id", "POS_calc_1");
		click_On_Button("id", "POS_calc_2");
		click_On_Button("id", "POS_calc_3");
		click_On_Button("id", "POS_OldChangePwd");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_NewChangePwd")));
		Thread.sleep(3000);
		click_On_Button("id", "POS_NewChangePwd");
		click_On_Button("id", "POS_calc_1");
		click_On_Button("id", "POS_calc_2");
		click_On_Button("id", "POS_calc_3");
		click_On_Button("id", "POS_NewChangePwd");
		Thread.sleep(3000);
		click_On_Button("id", "POS_ConfirmChangePwd");
		click_On_Button("id", "POS_calc_1");
		click_On_Button("id", "POS_calc_2");
		click_On_Button("id", "POS_calc_3");
		click_On_Button("id", "POS_ConfirmChangePwd");
		Thread.sleep(2000);
		click_On_Button("id", "POS_btnChangePwdOK");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_btnCloseInfoAlert")));
		click_On_Button("id", "POS_btnCloseInfoAlert");
		click_On_Button("xpath", "//select[@id='POS_cmbTermUser']//option[@value='1005418']");
		driver.findElement(By.id("POS_txtPwd")).clear();
		click_On_Button("id", "POS_Login1");
		click_On_Button("id", "POS_Login2");
		click_On_Button("id", "POS_Login3");
		click_On_Button("id", "POS_btnLogin");
	}

	// *****************************************************************************************************************************//
	Screen s = new Screen();
//	Pattern p = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\Done.PNG");
//	Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\Cancel.PNG");
//	Pattern p2 = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\PrintHistoryButton.PNG");
//	Pattern p3 = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");


	Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\new\\Sikulli_Images\\Done.PNG");
	Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\new\\Sikulli_Images\\Cancel.PNG");
	Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\new\\Sikulli_Images\\PrintHistoryButton.PNG");
	Pattern p3 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\new\\Sikulli_Images\\AuthDone.PNG");

	public void ShowTax() throws InterruptedException, FindFailed {
		// Show tax and extra item
		WebDriverWait wait = new WebDriverWait(driver, 60);

		Area(Area);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_OrdNo")));
		String we3 = driver.findElement(By.id("POS_OrdNo")).getText();
		String OrderPrefix = "ANKITA";
		OrderNumber = OrderPrefix + we3;
		System.out.println(OrderNumber);
		click_On_Button("id", "POS_SearchCustomer");
		inputdata("id", "POS_txtCustSearch", "Select Utility");
		click_On_Button("id", "POS_BtnCustSearch");
		click_On_Button("xpath", "//div[@class='third-p']");

		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='pos-fontRightProduct'][text()='Tomato Soup']")));

		click_On_Button("xpath", "//div[@class='pos-fontRightProduct'][text()='Tomato Soup']");
		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_btnShowTax");
		click_On_Button("id", "btnCloseTax");
		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_AddExtraItem");
		inputdata("id", "txtPrdNameXtra", "Packet");
		click_On_Button("id", "POS_AddExtraItemCal");
		click_On_Button("id", "POS_calc_2");
		click_On_Button("id", "POS_calc_00");
		click_On_Button("id", "POS_AddExtraItemCal");
		Thread.sleep(3000);
		click_On_Button("id", "VAPOSTaxDiv1000019");
		click_On_Button("id", "POS_btnAdd");
		click_On_Button("id", "POS_Pay");
		click_On_Button("id", "VAPOS_POSDenominatorValue50");
		click_On_Button("id", "VAPOS_POSDenominatorValue50");
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
			s.click(p3);
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

		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_OrdNo")));
		String we4 = driver.findElement(By.id("POS_OrdNo")).getText();
		String OrderPrefix1 = "ANKITA";
		OrderNumber = OrderPrefix1 + we4;
		System.out.println(OrderNumber);
		click_On_Button("id", "POS_SearchCustomer");
		inputdata("id", "POS_txtCustSearch", "Select Utility");
		click_On_Button("id", "POS_BtnCustSearch");
		Thread.sleep(2000);
		click_On_Button("xpath", "//div[@class='third-p']");

		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_AddExtraItem");
		inputdata("id", "txtPrdNameXtra", "Packet");
		click_On_Button("id", "POS_AddExtraItemCal");
		click_On_Button("id", "POS_calc_2");
		click_On_Button("id", "POS_calc_00");
		click_On_Button("id", "POS_AddExtraItemCal");
		Thread.sleep(3000);
		click_On_Button("id", "VAPOSTaxDiv1000019");
		click_On_Button("id", "POS_btnAdd");
		click_On_Button("id", "POS_Pay");
		click_On_Button("id", "VAPOS_POSDenominatorValue50");

		s.click(p);
		// click_On_Button("id", "POS_PayDoneCash");

		String RemaningBalance1 = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
		if (RemaningBalance1.equalsIgnoreCase("Please Pay")) {
			click_On_Button("id", "POS_btnCloseInfoAlert");

		}

		Thread.sleep(5000);
		while (s.exists(p1) != null) {
			s.click(p1);
			Thread.sleep(2000);
		}

		String ReturnMultiCurrency1 = driver.findElement(By.id("POS_CLPopReturnAmountMcur")).getText();
		System.out.println("ReturnMultiCurrency" + ReturnMultiCurrency);
		if (ReturnMultiCurrency1.equalsIgnoreCase("Return Amount")) {
			s.click(p3);
		}

		Thread.sleep(5000);
		while (s.exists(p1) != null) {
			s.click(p1);
			Thread.sleep(2000);
		}

		String ReturnPopup1 = driver.findElement(By.id("POS_CLPopReturnAmount")).getText();

		if (ReturnPopup1.equalsIgnoreCase("Return Amount")) {
			click_On_Button("id", "btnCloseReturnAmt");
		}

		click_On_Button("xpath", "//div[@class='logout']");
		Screen s = new Screen();
//		Pattern p = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Start.PNG");
//		Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");
//		Pattern p2 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Stop.PNG");
	
		Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Start.PNG");
		Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Close.PNG");
		Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Stop.PNG");

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

//		Pattern p4 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\DeliveryDone.PNG");
//		Pattern p3 = new Pattern("D:\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");

		Pattern p4 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\DeliveryDone.PNG");
		Pattern p3 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Close.PNG");
		
		click_On_Button("id", "POSVA019_DeliveryLI");
		click_On_Button("xpath", "//a[@class='posva019-d-validate']");

		while (s.exists(p4) != null) {
			s.click(p4);
			Thread.sleep(200);
		}
		s.click(p3);

	}

	// *************************************************************************************************************************//

	public void HistoryRecord() throws InterruptedException, FindFailed {
		Area(Area);
		click_On_Button("id", "POS_DisplayUtilities");
		click_On_Button("id", "POS_HistoryRec");
		click_On_Button("id", "POS_SearchOrder");
		inputdata("id", "POS_OrderSearchH", OrderNumber);
		click_On_Button("id", "POS_SearchOrder");
		driver.findElement(By.id("POS_OrderSearchH")).clear();
		click_On_Button("id", "POS_SearchOrder");
		inputdata("id", "POS_CustomerSearchH", "Select Utility");
		click_On_Button("id", "POS_SearchOrder");
		inputdata("id", "POS_OrderSearchH", OrderNumber);
		click_On_Button("id", "POS_SearchOrder");
		click_On_Button("id", "hstRecordsTotals0");
		// click_On_Button("id", "POS_CLPrintHistory");
		s.click(p2);
		Thread.sleep(5000);
		while (s.exists(p1) != null) {
			s.click(p1);
			Thread.sleep(2000);
		}

	}
	// ****************************************************************************************************************************//

	public void searchUPCandAllSearch() throws InterruptedException, FindFailed {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		String we3 = driver.findElement(By.id("POS_OrdNo")).getText();
		String OrderPrefix = "Ankita";
		OrderNumber1 = OrderPrefix + we3;
		System.out.println(OrderNumber1);
		
		//click alert close cross button
		Thread.sleep(1000);
		click_On_Button("id", "POS_btnCloseInfoAlert");

		click_On_Button("id", "POS_SearchInputPanel");
		click_On_Button("id", "POS_SearchIP1");
		click_On_Button("id", "POS_SearchIP2");
		click_On_Button("id", "POS_SearchIP3");
		click_On_Button("id", "POS_SearchIP4");
		click_On_Button("id", "POS_SearchIP5");
		click_On_Button("id", "POS_SearchIP6");
		
		Thread.sleep(2000);
		click_On_Button("id", "POS_SearchInputPanel");

		click_On_Button("id", "POS_btnSearchProduct");
		click_On_Button("id", "POS_BtnProdSearch");
		Thread.sleep(2000);
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/row-2.png']");
		inputdata("id", "POS_SearchProductRes", "Lentil Soup");
		click_On_Button("id", "POS_BtnProdSearch");
		click_On_Button("xpath", "//div[@class='third-pp']");
		click_On_Button("xpath", "//div[@class='close-22']");
		// stock

		click_On_Button("id", "POS_HoldOrder");
		Thread.sleep(3000);
		click_On_Button("id", "POS_btnHoldCurrent");
		click_On_Button("id", "POS_HoldOrder");
		Thread.sleep(2000);
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/plus.png']");

		Screen s = new Screen();
//		Pattern p = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
//		Pattern p1 = new Pattern("D:\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\Cancel.PNG");

		Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\new\\Sikulli_Images\\AuthDone.PNG");
		Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\new\\Sikulli_Images\\Cancel.PNG");

		Thread.sleep(2000);

		click_On_Button("id", "POS_Pay");
		click_On_Button("id", "POS_Credit");
		Thread.sleep(1000);
		click_On_Button("id", "VAPOS_PayCardOptionMaster");
		Thread.sleep(2000);
		String ECR = driver.findElement(By.id("POS_ECRCredit")).getText();
		if (ECR.equalsIgnoreCase("ECR")) {
			click_On_Button("id", "POS_ECRCredit");
			wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_btnCloseInfoAlert")));
			Thread.sleep(10000);
			Thread.sleep(10000);
			click_On_Button("id", "POS_btnCloseInfoAlert");

		}
		click_On_Button("id", "POS_OkCredit");

		inputdata("id", "POS_txtTranscationNo", "657657");
		s.click(p);
		Thread.sleep(5000);
		while (s.exists(p1) != null) {
			s.click(p1);
			Thread.sleep(2000);

			click_On_Button("id", "POS_Print");
			inputdata("id", "POS_txtPrintInvoice", OrderNumber);
			click_On_Button("id", "POS_btnPrintInvoice");
			while (s.exists(p1) != null) {
				s.click(p1);
				Thread.sleep(2000);

			}
		}

	}

	public void homedeliveryexpectedDate() throws InterruptedException {
		click_On_Button("id", "POS_Logout");
		click_On_Button("xpath", "//div[@data-mode='POSVA019_H']");
		inputdata("id", "POS_txtCustSearch", "Select Utility");
		click_On_Button("id", "POS_BtnCustSearch");
		Thread.sleep(3000);
		click_On_Button("xpath", "//div[@class='third-p']");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='pos-fontRightProduct'][text()='Tomato Soup']")));
		click_On_Button("xpath", "//div[@class='pos-fontRightProduct'][text()='Tomato Soup']");
		click_On_Button("id", "POSVA019_DelSchdule");
		click_On_Button("id", "POSVA019_DeliverNow");

		LocalDate localDate = LocalDate.now();
		System.out.println(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));

		driver.findElement(By.id("POSVA019_ExpectedDate"))
				.sendKeys(DateTimeFormatter.ofPattern("MM/dd/yyy").format(localDate));

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm a");
		LocalDateTime now = LocalDateTime.now();
		System.out.println("dtf" + dtf.format(now));
		System.out.println("a" + dtf.format(now.plusMinutes(10)));
		String time = dtf.format(now.plusMinutes(10));
		System.out.println("Time" + time);
		Thread.sleep(3000);
		inputdata("xpath", "//input[@id='POSVA019_ExpectedTime']", time);

	}

	public void menu(String name) {
		click_On_Button("id", "vis_appMenu");

		inputdata("id", "vis_menuSearch", name);
		click_On_Button("linktext", name);
	}
}