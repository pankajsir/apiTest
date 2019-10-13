// package assessment.com.au.web;

// import static org.testng.Assert.assertEquals;
// import static org.testng.Assert.assertTrue;
// import org.testng.annotations.Test;
// import common.WebHelper;
// import screen.BorrowCalculatorScreen;
// import object.repository.TextMessageForAssert;
// import object.repository.BorrowCalculatorPageObjects;
// import object.repository.ErrorMessageForAssert;
// import object.repository.PageHeadingForAssert;

// public class BorrowCalculatorTestClass extends WebHelper {

// 	final String CONFIG_FILE = "src/main/resources/config.properties";

// 	// Get testData: putting this in config file - not the place to keep the test data but getting some error in readData function
// 	String applicationType = lookupProperty(CONFIG_FILE, "ApplicationType");
// 	String noOfDependent = lookupProperty(CONFIG_FILE, "NoOfDependants");
// 	String propertyType = lookupProperty(CONFIG_FILE, "PropertyType");
// 	String primaryIncome = lookupProperty(CONFIG_FILE, "PrimaryIncome");
// 	String otherIncome = lookupProperty(CONFIG_FILE, "OtherIncome");
// 	String livingExpenses = lookupProperty(CONFIG_FILE, "LivingExpenses");
// 	String currentHomeLoanPayment = lookupProperty(CONFIG_FILE, "CurrentHomeLoanPayment");
// 	String otherLoanPayment = lookupProperty(CONFIG_FILE, "OtherLoanPayment");
// 	String otherExpenses = lookupProperty(CONFIG_FILE, "OtherExpenses");
// 	String creditCardLimit = lookupProperty(CONFIG_FILE, "CreditCardLimit");
	
	
// 	@Test
// 	public void testBorrowingEstimationForLoan() throws Exception {
		
// 		String strTitle = getBrowserTitle();
// 		assertEquals(strTitle.strip(), PageHeadingForAssert.APP_TITLE.trim(),
// 				"Borrowing Calculator web application title is not correct.");
		
// 		// Verify the calculator screen elements are present before start the test		
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.PRIMARY_INCOME), "Primary income field is not displayed.");
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.OTHER_INCOME), "Other income field is not displayed.");
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.LIVING_EXPENSES), "Living expenses field is not displayed.");
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.CURRENT_HL_PAYMENT), "Current home loan field is not displayed.");
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.OTHER_LOAN_PAYMENT), "Other loan field is not displayed.");
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.OTHER_EXPENSES), "Other expenses field is not displayed.");
// 		assertTrue(checkelementExistByXPath(BorrowCalculatorPageObjects.CREDIT_CARD_LIMIT), "Credit card limit field is not displayed.");
		
// 		// Enter the Customer's details
// 		//String applicationType = readData("CustomerDetails", "ApplicationType")
// 		BorrowCalculatorScreen.enterCustomerDetails(applicationType, noOfDependent, propertyType);
				
// 		// Enter the Customer's Income
// 		BorrowCalculatorScreen.enterIncomeDetails(primaryIncome,otherIncome);
		
// 		// Enter the Customer's expenses
// 		BorrowCalculatorScreen.enterExpensesDetails(livingExpenses,currentHomeLoanPayment,otherLoanPayment,otherExpenses,creditCardLimit);
	
// 		//Click on the calculator button and verify the borrowing estimation		
// 		clickButtonByXPath(BorrowCalculatorPageObjects.BORROWING_CALCULATOR);		
// 		fluentWait(3000);		
		
// 		String estimatedAmount = getElementTextBYCssSelector(BorrowCalculatorPageObjects.BORROW_ESTIMATION_AMOUNT);
		
// 		assertEquals(estimatedAmount, TextMessageForAssert.ESTIMATED_AMOUNT,
// 		"Borrowing estimated amount is not matched.");
		
// 	}

// 	@Test
// 	public void testStartOverFunctionality() throws Exception {		
		
// 		String strTitle = getBrowserTitle();
// 		assertEquals(strTitle.strip(), PageHeadingForAssert.APP_TITLE.trim(),
// 				"Borrowing Calculator web application title is not correct.");
		
// 		// Enter the Customer's details
// 		BorrowCalculatorScreen.enterCustomerDetails(applicationType, noOfDependent, propertyType);			
// 		// Enter the Customer's Income
// 		BorrowCalculatorScreen.enterIncomeDetails(primaryIncome,otherIncome);
// 		// Enter the Customer's expenses
// 		BorrowCalculatorScreen.enterExpensesDetails(livingExpenses,currentHomeLoanPayment,otherLoanPayment,otherExpenses,creditCardLimit);
	
// 		//Click on the calculator button and verify the borrowing estimation		
// 		clickButtonByXPath(BorrowCalculatorPageObjects.BORROWING_CALCULATOR);		
// 		fluentWait(3000);	
		
// 		String estimatedAmount = getElementTextBYCssSelector(BorrowCalculatorPageObjects.BORROW_ESTIMATION_AMOUNT);
		
// 		assertEquals(estimatedAmount, TextMessageForAssert.ESTIMATED_AMOUNT,
// 		"Borrowing estimated amount is not matched.");
		
// 		//Verify the start over button, click and verify the form's fields
// 		assertTrue(checkelementExistByCssSelector(BorrowCalculatorPageObjects.START_OVER), 
// 				"Start over button is not presented on form.");

// 		clickButtonByCssSelector(BorrowCalculatorPageObjects.START_OVER);
// 		fluentWait(1000);
		
// 		//Verify the form is loaded fresh and all the fields are as initial stage
// 		assertTrue(BorrowCalculatorScreen.verifyFormFields(), 
// 				"Form didn't get cleared. One of the fields is not cleared.");
// 	}
	
// 	@Test
// 	public void testUnableToProvideEstimation() throws Exception {

// 		// Enter living expenses $1 and leaving all the fields blank
// 		BorrowCalculatorScreen.enterExpensesDetails("1","0","0","0","0");
			
// 		//Click on the calculator button and verify the borrowing estimation		
// 		clickButtonByXPath(BorrowCalculatorPageObjects.BORROWING_CALCULATOR);
				
// 		fluentWait(1000);

// 		// Verify login is not successful, login button is still displaying.
// 		String errorMessage = getElementTextByCssSelector(BorrowCalculatorPageObjects.BORROW_ESTIMATION_ERROR);
		
// 		assertEquals(errorMessage.strip(), ErrorMessageForAssert.INVALID_IPS_USER_MESSAGE.trim(),
// 				"Borrowing estimated error message is not correct.");
// 	}
	
// }
