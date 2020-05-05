package DineIn;

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


public class DineInInvoices extends Common_Class.Action_Clas {
	
	
	
	Common_Class.Xls_Reader reader = 
			//new Common_Class.Xls_Reader("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\src/test/java\\Result\\Restaurant_Project.xlsx");
			new Common_Class.Xls_Reader("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Excel\\Restaurant_Project.xlsx");

	
	Random rand = new Random();
	int rand_int2 = rand.nextInt();
	String nk = null;
	String rk = null;
	String kk = null;
	float f1;
	float f3;
	float f2;
	float f4;
	float f6;
	String card;
	String RenameTable;
	String customername;
	String Cash;
	String dicountpercentage;
	String discountamount;
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
	String DriverName;
	String duebillpayment;
	String driverin;
	String modifier;
	String modifierproduct;
	String NumberOfSeat;
	String TableNumber;
	String SelectArea;
	String SeatWise;
	String Manual;
	String AdvancePayment;
	String Regular;
	String SeatWisePayment;
	String ManualPayment;
	String LO;
	String Area;
	String paro;
	String course;
	String cate;
	int ded;
	String NumberOfSeatonnewTable;
	int P;
	String pass;
	String SelectSeat;
	int ded3;
	String NoOfchair;
	int ded4;
	String Chairs;
	String SelectChairtoPaySeatWise;
	String Minus;
	int ded5;
	String preBill;
	String PreBillSeatWise;
	String PreBillManual;
	String discountPerTotalamount;
	String discountPerTotalpercentage;
    String PreBillDiscount;
    String PrebillDiscountAmount;
    String PrebillDiscountPercentage;
    String PreBill;
    String DiscountGiven;
    String onCredit;
	String CreditAmount;
	 String OnCreditDenominaion;
	 String OnCreditKeyPad;
	 String PreBillVoid;
	 String PreBillTotalVoid;
	 String DeletePrebill;
	 String RegularPayment;
	 String Seatwisepayment;
	 String Manualpayment;
	 String SelectSeatForRemaningOrder;
		String quickpay;
	 public void Dinein() throws Exception {
			DineIn("DineIn");
		}
	 
