package AddNewCustomer;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.CommandlineJava.SysProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Common_Class.Xls_Reader;

public class Common extends Common_Class.Action_Clas {

//	Xls_Reader reader = new Xls_Reader(
	//		"D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\Restaurant_Project.xlsx");
	
	
	Xls_Reader reader = new Xls_Reader("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Excel\\Restaurant_Project.xlsx");

	Random rand = new Random();
	int rand_int1 = rand.nextInt();
	int rand_int2 = rand.nextInt(100);
	String UserName;
	String POSTerminal;
	String CustName = null;
	String rName = null;
	String radress = null;
	String rmobile = null;
	String rcity = null;
	String remail = null;
	String cName = null;
	String cadress = null;
	String cmobile = null;
	String ccity = null;
	String cemail = null;
	String Cardnumber = null;
	String CustomerCreation = null;
	String CustomerName = null;
	String Email = null;
	String PhoneNumber = null;
	String CardNumber = null;
	String rNameEdit = null;
	String CityEdit = null;
	String MobileEdit = null;
	String rzipcode = null;
	String czipcode = null;

	public void common() throws Exception {
		All("Common");
	}

	public void All(String SheetName) throws AWTException, InterruptedException {
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

						// lOGIN Page
						login_Html(UserName, HTMLPassword);

						// LoginPagePOS
						loginPage(POSTerminal, Password, POSTerminalUser);

						// SelectArea
						Area();

						Customer();

					}
				}
			}
		}
	}

	public void Customer() throws InterruptedException, AWTException {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 200);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='header-left']//i[@id='POS_AddCustomer']")));
		click_On_Button("xpath", "//div[@class='header-left']//i[@id='POS_AddCustomer']");
		// creation customer with card number
		rName = "Auto" + rand_int1;
		inputdata("id", "POS_AddCustName", rName);
		radress = "Mohali";
		inputdata("id", "POS_AddCustAddress", radress);
		rcity = "Punjab";
		inputdata("id", "POS_CustCity", rcity);
		rzipcode = "2323" + rand_int2;
		inputdata("id", "POS_CustPostal", rzipcode);
		rmobile = "799344" + rand_int2;
		inputdata("id", "POS_CustMobile", rmobile);
		remail = "Auto" + rand_int1 + "@gmail.com";
		inputdata("id", "POS_CustEmail", remail);
		Cardnumber = "38999" + rand_int1;
		inputdata("id", "POS_CustCardNo", Cardnumber);
		click_On_Button("id", "POS_CLAddCustomer");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_btnCloseInfoAlert")));
		click_On_Button("id", "POS_btnCloseInfoAlert");

		// creation customer without card number
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='header-left']//i[@id='POS_AddCustomer']")));
		click_On_Button("xpath", "//div[@class='header-left']//i[@id='POS_AddCustomer']");
		cName = "Automatic" + rand_int1;
		inputdata("id", "POS_AddCustName", cName);
		cadress = "Chandigarh";
		inputdata("id", "POS_AddCustAddress", cadress);
		ccity = "Haryana";
		inputdata("id", "POS_CustCity", ccity);
		cmobile = "889345" + rand_int2;
		czipcode = "2323" + rand_int2;
		inputdata("id", "POS_CustPostal", czipcode);
		inputdata("id", "POS_CustMobile", cmobile);
		cemail = "Automatic" + rand_int1 + "@gmail.com";
		inputdata("id", "POS_CustEmail", cemail);
		click_On_Button("id", "POS_CLAddCustomer");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_btnCloseInfoAlert")));
		click_On_Button("id", "POS_btnCloseInfoAlert");

		// search customer
		click_On_Button("id", "POS_SearchCustomer");
		click_On_Button("id", "POS_BtnCustSearch");
		// CustomerName
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		inputdata("id", "POS_txtCustSearch", rName);
		click_On_Button("id", "POS_BtnCustSearch");
		// Email search
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		driver.findElement(By.id("POS_txtCustSearch")).clear();
		inputdata("id", "POS_txtCustSearch", remail);
		click_On_Button("id", "POS_BtnCustSearch");
		// phone number search
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		driver.findElement(By.id("POS_txtCustSearch")).clear();
		inputdata("id", "POS_txtCustSearch", rmobile);
		click_On_Button("id", "POS_BtnCustSearch");
		// Cardnumber
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		driver.findElement(By.id("POS_txtCustSearch")).clear();
		inputdata("id", "POS_txtCustSearch", Cardnumber);
		click_On_Button("id", "POS_BtnCustSearch");

		// 2nd customer search

		// CustomerName
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		driver.findElement(By.id("POS_txtCustSearch")).clear();
		inputdata("id", "POS_txtCustSearch", cName);
		click_On_Button("id", "POS_BtnCustSearch");
		// Email search
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		driver.findElement(By.id("POS_txtCustSearch")).clear();
		inputdata("id", "POS_txtCustSearch", cemail);
		click_On_Button("id", "POS_BtnCustSearch");
		// phone number search
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		driver.findElement(By.id("POS_txtCustSearch")).clear();
		inputdata("id", "POS_txtCustSearch", cmobile);
		click_On_Button("id", "POS_BtnCustSearch");
		click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/rows.png']");
		click_On_Button("id", "POS_BtnCustSearch");

		
		System.out.println("**Create Online Customer**");

		tab(0);

		driver.findElements(By.xpath("//a[@title='Close Window']")).get(1).click();
		menu("Customer Master");
		inputdata("xpath", "//input[@placeholder='Search'][@class='vis-apanel-search ui-autocomplete-input']", rName);
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
		tab(1);
		
		//edit customer
		click_On_Button("xpath", "//img[@style='margin-top: -5px; cursor: pointer;']");
		driver.findElement(By.id("CUST_Name")).clear();
		rNameEdit = "MaC" + rand_int2;
		inputdata("id", "CUST_Name", rNameEdit);
		driver.findElement(By.id("CUST_Address")).clear();
		CityEdit = "Shimla" + rand_int2;
		inputdata("id", "CUST_Address", CityEdit);
		driver.findElement(By.id("CUST_Mobile")).clear();
		MobileEdit = "95435445" + rand_int2;
		inputdata("id", "CUST_Mobile", MobileEdit);
		click_On_Button("id", "CST_btnOK"); 
		
