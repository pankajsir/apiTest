// package screen;

// import java.util.NoSuchElementException;

// import common.WebHelper;
// import object.repository.BorrowCalculatorPageObjects;

// public class BorrowCalculatorScreen {
	
// 	public static void enterCustomerDetails(String applicationType, String noOfDependants, String propertyType) 
// 			throws NoSuchElementException, InterruptedException {

// 		WebHelper.selectItemByXPath("//label[contains(.,'"+ applicationType + "')]");		
// 		WebHelper.selectItemInDropDown(noOfDependants,BorrowCalculatorPageObjects.NO_OF_DEPENDANTS);		
// 		WebHelper.selectItemByXPath("//label[contains(.,'"+ propertyType + "')]");

// 	}
// 	public static void enterIncomeDetails(String primaryEarning, String otherIncome)
// 			throws NoSuchElementException, InterruptedException {

// 		WebHelper.enterText(primaryEarning, BorrowCalculatorPageObjects.PRIMARY_INCOME);
// 		WebHelper.enterText(otherIncome, BorrowCalculatorPageObjects.OTHER_INCOME);

// 	}
	
// 	public static void enterExpensesDetails(String livingExpenses, String currentHL, String otherHL, String otherExpenses, String creditCardLimit)
// 			throws NoSuchElementException, InterruptedException {

// 		WebHelper.enterText(livingExpenses, BorrowCalculatorPageObjects.LIVING_EXPENSES);
// 		WebHelper.enterText(currentHL, BorrowCalculatorPageObjects.CURRENT_HL_PAYMENT);
// 		WebHelper.enterText(otherHL, BorrowCalculatorPageObjects.OTHER_LOAN_PAYMENT);
// 		WebHelper.enterText(otherExpenses, BorrowCalculatorPageObjects.OTHER_EXPENSES);
// 		WebHelper.enterText(creditCardLimit, BorrowCalculatorPageObjects.CREDIT_CARD_LIMIT);

// 		}
	
// 	public static boolean verifyFormFields() {
		
// 		String applicationType = WebHelper.getElementTextByXPath(BorrowCalculatorPageObjects.APPLICATION_TYPE);		
// 		String noOfDependant = WebHelper.getItemInDropDown(BorrowCalculatorPageObjects.NO_OF_DEPENDANTS);	
// 		String propertyType = WebHelper.getElementTextByXPath(BorrowCalculatorPageObjects.BORROW_PROPERTY_TYPE);
		
// 		String primaryIncome = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.PRIMARY_INCOME);
// 		String otherIncome = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.OTHER_INCOME);
		
// 		String livingExpensive = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.LIVING_EXPENSES);
// 		String currentHLPayment = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.CURRENT_HL_PAYMENT);
// 		String otherLoanPayment = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.OTHER_LOAN_PAYMENT);
// 		String otherExpensive = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.OTHER_EXPENSES);
// 		String creditCardLimit = WebHelper.getElementValueByXPath(BorrowCalculatorPageObjects.CREDIT_CARD_LIMIT);		
		
// 		if (primaryIncome.equals("0") && otherIncome.equals("0") && livingExpensive.equals("0") && currentHLPayment.equals("0") 
// 				&& otherLoanPayment.equals("0") && otherExpensive.equals("0") && creditCardLimit.equals("0") && applicationType.equals("Single") 
// 		&& propertyType.equals("Home to live in") && noOfDependant.equals("0"))
// 			return true;
// 		else 
// 			return false;
		
// 	}
// }