	public void DineIn(String SheetName) throws Exception{
		
	int rowCount = reader.getRowCount(SheetName);
	System.out.println("Row Count : "+rowCount);
	int rowCount2 = reader.getRowCount("DataDineIn");
	System.out.println("Row Count 2 : "+rowCount2);
	for (int i = 2; i <= rowCount; i++) {
		String runOn = reader.getCellData(SheetName, "RUN", i);
		String ref1 = reader.getCellData(SheetName, "Refrence Id", i);
		System.out.println("Refrence Id of DineIn Sheet : "+ref1);
		Thread.sleep(2000);
		String des = reader.getCellData(SheetName, "DescriptiOFF", i);
		System.out.println("This is description : "+des);
		String param1 = reader.getCellData(SheetName, "Expected Total Price", i);
		System.out.println("Value of Expec total price : "+param1);
		if (runOn.equals("ON")) {
			for (int j = 2; j <= rowCount2; j++) {
				String ref = reader.getCellData("DataDineIn", "Refrence Id", j);
				System.out.println("Refrence Id for DataDineIn sheet : "+ref);
				if (ref1.equalsIgnoreCase(ref)) {
					
					// HtmlLinkUserName
					UserName = reader.getCellData("DataDineIn", "UserName", j);
					System.out.println(UserName);
	
					// HtmlLink Password
					String HTMLPassword = reader.getCellData("DataDineIn", "HtmlPassword", j);
					
					// Pos Terminal Selected
					POSTerminal = reader.getCellData("DataDineIn", "Pos Terminal", j);
					
					
					// POS Terminal User
					String POSTerminalUser = reader.getCellData("DataDineIn", "Pos Temrinal User", j);
					
					// Password
					String Password = reader.getCellData("DataDineIn", "Password", j);
					System.out.println("Select Password : "+Password);
					if (Password.equals("NA") == false) {
						double dedIndex = Double.parseDouble(Password);
						P = (int) dedIndex;
						pass = String.valueOf(P);
					}
					
					// select document type
					Area = reader.getCellData("DataDineIn", "Area", j);
					
					// select course
					course = reader.getCellData("DataDineIn", "Course", j);
					// select category
					cate = reader.getCellData("DataDineIn", "Category", j);
					// select product
					paro = reader.getCellData("DataDineIn", "PRODUCT", j);
					// cash payment
					Cash = reader.getCellData("DataDineIn", "Cash", j);
					System.out.println("Select cash : "+Cash);
					// card payment
					card = reader.getCellData("DataDineIn", "Card", j);
					// MultiCard Payment
					multiCard = reader.getCellData("DataDineIn", "CardMultiCurrency", j);
					// Customer Name
					customername = reader.getCellData("DataDineIn", "CustomerName", j);
					//Decide wheater to give discount or not
					DiscountGiven = reader.getCellData("DataDineIn", "Discount Given", j);
					// Discount Percentage
					dicountpercentage = reader.getCellData("DataDineIn", "Discount Percentage", j);
					// Discount Product
					DiscountProduct = reader.getCellData("DataDineIn", "Discounted Product", j);
					// Discount perTotal
					discountPerTotal = reader.getCellData("DataDineIn", "Discount Total", j);
					
					discountamount =reader.getCellData("DataDineIn", "Discount Amount", j);
					//Total discount amount
					discountPerTotalamount = reader.getCellData("DataDineIn", "Total Discount Amount", j);
					//total discount percentage
					discountPerTotalpercentage = reader.getCellData("DataDineIn", "Total Discount Percentage", j);
				
					//It will decide wheather to give prebill discount or not
					PreBillDiscount = reader.getCellData("DataDineIn", "Pre Bill Discount", j);
					//prebill discount in percentage
					PrebillDiscountPercentage = reader.getCellData("DataDineIn", "Discount on PreBill (Percentage)", j);
					//prebilldiscount in amount
					PrebillDiscountAmount = reader.getCellData("DataDineIn", "Discount on PreBill (Amount)", j);
					// Void Line Wise
					Void = reader.getCellData("DataDineIn", "Void", j);
					PreBillVoid= reader.getCellData("DataDineIn", "Prebill Void", j);
					// Full Order Void
					TotalVoid = reader.getCellData("DataDineIn", "Full OrderVoid", j);
					PreBillTotalVoid= reader.getCellData("DataDineIn", "Prebill TotalOrderVoid", j);
					DeletePrebill= reader.getCellData("DataDineIn", "Delete PreBill", j);
					// MultiCash
					MultiCash = reader.getCellData("DataDineIn", "CashMultiDenomination", j);
					// Currency Type
					CurrencyType = reader.getCellData("DataDineIn", "CashMulti Curency", j);
					// Due Bill Payment
					duebillpayment = reader.getCellData("DataDineIn", "Due Bill Payment", j);
					// This is for is user want to use modifier
					modifier = reader.getCellData("DataDineIn", "Modifier", j);
					// This will define the modifier product
					modifierproduct = reader.getCellData("DataDineIn", "Modifier Product", j);
					// This is to create table ,how many seats does a user
					// want on a table
					NumberOfSeat = reader.getCellData("DataDineIn", "Number Of Seat on new Table", j);
					double dedIndex2 = Double.parseDouble(NumberOfSeat);
					ded = (int) dedIndex2;
					NumberOfSeatonnewTable = String.valueOf(ded);
					// This is to select the area in dine in
					SelectArea = reader.getCellData("DataDineIn", "Select Area in Dine in", j);
					// This is to select table as seat wise
					SeatWise = reader.getCellData("DataDineIn", "Order Created with Seat Wise", j);
					// This is to select table as manual
					Manual = reader.getCellData("DataDineIn", "Order Created With Manual", j);
					// This is if user make payment through Dine in
					AdvancePayment = reader.getCellData("DataDineIn", "Advance Payment", j);
					System.out.println("AdvancePayment"+AdvancePayment);
					// This is for Dine in manual payment method
					ManualPayment = reader.getCellData("DataDineIn", "ManaulPayment", j);
					// This is for Dine in Seat wise payment
					SeatWisePayment = reader.getCellData("DataDineIn", "Seat Wise Payment", j);
					// This is for Regular payment
					Regular = reader.getCellData("DataDineIn", "Regular Payment", j);
					System.out.println("Regular Payment : "+Regular);
					// The LO indicated Logout from dine Area
					LO = reader.getCellData("DataDineIn", "logout", j);
					// This will Select Other Chairs fro order
					SelectSeat = reader.getCellData("DataDineIn", "Select Other Chair for Seat Wise Order", j);
					/*
					 * if(SelectSeat.equals("NA") == false) { double
					 * dedIndex3 = Double.parseDouble(SelectSeat); ded3 =
					 * (int) dedIndex3; }
					 */
					// This is for how many chairs does a user want to
					// create an order
					Chairs = reader.getCellData("DataDineIn", "Number Of Seat User require for  Creating Order", j);
					if (Chairs.equals("NA") == false) {
						double dedIndex4 = Double.parseDouble(Chairs);
						ded4 = (int) dedIndex4;
					}
					// This will Select chairs at Seat Wise , how many seats
					// user want to select to make payment
					SelectChairtoPaySeatWise = reader.getCellData("DataDineIn",
							"Select Chair for payment Seat Wise", j);
					// This will select how many quantity user want to pay
					// on manual payment
					Minus = reader.getCellData("DataDineIn", "Select Quantity on Manual Payment", j);
					if (Minus.equals("NA") == false) {
						double dedIndex5 = Double.parseDouble(Minus);
						ded5 = (int) dedIndex5;
					}

					// If user want to make pre bill as regular
					preBill = reader.getCellData("DataDineIn", "PreBill (Regular)", j);
					PreBillSeatWise = reader.getCellData("DataDineIn", "PreBill (SeatWise)", j);
					PreBillManual = reader.getCellData("DataDineIn", "PreBill(Manaul)", j);
                    PreBill = reader.getCellData("DataDineIn", "PreBill", j);
                    onCredit = reader.getCellData("DataDineIn", "On Credit", j);
					CreditAmount = reader.getCellData("DataDineIn", "Credit Amount", j);
					RegularPayment= reader.getCellData("DataDineIn", "Select remianing seat for payment as regular", j);
					Seatwisepayment =  reader.getCellData("DataDineIn", "Select remianing seat for payment as seat wise", j);
					Manualpayment= reader.getCellData("DataDineIn", "Select remianing seat for payment as manual", j);
					SelectSeatForRemaningOrder= reader.getCellData("DataDineIn", "Select seat for ramaning payment", j);
					quickpay = reader.getCellData("DataDineIn", "QuickPayment", j);
					WebDriverWait wait = new WebDriverWait(driver, 30);
					
					
					//***********************************************************************************************//
					//CAlling Mathod
					
					
					// lOGIN Page
					login_Html(UserName, HTMLPassword);
					
					// LoginPagePOS
					loginPage(POSTerminal, pass, POSTerminalUser);
					
					// SelectArea
					Area();
					
					// select area create table and select table
					SelectTable(SelectArea, ded4);
					// Save OrderNumber
					OrderNumberInfo();
					// Add Product
					String[] arrSplit = paro.split(",");
					productSelection(course, cate, arrSplit);
					
					//Seat Wise
					String[] arrSplit1 = SelectSeat.split(",");
					seatwieseorder(arrSplit1);
						
					  AddModifier(modifierproduct);
					String[] arrSplit3 = dicountpercentage.split(",");
					Dicountper(DiscountProduct, arrSplit3);
					
					// Discount Amount
					String[] arrSplit4 = discountamount.split(",");
					  Discountamount(DiscountProduct, arrSplit4);
					   
					   
					
						if(AdvancePayment.equalsIgnoreCase("NA")){
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@id='POS_Tot']//input")));
							nk = driver.findElement(By.xpath("//h3[@id='POS_Tot']//input")).getAttribute("value");
							f1 = Float.parseFloat(nk);
		
							click_On_Button("id", "POS_SendToKitchen");
						
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
							Thread.sleep(3000);
							click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
							}
						
						Void(); 
						
						
						String[] arrSplit2 = SelectChairtoPaySeatWise.split(",");
						System.out.println("arrSplit2 wise : "+arrSplit2);
						String[] arrSplitPer = PrebillDiscountPercentage.split(",");
						System.out.println("arrSplitPer wise : "+arrSplitPer);
						String[] arrSplitAmount = PrebillDiscountAmount.split(",");
						System.out.println("arrSplitAmount wise : "+arrSplitAmount);
						PreBill(arrSplit2, arrSplitPer, arrSplitAmount );
						String[] arrSplit61 = SelectSeatForRemaningOrder.split(",");
					
					
						// total discount percentage
						String[] arrSplit5 = discountPerTotalpercentage.split(",");
						DiscountPerTotal(arrSplit2,arrSplit5 );

						// total discount amoount
						String[] arrSplit6 = discountPerTotalamount.split(",");
						DiscountAmountTotal(arrSplit2, arrSplit6 );
						
						
						QuickPay();
							//PaymentMethod(arrSplit2);

							// DeleteTable
							
							DeleteTable(arrSplit61);
							// logout
							Logout();
							// kitchen
							kitchen();
							// delivery
							delivery();
							// duebillpayment
							DueBillPayment();
							
				}
			}
			System.out.println("Value on F1 : "+f1);
			System.out.println("Value on F2 : "+f2);
			f2 = Float.parseFloat(param1);
			System.out.println("Value on F2 : "+f2);
			//
			if (f1 == f2) {
				reader.setCellData(SheetName, "Status", i, "Passed");
				reader.setCellData(SheetName, "Actual Amount", i, nk);
				reader.setCellData(SheetName, "OrderNumber", i, orderNumber);
				System.out.println(orderNumber);
				reader.setCellData(SheetName, "Table Name", i, TableNumber);

			} else {
				reader.setCellData(SheetName, "Status", i, "Failed");
				reader.setCellData(SheetName, "Actual Amount", i, nk);
				reader.setCellData(SheetName, "OrderNumber", i, orderNumber);

			}
		}
	}
	}
				
			
					
					
		
	//******************************************************************************************************************************//
	
					
					
	//LounchApp
	public void lounchApp(String link) throws IOException {
		openbrowser("Chrome");
		driver.get(link);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
	}
    //******************************************************************************************************************************//
	
	//HTML login and Open Pos Link
	public void login_Html(String uname, String pwd) throws AWTException, InterruptedException {
		if (UserName.equals("NA") == false) {
			inputdata("id", "loginName", uname);
			inputdata("id", "txtPwd", pwd);
			click_On_Button("id", "btnLogin1");
			click_On_Button("id", "vis_appMenu");
			inputdata("id", "vis_menuSearch", "POS Terminal");
			click_On_Button("id", "ui-id-2");
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='/Areas/VIS/Images/base/Multi16.png']")));
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
			}

		}
	}
	
	//******************************************************************************************************************************//
	
	// Login to POS
		public void loginPage(String terminal, String pwd, String pOSTerminalUser)
				throws AWTException, InterruptedException {
			if (POSTerminal.equals("NA") == false) {
				inputdata("id", "POS_cmbTerm", terminal);
				click_On_Button("xpath", "//select[@id='POS_cmbTermUser']//option[@value=" + pOSTerminalUser + "]");
				driver.findElement(By.id("POS_txtPwd")).clear();
				inputdata("id", "POS_txtPwd", pwd);
				click_On_Button("id", "POS_btnLogin");
			}
			//click_On_Button("id", "POS_btnCloseInfoAlert");
		}
		
		//******************************************************************************************************************************//
		
		//Area
		public void Area() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-mode='POSVA019_E']")));
			click_On_Button("xpath", "//div[@data-mode='POSVA019_E']");
		}
		
		//******************************************************************************************************************************//
		
		//Select table
		public void SelectTable(String Area, int NoOfChair) throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			// Area selection in dine in
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(text(),'" + Area + "') ]")));
			click_On_Button("xpath", "//li[contains(text(),'" + Area + "') ]");
			Thread.sleep(1000);
			// create table in dine in
			click_On_Button("id", "POSVA019_btnAddTableGS");
			// give random number to new table
			int rand_int1 = rand.nextInt();
			TableNumber = "Ankita" + rand_int1;
			inputdata("id", "POSVA019_txtPopTableNo", TableNumber);
			inputdata("id", "POSVA019_txtPopTableSeats", NumberOfSeatonnewTable);
			click_On_Button("id", "POSVA019_spnPopTableOK");
			// if table name already exsist
			String AlreadyAvailable = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
			if (AlreadyAvailable.equalsIgnoreCase("Table No Already Exists")) {
				click_On_Button("id", "POS_btnCloseInfoAlert");
				click_On_Button("id", "POSVA019_spnPopTableCancel");
				click_On_Button("id", "POSVA019_btnAddTableGS");
				TableNumber = "Ankita" + rand_int2;
				inputdata("id", "POSVA019_txtPopTableNo", TableNumber);
				inputdata("id", "POSVA019_txtPopTableSeats", NumberOfSeatonnewTable);
				click_On_Button("id", "POSVA019_spnPopTableOK");
			}
			
			// click on the created table
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
			Thread.sleep(3000);
			click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");

			// seat wise selection of seats
			if (SeatWise.equals("NA") == false) {
				Thread.sleep(5000);
				click_On_Button("xpath", "//span[@id='VA019_lblspnPopSeatNo" + NoOfChair + "']");
				click_On_Button("id", "POSVA019_btnSeatsPopupOK");
			}

			// Manual
			if (Manual.equals("NA") == false) {
				Thread.sleep(3000);
				click_On_Button("id", "POSVA019_spnSeatsPopupManual");

			}
		}
		
		//******************************************************************************************************************************//
		//Select Customer Name on POS
		public void selectcustomer(String CustomerName) throws InterruptedException {
			Thread.sleep(2000);
			click_On_Button("id", "POS_SearchCustomer");
			inputdata("id", "POS_txtCustSearch", CustomerName);
			click_On_Button("id", "POS_BtnCustSearch");
			Thread.sleep(2000);
			click_On_Button("xpath", "//div[@class='third-p']");
			System.out.println("Select Customer Method");
		}
		
		//******************************************************************************************************************************//
		//PRODUCT SELECTION
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
			System.out.println("Product selection method");
		}

		//******************************************************************************************************************************//
		

		//Logout
		public void logout() throws InterruptedException {
			WebDriverWait wait = new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_CLLogout")));
			Thread.sleep(2000);
			click_On_Button("id", "POS_CLLogout");
		}
		//******************************************************************************************************************************//
		
		public void kitchen() throws InterruptedException, FindFailed {
			 Screen s = new Screen();
//			  Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Start.PNG");
//			  Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");
//			  Pattern p2 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Stop.PNG");
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
			
		}
		//******************************************************************************************************************************//
		
		 // Delivery
		public void delivery() throws InterruptedException, Exception {
			 Screen s = new Screen();
//			  Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\DeliveryDone.PNG");
//			  Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Close.PNG");
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
		//******************************************************************************************************************************//
		
		//Orderlog
		public void orderlog(String Area) throws InterruptedException {

			Thread.sleep(5000);
			click_On_Button("id", "POSVA019_OrdersLog");
			Thread.sleep(3000);
			inputdata("id", "POS_OrderLogtxtInvoice", orderNumber);
			Thread.sleep(2000);
			click_On_Button("id", "POS_OrdLogSearchOrder");
			Thread.sleep(1000);
			click_On_Button("id", "POS_btnCloseOrdersLog");
	}
		//******************************************************************************************************************************//	
		
		//OrderNumber
		public void OrderNumberInfo() throws InterruptedException {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("POS_OrdNo")));
			String we3 = driver.findElement(By.id("POS_OrdNo")).getText();
			String OrderPrefix = "ANKITA";
			orderNumber = OrderPrefix + we3;
		}

		//******************************************************************************************************************************//	
		//If user has select order seat wise 
		public void seatwieseorder(String a[]) throws InterruptedException {
			if (SeatWise.equals("NA") == false) {

				for (int i = 0; i < a.length; i++) {
					Thread.sleep(3000);
					click_On_Button("xpath", "//div[@id='" + a[i].toString() + "']");
					String[] arrSplit = paro.split(",");
					productSelection(course, cate, arrSplit);
				}
			}
		}
		//******************************************************************************************************************************//	
		
		
		public void PaymentMethod(String a[]) throws InterruptedException, Exception {
			
			System.out.println("prebill is  : "+PreBill);
			System.out.println("Total Void is : "+TotalVoid);

			if(PreBill.equalsIgnoreCase("NO")&& TotalVoid.equalsIgnoreCase("NA")){
			Thread.sleep(2000);	
			System.out.println("Is it Working");
			click_On_Button("id", "POS_Pay");
			System.out.println("Working");
			
			
			if(discountPerTotalpercentage.equalsIgnoreCase("Na")&&(discountPerTotalamount.equalsIgnoreCase("NA"))){
			if (Regular.equals("NA") == false) {
				Thread.sleep(1000);	
				click_On_Button("id", "POSVA019_btnPayReg");
			}
			
			if (SeatWisePayment.equals("NA") == false) {
				click_On_Button("id", "VA019_CLPaySeatWise");
				for (int i = 0; i < a.length; i++) {
					click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
				}
				click_On_Button("id", "VAPOS_CLChkout");
			}
			
			if (ManualPayment.equals("NA") == false) {
				// manual
				Thread.sleep(2000);
				click_On_Button("id", "VA019_CLPayManual");
				Thread.sleep(2000);
				for (int i = 1; i <= ded5; i++) {
					click_On_Button("xpath", "//div[@class='posva019-qtyIcon minusIcon']");
				}
				click_On_Button("id", "VAPOS_btnChkOut");
			
			}
			}
			
				if (Cash.equals("NA") == false) {
					String[] arrSplit = Cash.split(",");
					cash(arrSplit);
					
				}
				
				if (MultiCash.equals("NA") == false) {
				String[] arrSplit1 = MultiCash.split(",");
				multiCash(arrSplit1);
				}	
				if (card.equals("NA") == false) {
					cardPay(card);
				}
				if (multiCard.equals("NA") == false) {
					CardMulti(multiCard);
				}
			}
		}
		