//		click_On_Button("id", "CST_btnCancel");
//		Thread.sleep(2000);

		tab(0);

		inputdata("xpath", "//input[@placeholder='Search'][@class='vis-apanel-search ui-autocomplete-input']", rName);
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");

		inputdata("xpath", "//input[@placeholder='Search'][@class='vis-apanel-search ui-autocomplete-input']",
				rNameEdit);
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Sear.png']");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Find24.png']");
		click_On_Button("xpath", "//select[@id='drpColumn_2']//option[@value='Created']");
		click_On_Button("id", "chkDynamic_2");
		Thread.sleep(3000);
		click_On_Button("id", "btnOk_2");

		//Create new customer from back end
		driver.findElement(By.xpath("//img[@src='/Areas/VIS/Images/base/New24.png']")).click();
		click_On_Button("xpath", "//img[@title='Grid tOggle']");
		CustName = "Backend" + rand_int1;
		inputdata("xpath", "//input[@class='vis-gc-vpanel-table-mandatory'][@name='Name']", CustName);
		driver.findElement(By.xpath("//input[@name='SO_CreditLimit'][@class='vis-gc-vpanel-table-mandatory']")).clear();
		inputdata("xpath", "//input[@name='SO_CreditLimit'][@class='vis-gc-vpanel-table-mandatory']", "1000");
		System.out.println("Click on save button");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Save24.png']");
		System.out.println("Clicked on save button");
		click_On_Button("xpath", "//h2[text()='Location']");
		System.out.println("Moved to Location");
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//img[@src='/Areas/VIS/Images/base/Multi16.png']")));
		Thread.sleep(2000);
		System.out.println("Click on Multi16");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Multi16.png']");
		System.out.println("Clicked on Multi16");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Location20.png']");
		System.out.println("Click on Location");
		driver.findElement(By.id("txtCountry_3")).clear();
		inputdata("id", "txtCountry_3", "India");
		click_On_Button("linktext", "India");
		click_On_Button("id", "btnOk_3");
		click_On_Button("xpath", "//img[@src='/Areas/VIS/Images/base/Save24.png']");
		Thread.sleep(2000);

		tab(1);
		
		System.out.println("Check tab 1");
		//click_On_Button("id", "POS_btnCloseInfoAlert");
		click_On_Button("id", "CST_btnCancel");
		System.out.println("Yes Working Check tab 1");
		click_On_Button("id", "POS_SearchCustomer");
		inputdata("id", "POS_txtCustSearch", CustName);
		//click_On_Button("id", "POS_BtnCustSearch");
		// click_On_Button("id", "POS_btnCloseInfoAlert");
		 click_On_Button("id", "POS_CLCheckOnline");
		// click_On_Button("xpath", "//div[@class='third-p']");

		System.out.println("**Successfully Created Online C//*[@id=\"CST_btnCancel\"]ustomer**");
		/// online customer completed

	}
	// ******************************************************************************************************************************//

	// Select Utility

	// ******************************************************************************************************************************//

	// LounchApp
	public void lounchApp(String link) throws IOException {
		openbrowser("Chrome");
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	// ******************************************************************************************************************************//
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
				driver.get("http://restposbeta.v.local/");
				// driver.get("http://restpossandbox.v.local/");

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
				driver.get("http://restposbeta.v.local/");
				// driver.get("http://restpossandbox.v.local/");
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
			System.out.println("Login page method completed");
			Thread.sleep(2000);
			click_On_Button("xpath", "//*[@id=\"POS_btnCloseInfoAlert\"]");
			System.out.println("Cross button is closed");
		}
	}

	// ******************************************************************************************************************************//

	// Area
	public void Area() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_E']")));
		System.out.println("This area 1");
		click_On_Button("xpath", "//div[@data-mode='POSVA019_Q']");
		System.out.println("This area 2");
	}

	// ******************************************************************************************************************************//

	// Menu
	public void menu(String name) {
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		click_On_Button("id", "vis_appMenu");
		inputdata("id", "vis_menuSearch", name);
		click_On_Button("linktext", name);
	}

	// ****************************************************************************************************************************//

}