//******************************************************************************************************************************//	
public void cash(String a[]) throws InterruptedException, Exception {
	
	 Screen s = new Screen();
//		Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Done.PNG");
//		 Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG"); 
		 Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Done.PNG");
		 Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG"); 
		 
		// Pattern p2 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
		 Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\Sikulli_Images\\AuthDone.PNG");

	if (Cash.equals("NA") == false) {
		Thread.sleep(2000);
		
		if(DeletePrebill.equalsIgnoreCase("Y")){

			if (Regular.equals("NA") == false) {
				Thread.sleep(1000);	
				click_On_Button("id", "POSVA019_btnPayReg");
			}
			
			if (SeatWisePayment.equals("NA") == false) {
				click_On_Button("id", "VA019_CLPaySeatWise");
				for (int i = 0; i < a.length; i++) {
					click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
				}
				click_On_Button("id", "VAPOS_CLChkout");
			}
			
			if (ManualPayment.equals("NA") == false) {
				// manual
				Thread.sleep(2000);
				click_On_Button("id", "VA019_CLPayManual");
				Thread.sleep(2000);
				for (int i = 1; i <= ded5; i++) {
					click_On_Button("xpath", "//div[@class='posva019-qtyIcon minusIcon']");
				}
				click_On_Button("id", "VAPOS_btnChkOut");
			
			}
		}
		click_On_Button("id", "POS_Cash");
		for (int i = 0; i < a.length; i++) {

			
			Thread.sleep(2000);
			click_On_Button("id", "VAPOS_POSDenominatorValue" + a[i].toString() + "");
		}
	//	click_On_Button("id", "POS_PayDoneCash");
		 s.click(p);
		Thread.sleep(2000);
	
		String RemaningBalance = driver.findElement(By.id("POS_lblErrorInfoAlert")).getText();
		if (RemaningBalance.equalsIgnoreCase("Please Pay")) {
			// Scrn.click(IMG3);
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
			Thread.sleep(2000);
		
			click_On_Button("id", "btnCloseReturnAmt");
		}

		String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
		{
			if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
				Thread.sleep(2000);
				click_On_Button("id", "POSVA019_DueBillPaymentClose");
			}
		}

	}
}


//******************************************************************************************************************************//	
public void multiCash(String b[]) throws InterruptedException, FindFailed {
	 Screen s = new Screen();
//		Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Done.PNG");
//		 Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
	 Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Done.PNG");
	 Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");	
	 
		 //Pattern p2 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
		 Pattern p2 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\Sikulli_Images\\AuthDone.PNG");

	if (MultiCash.equals("NA") == false) {

		click_On_Button("id", "POS_ChangeCurrencyP");
		Thread.sleep(2000);
		click_On_Button("xpath", CurrencyType);
		Thread.sleep(2000);
		for (int i = 0; i < b.length; i++) {
			Thread.sleep(2000);
			click_On_Button("id", "VAPOS_POSDenominatorValue" + b[i].toString() + "");
		}
		 s.click(p);
		//click_On_Button("id", "POS_PayDoneCash");
	}

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

	String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
	{
		if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
			click_On_Button("id", "POSVA019_DueBillPaymentClose");
		}
	}
}
String ECR =null;
//******************************************************************************************************************************//	
public void cardPay(String cardNo) throws InterruptedException, FindFailed {
	WebDriverWait wait = new WebDriverWait(driver, 60);
	
	 Screen s = new Screen();
	 // Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
	  Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\Sikulli Images\\AuthDone.PNG");
	 
	  
	 // Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
	  Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli Images\\Cancel.PNG");

	 if (card.equals("NA") == false) {
		click_On_Button("id", "POS_Pay");
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
			s.click(p);
			Thread.sleep(5000);
			 while ( s.exists(p1) != null){
			      s.click(p1);
			    Thread.sleep(2000);
			   }
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
//******************************************************************************************************************************//	
public void CardMulti(String cardNo1) throws InterruptedException, FindFailed {
	WebDriverWait wait = new WebDriverWait(driver, 60);
	Screen s = new Screen();
	 // Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
	Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
	
	// Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Retail_DynamicSand\\Sikulli Images\\AuthDone.PNG");
	 Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Retail\\Sikulli_Images\\AuthDone.PNG");

	if (multiCard.equals("NA") == false) {
		Thread.sleep(2000);
		click_On_Button("id", "POS_Credit");
		Thread.sleep(3000);
		click_On_Button("id", "POS_ChangeCurrencyP");
		Thread.sleep(2000);
		click_On_Button("xpath", CurrencyType);
		Thread.sleep(2000);
		click_On_Button("xpath", "//li[contains(text(),'" + cardNo1 + "')]");
		

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
		if (Popup.equalsIgnoreCase("Auth. Code")) {
			inputdata("id", "POS_txtTranscationNo", "56575");
			s.click(p);
			Thread.sleep(5000);
			 while ( s.exists(p1) != null){
			      s.click(p1);
			    Thread.sleep(2000);
			   }
		}
		Thread.sleep(2000);
		String DueBillPayment = driver.findElement(By.id("POSVA019_CLDueBillPayment")).getText();
		{
			if (DueBillPayment.equalsIgnoreCase("Due Bill Payment")) {
				click_On_Button("id", "POSVA019_DueBillPaymentClose");
			}
		}
	}
}

//******************************************************************************************************************************//	
//delete table if user is jump to product section they it wil make payment


public void DeleteTable(String a[]) throws Exception{
	
	if (Regular.equals("NA") == false) {
	WebDriverWait wait = new WebDriverWait(driver, 60);
  	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
   	Thread.sleep(2000);
	click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
	Thread.sleep(2000);
	click_On_Button("id", "POSVA019_CLClearTable");
	Thread.sleep(1000);
	click_On_Button("id", "POSVA019_btnDeleteTableGS");
	System.out.println("Table is deleted");
	inputdata("id", "POSVA019_txtTableNoDel", TableNumber);
	click_On_Button("id", "POSVA019_spniDelTableOK");
	}
	
	if (SeatWisePayment.equals("NA") == false) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
       	Thread.sleep(3000);
		click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
		Thread.sleep(3000);
		String POSPay = driver.findElement(By.id("POS_CLBtnPay")).getText();
		
		if(POSPay.equalsIgnoreCase("Pay")){
			
		click_On_Button("id", "POS_Pay");
		
		
		/////////////////////////
		       if(RegularPayment.equalsIgnoreCase("Y")) {
		    	   
		   		click_On_Button("id", "POSVA019_btnPayReg");
		   		
		       }
		       if(Seatwisepayment.equalsIgnoreCase("Y")){

					click_On_Button("id", "VA019_CLPaySeatWise");
					for (int i = 0; i < a.length; i++) {
						click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
					}
					click_On_Button("id", "VAPOS_CLChkout");
				
		       }
		       if(Manualpayment.equalsIgnoreCase("Y")){
		    	   click_On_Button("id", "VA019_CLPayManual");
		    	   String quantity = driver.findElement(By.id("inpQty")).getAttribute("value");
		    	   System.out.println("Quan"+quantity);
		    	 //  if(quantity=="1.000"){
		    	   click_On_Button("xpath", "//div[@class='h-1']");
		    	   click_On_Button("id", "VAPOS_CLChkout");
		    	  // }
		    	   //if
		       }
		//////////////////

		
		if (Cash.equals("NA") == false) {
			String[] arrSplit = Cash.split(",");
			cash(arrSplit);

		}
		
		if (MultiCash.equals("NA") == false) {
			String[] arrSplit1 = MultiCash.split(",");
			multiCash(arrSplit1);
			}	

		if (card.equals("NA") == false) {
			cardPay(card);

		}	
		
		if (multiCard.equals("NA") == false) {
			CardMulti(multiCard);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
       	Thread.sleep(3000);
		click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
		Thread.sleep(3000);
		click_On_Button("id", "POSVA019_CLClearTable");
		Thread.sleep(2000);
		click_On_Button("id", "POSVA019_btnDeleteTableGS");
		inputdata("id", "POSVA019_txtTableNoDel", TableNumber);
		click_On_Button("id", "POSVA019_spniDelTableOK");
	}
		
		
		else{
			click_On_Button("id", "POSVA019_CLClearTable");
			Thread.sleep(2000);
			click_On_Button("id", "POSVA019_btnDeleteTableGS");
			inputdata("id", "POSVA019_txtTableNoDel", TableNumber);
			click_On_Button("id", "POSVA019_spniDelTableOK");
		}
	}
	
	
	
	//*************************************************************************//
	
	if (ManualPayment.equals("NA") == false) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
       	Thread.sleep(3000);
		click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
		Thread.sleep(4000);
        String POSPay = driver.findElement(By.id("POS_CLBtnPay")).getText();
        Thread.sleep(3000);
		if(POSPay.equalsIgnoreCase("Pay")){
			
		click_On_Button("id", "POS_Pay");
		
		       if(RegularPayment.equalsIgnoreCase("Y")) {
		    	   
		   		click_On_Button("id", "POSVA019_btnPayReg");
		   		
		       }
		       if(Seatwisepayment.equalsIgnoreCase("Y")){

					click_On_Button("id", "VA019_CLPaySeatWise");
					for (int i = 0; i < a.length; i++) {
						click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
					}
					click_On_Button("id", "VAPOS_CLChkout");
				
		       }
		       if(Manualpayment.equalsIgnoreCase("Y")){
		    	   click_On_Button("id", "VA019_CLPayManual");
		    	   String quantity = driver.findElement(By.id("inpQty")).getAttribute("value");
		    	   System.out.println("Quan"+quantity);
		    	 //  if(quantity=="1.000"){
		    	 int size =  driver.findElements(By.xpath("//div[@class='h-1']")).size();
		    	   System.out.println("Size"+size);
		    	   if (size>0){
		    		   for(int i =1; i<=size ; i++)
		    	   {
		    	   click_On_Button("xpath", "//div[@class='h-1']");
		    	   }
		    	   }
		    	   click_On_Button("id", "VAPOS_CLChkout");
		    	  // }
		    	   //if
		       }
		//////////////////

		
		if (Cash.equals("NA") == false) {
			String[] arrSplit = Cash.split(",");
			cash(arrSplit);

		}
		
		if (MultiCash.equals("NA") == false) {
			String[] arrSplit1 = MultiCash.split(",");
			multiCash(arrSplit1);
			}	

		if (card.equals("NA") == false) {
			cardPay(card);

		}	
		
		if (multiCard.equals("NA") == false) {
			CardMulti(multiCard);
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
       	Thread.sleep(3000);
		click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
		click_On_Button("id", "POSVA019_CLClearTable");
		Thread.sleep(2000);
		click_On_Button("id", "POSVA019_btnDeleteTableGS");
		inputdata("id", "POSVA019_txtTableNoDel", TableNumber);
		click_On_Button("id", "POSVA019_spniDelTableOK");
	}
	}
}


//**************************************************************************************************************//
public void Logout() throws InterruptedException {
	if (LO.equals("NA") == false) {
		Thread.sleep(5000);
		if(duebillpayment.equalsIgnoreCase("Y")){
		click_On_Button("xpath", "//div[@id='POS_Logout']");
		}
		if(duebillpayment.equalsIgnoreCase("Y")==false){
		click_On_Button("id", "POSVA019_btnLogoutTableGS");
		}


	}
}

//**************************************************************************************************************//
//Duebillpayment
	public void DueBillPayment() throws Exception {
		if (!duebillpayment.equals("NA") && (duebillpayment.equals("Y"))) {
			click_On_Button("id", "POSVA019_DueBillPay");
		//	String Count = driver.findElement(By.id("POSVA019_DineinOrdersCount")).getText();
			click_On_Button("id", "POSVA019_CLDineIn");
			Thread.sleep(2000);
			inputdata("id", "POSVA019_DueBillOrderSearch", orderNumber);
			click_On_Button("id", "POSVA019_DueBillSearchOrder");
			Thread.sleep(2000);

			click_On_Button("xpath", "//input[@name='chkDriveinOrderno']");

				click_On_Button("id", "POSVA019_btnDueBillPayOK");

			if (Cash.equals("NA") == false) {
				String[] arrSplit = Cash.split(",");
				cash(arrSplit);
			
			}
			

			if (MultiCash.equals("NA") == false) {
				String[] arrSplit1 = MultiCash.split(",");
				multiCash(arrSplit1);
				}	
			
			if (card.equals("NA") == false) {
				cardPay(card);

			}	
			
			if (multiCard.equals("NA") == false) {
				CardMulti(multiCard);
			}
		}
	}
	
	//***************************************************************************************************************************//
	public void Dicountper(String Product, String a[]) throws Exception {
		if (!dicountpercentage.equals("NA")) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]")));

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
	
	//**************************************************************************************************************//
	
	public void Discountamount(String Product, String a[]) throws Exception {
		if (!discountamount.equals("NA")) {
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//p[@class='VAPOS_grdNameP'][contains(text(),'" + Product + "')]")));

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
//**************************************************************************************************************************//
	public void DiscountPerTotal(String a[],String b[]) throws Exception {
		if (discountPerTotalpercentage.equals("NA") == false) {
			Thread.sleep(2000);
		click_On_Button("id", "POS_Pay"); // click on pay
		
		if (Regular.equals("NA") == false) {
			Thread.sleep(1000);	
			click_On_Button("id", "POSVA019_btnPayReg");
		}
		
		if (SeatWisePayment.equals("NA") == false) {
			click_On_Button("id", "VA019_CLPaySeatWise");
			for (int i = 0; i < a.length; i++) {
				click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
			}
			click_On_Button("id", "VAPOS_CLChkout");
		}
		
		if (ManualPayment.equals("NA") == false) {
			// manual
			Thread.sleep(2000);
			click_On_Button("id", "VA019_CLPayManual");
			Thread.sleep(2000);
			for (int i = 1; i <= ded5; i++) {
				click_On_Button("xpath", "//div[@class='posva019-qtyIcon minusIcon']");
			}
			click_On_Button("id", "VAPOS_btnChkOut");
		
		}
		
		click_On_Button("id", "POS_ProDiscount"); // click on discount
		click_On_Button("id", "POS_CalProDiscPer");
		for (int i = 0; i < b.length; i++) {
			Thread.sleep(1000);
			click_On_Button("id", "POS_calc_" + b[i].toString() + "");
		}

		click_On_Button("id", "POS_CalProDiscPer");

		}
	}
	
	//******************************************************************************************************************************//
	//Discount Amount
	
		public void DiscountAmountTotal(String a[],String b[]) throws Exception {
			if (discountPerTotalamount.equals("NA") == false) {
				Thread.sleep(2000);
			click_On_Button("id", "POS_Pay"); // click on pay
			
			if (Regular.equals("NA") == false) {
				Thread.sleep(1000);	
				click_On_Button("id", "POSVA019_btnPayReg");
			}
			
			if (SeatWisePayment.equals("NA") == false) {
				click_On_Button("id", "VA019_CLPaySeatWise");
				for (int i = 0; i < a.length; i++) {
					click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
				}
				click_On_Button("id", "VAPOS_CLChkout");
			}
			
			if (ManualPayment.equals("NA") == false) {
				// manual
				Thread.sleep(2000);
				click_On_Button("id", "VA019_CLPayManual");
				Thread.sleep(2000);
				for (int i = 1; i <= ded5; i++) {
					click_On_Button("xpath", "//div[@class='posva019-qtyIcon minusIcon']");
				}
				click_On_Button("id", "VAPOS_btnChkOut");
			
			}
			
			click_On_Button("id", "POS_ProDiscount"); // click on discount
			click_On_Button("id", "POS_CalProDisc");
			for (int i = 0; i < b.length; i++) {
				Thread.sleep(1000);
				click_On_Button("id", "POS_calc_" + b[i].toString() + "");
			}

			click_On_Button("id", "POS_CalProDisc");
			

			}
		}
		//*********************************************************************************************************************//
		
		public void PreBill(String a[],String b[],String c[]) throws Exception {

			if(PreBill.equalsIgnoreCase("Y")){
			
			if (preBill.equals("NA") == false) {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				Thread.sleep(3000);
				click_On_Button("id", "POS_HoldOrder");
				Thread.sleep(2000);
				click_On_Button("id", "POSVA019_btnPayReg");
				Thread.sleep(3000);
				
				
				//discount product 
				if(PreBillDiscount.equals("NA")==false){
				click_On_Button("id", "POS_HoldOrder");
				
				if(PrebillDiscountPercentage.equals("NA")==false){
				click_On_Button("id", "POS_DiscPercntCal");
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + b[i].toString() + "");
				}
				click_On_Button("id", "POS_DiscPercntCal");
				Thread.sleep(2000);
				click_On_Button("id", "POS_CLbtnOKDiscLine");
				
				}
				
				if(PrebillDiscountAmount.equals("NA")==false){
				
				click_On_Button("id", "POS_DiscAmtCal");
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + c[i].toString() + "");
				}
				click_On_Button("id", "POS_DiscAmtCal");
				Thread.sleep(2000);
				click_On_Button("id", "POS_CLbtnOKDiscLine");
				}
				
				
				
				}
				
				click_On_Button("id", "POS_SendToKitchen");
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
				Thread.sleep(3000);
				click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
				Thread.sleep(2000);
				
				if(DeletePrebill.equalsIgnoreCase("Y")){
					click_On_Button("xpath", "//div[@style='width:100%; height:10px;display:block']//img[@src='/Areas/POS/Content/Images/close-icon-3.png']");
					Thread.sleep(2000);
					click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/plus.png']");
					}
				
				if(DeletePrebill.equalsIgnoreCase("NA")){
				click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/plus.png'][@data-isprebill='Y']");
				}
				
				prebillvoid();
				if(PreBillTotalVoid.equalsIgnoreCase("Y")==false){
				Thread.sleep(2000);
	             click_On_Button("id", "POS_Pay");
				if (Cash.equals("NA") == false) {
					String[] arrSplit = Cash.split(",");
					cash(arrSplit);

				}

				if (MultiCash.equals("NA") == false) {
					String[] arrSplit1 = MultiCash.split(",");
					multiCash(arrSplit1);
					}	
				
				if (card.equals("NA") == false) {
					cardPay(card);

				}	
				
				if (multiCard.equals("NA") == false) {
					CardMulti(multiCard);
				}
				}
				
			}

			
			// if prebill is seat wise
			if (PreBillSeatWise.equals("NA") == false) {
			
				Thread.sleep(3000);
				click_On_Button("id", "POS_HoldOrder");
				Thread.sleep(2000);
				click_On_Button("id", "POSVA019_btnPaySeatWise");

				for (int i = 0; i < a.length; i++) {
					click_On_Button("xpath", "//div[@id='VA019_seatNoPM" + a[i].toString() + "']");
				}
				click_On_Button("id", "VAPOS_btnChkOut");
				Thread.sleep(3000);

				
				//discount product 
				if(PreBillDiscount.equals("NA")==false){
				click_On_Button("id", "POS_HoldOrder");
				
				if(PrebillDiscountPercentage.equals("NA")==false){
				click_On_Button("id", "POS_DiscPercntCal");
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + b[i].toString() + "");
				}
				click_On_Button("id", "POS_DiscPercntCal");
				Thread.sleep(2000);
				click_On_Button("id", "POS_CLbtnOKDiscLine");
				
				}
				
				if(PrebillDiscountAmount.equals("NA")==false){
				
				click_On_Button("id", "POS_DiscAmtCal");
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + c[i].toString() + "");
				}
				click_On_Button("id", "POS_DiscAmtCal");
				Thread.sleep(2000);
				click_On_Button("id", "POS_CLbtnOKDiscLine");
				}
				
				
				
				}
				
				click_On_Button("id", "POS_SendToKitchen");
				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
				Thread.sleep(3000);
				click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
				Thread.sleep(3000);
				click_On_Button("xpath", "//img[@src='/Areas/POS/Content/Images/plus.png'][@data-isprebill='Y']");
				Thread.sleep(2000);
				prebillvoid();
				if(PreBillTotalVoid.equalsIgnoreCase("Y")==false){
				 click_On_Button("id", "POS_Pay");
				if (Cash.equals("NA") == false) {
					String[] arrSplit = Cash.split(",");
					cash(arrSplit);

				}
				if (MultiCash.equals("NA") == false) {
					String[] arrSplit1 = MultiCash.split(",");
					multiCash(arrSplit1);
					}	
				
				if (card.equals("NA") == false) {
					cardPay(card);

				}	
				
				if (multiCard.equals("NA") == false) {
					CardMulti(multiCard);
				}
				}
			}

			
			
			
			// to make payment through manual
			if (PreBillManual.equals("NA") == false) {
				Thread.sleep(3000);
				click_On_Button("id", "POS_HoldOrder");
				Thread.sleep(2000);
				click_On_Button("id", "VA019_CLPayManual");
				Thread.sleep(2000);
				for (int i = 1; i <= ded5; i++) {
					click_On_Button("xpath", "//div[@class='posva019-qtyIcon minusIcon']");
				}
				click_On_Button("id", "VAPOS_btnChkOut");
				
				

				//discount product 
				if(PreBillDiscount.equals("NA")==false){
					Thread.sleep(2000);
				click_On_Button("id", "POS_HoldOrder");
				
				if(PrebillDiscountPercentage.equals("NA")==false){
				click_On_Button("id", "POS_DiscPercntCal");
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + b[i].toString() + "");
				}
				click_On_Button("id", "POS_DiscPercntCal");
				Thread.sleep(2000);
				click_On_Button("id", "POS_CLbtnOKDiscLine");
				
				}
				
				if(PrebillDiscountAmount.equals("NA")==false){
				
				click_On_Button("id", "POS_DiscAmtCal");
				for (int i = 0; i < a.length; i++) {
					Thread.sleep(1000);
					click_On_Button("id", "POS_calc_" + c[i].toString() + "");
				}
				click_On_Button("id", "POS_DiscAmtCal");
				Thread.sleep(2000);
				click_On_Button("id", "POS_CLbtnOKDiscLine");
				}
				
				
				
				}
				
				prebillvoid();
				Thread.sleep(2000);
				if(PreBillTotalVoid.equalsIgnoreCase("Y")==false){
				 click_On_Button("id", "POS_Pay");
				 
				if (Cash.equals("NA") == false) {
					String[] arrSplit = Cash.split(",");
					cash(arrSplit);

				}
				
				if (MultiCash.equals("NA") == false) {
					String[] arrSplit1 = MultiCash.split(",");
					multiCash(arrSplit1);
					}	
				
				if (card.equals("NA") == false) {
					cardPay(card);

				}	
				
				if (multiCard.equals("NA") == false) {
					CardMulti(multiCard);
				}
			}
			}
			}
		}
		//***************************************************************************************************************************//
		//void
		public void Void() throws InterruptedException {
			Thread.sleep(2000);
			// void linr wise
			if (Void.equals("NA") == false) {
				WebDriverWait wait = new WebDriverWait(driver, 60);
				click_On_Button("xpath", Void);
				click_On_Button("id", "POS_BtnProdVoid");
				click_On_Button("id", "POS_CLAddVReason");
				click_On_Button("id", "POS_SendToKitchen");
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//div[contains(text(),'" + TableNumber + "') ]")));
				Thread.sleep(3000);
				click_On_Button("xpath", "//div[contains(text(),'" + TableNumber + "') ]");
				
			}

			// void full order
			if (TotalVoid.equals("NA") == false) {
				Thread.sleep(3000);
				click_On_Button("id", "POS_Reset");
				click_On_Button("id", "POS_btnAddVReason");
			}

		}
		
		public void prebillvoid() throws InterruptedException{
			if (PreBillVoid.equals("NA") == false) {
			//	WebDriverWait wait = new WebDriverWait(driver, 60);
				click_On_Button("xpath", PreBillVoid);
				click_On_Button("id", "POS_BtnProdVoid");
				click_On_Button("id", "POS_CLAddVReason");
				
			}

			// void full order
			if (PreBillTotalVoid.equals("NA") == false) {
				Thread.sleep(3000);
				click_On_Button("id", "POS_Reset");
				click_On_Button("id", "POS_btnAddVReason");
			}
		}
		//**********************************************************************************************************************//
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
		
		//*************************************************************************************************************************//
		 public void QuickPay() throws FindFailed, InterruptedException{
			 Screen s = new Screen();
				//Pattern p = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\QuickPayment.PNG");
				Pattern p = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\QuickPayment.PNG");	
				
				//Pattern p1 = new Pattern("D:\\Ankita Data\\AnkitaBackup\\eclipse\\Workspace\\Rest_Project\\Sikulli Images\\Cancel.PNG");
				Pattern p1 = new Pattern("C:\\Users\\gaurav.raghuwanshi\\Documents\\POS_Script_Content\\Project\\POS_Resturant\\Sikulli_Images\\Cancel.PNG");
			if(quickpay.equalsIgnoreCase("Y")){
			 click_On_Button("xpath", "//a[text()='Quick Pay']");
			 Thread.sleep(2000);
			// click_On_Button("xpath", "//div[@class='pos-PopupBtn pull-right pos-confirm-alert']//a[@class='btn pos-btn pos-AddProBtn']");
			 s.click(p);
			 Thread.sleep(5000);
			 while ( s.exists(p1) != null){
			      s.click(p1);
			    Thread.sleep(2000);
			   }
			 System.out.println("QuickPay Method");
			 }
		 }
}
			
				

