// package common;

// import java.io.File;
// import java.io.FileNotFoundException;
// import java.io.IOException;
// import java.util.Dictionary;
// import java.util.Hashtable;
// import java.util.NoSuchElementException;
// //import com.

// import org.openqa.selenium.Alert;
// import org.openqa.selenium.By;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.support.ui.Wait;
// import org.openqa.selenium.support.ui.Select;

// import com.csvreader.CsvReader;

// public class WebHelper extends Setup {
	
// 	public final String CONFIG_FILE = "src/main/resources/config.properties";

// 	private final String CSV_FILE = "src/main/resource/" + lookupProperty(CONFIG_FILE, "environment") + ".csv";

// 	Dictionary<String, Dictionary<String, Dictionary<String, String>>> testData = new Hashtable<String, Dictionary<String, Dictionary<String, String>>>();
// 	public static Dictionary<String, Dictionary<String, String>> testDictionary = null;

// 	public void readTestData() {
// 		try {
// 			java.io.File fileLookingFor = new File(CSV_FILE);

// 			if (!fileLookingFor.exists()) {

// 				java.io.File file = new File("scr/main/resources/TestData.csv");
// 				// testDictionary = populateTestDictionary(file.toString());
// 			} else {
// 				// testDictionary = populateTestDictionary (CSV_FILE);
// 			}
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}

// 	public Dictionary<String, Dictionary<String, Dictionary<String, String>>> populateTestDictionary(String csvFileName)
// 			throws Exception {

// 		try {
// 			CsvReader csvreaderobj = new CsvReader(csvFileName);
// 			csvreaderobj.readHeaders();
// 			while (csvreaderobj.readRecord()) {
// 				Dictionary<String, String> dicttoread = new Hashtable<String, String>();
// 				String p_testcaneName = csvreaderobj.get("TestcaseName").trim();
// 				for (int i = 1; i < csvreaderobj.getColumnCount() / 2 + 1; i++) {
// 					String p_field = csvreaderobj.get("Field" + i).trim();
// 					String p_objproperty = csvreaderobj.get("Value" + i).trim();

// 					if (p_field != null && !p_field.isEmpty() && p_objproperty != null && !p_objproperty.isEmpty()) {
// 						dicttoread.put(p_field, p_objproperty);
// 					}
// 				}
// 				Object p_testcaseName;
// 				// testData.put(p_testcaseName, dicttoread);
// 			}
// 		} catch (FileNotFoundException e) {
// 			e.printStackTrace();
// 		} catch (IOException e) {
// 			e.printStackTrace();
// 		}
// 		return testData;
// 	}

// 	/**
// 	 * wrapper to read from the test dictionary
// 	 * 
// 	 * @param testcaseName
// 	 * @param field
// 	 * @throws Exception
// 	 */

// 	public static String readTestData(String testcaseName, String field) throws Exception {
// 		return testDictionary.get(testcaseName).get(field);
// 	}

// 	/**
// 	 * Methode to find the textField and enter the text
// 	 * 
// 	 * @param text  - text to enter
// 	 * @param xpath - locator for the text field
// 	 * @throws Exception
// 	 * @author pankaj.upadhyay
// 	 */

// 	public final static void enterText(String text, String xPath) throws NoSuchElementException, InterruptedException {
// 		WebElement element = driver.findElement(By.xpath(xPath));
// 		if (element == null) {
// 			throw new NoSuchElementException("Unable to locate element for entering text");
// 		} else {
// 			element.click();
// 			element.sendKeys(text);
// 		}

// 	}

// 	/**
// 	 * Methode to clear the text box and enter the text
// 	 * 
// 	 * @param text - text to enter
// 	 * @param id   - element id
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static void selectItemInDropDown(String item, String xPath) {

// 		Select DropDownitem = new Select(driver.findElement(By.xpath(xPath)));
// 		DropDownitem.selectByVisibleText(item);
// 		// WebElement element = driver.findElement(By.id(id));

// 	}

// 	/**
// 	 * Methode to clear the text box and enter the text
// 	 * 
// 	 * @param text - text to enter
// 	 * @param id   - element id
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static String getItemInDropDown(String xPath) {

// 		Select DropDownitem = new Select(driver.findElement(By.xpath(xPath)));
// 		return DropDownitem.getFirstSelectedOption().getText();

// 	}
	
// 	/**
// 	 * Methode to clear the text box and enter the text
// 	 * 
// 	 * @param text - text to enter
// 	 * @param xPath   - element xPath
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static void selectItemByXPath(String xPath) {

// 		WebElement element = driver.findElement(By.xpath(xPath));
// 		element.click();

// 	}
	
// 	/**
// 	 * Methode to find the element by xpath
// 	 * 
// 	 * @param xpath - locator for the text field
// 	 * @author pankaj.upadhyay
// 	 */
// 	protected final WebElement getElementByText(String text) {
// 		return driver.findElement(By.xpath(text));
// 	}

// 	/**
// 	 * Methode to find the element by text
// 	 * 
// 	 * @param text - element name for the text field
// 	 * @author pankaj.upadhyay
// 	 */
// 	protected final boolean checkelementExistByText(String text) {
// 		WebElement element = driver.findElement(By.name(text));
// 		if (element == null)
// 			return false;
// 		else
// 			return true;
// 	}
	
// 	/**
// 	 * Methode to find the element by text
// 	 * 
// 	 * @param CssSelector - element CssSelector field
// 	 * @author pankaj.upadhyay
// 	 */
// 	protected final boolean checkelementExistByCssSelector(String text) {
// 		WebElement element = driver.findElement(By.cssSelector(text));
// 		if (element == null)
// 			return false;
// 		else
// 			return true;
// 	}
	

// 	/**
// 	 * Methode to find the element by text
// 	 * 
// 	 * @param CssSelector - element CssSelector
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static String getElementTextBYCssSelector(String CssSelector) {

// 		WebElement element = driver.findElement(By.cssSelector(CssSelector));
// 		return element.getText().toString();

// 	}
	
	

// 	/**
// 	 * Methode to find the element by text
// 	 * 
// 	 * @param text - element name for the text field
// 	 * @author pankaj.upadhyay
// 	 */
// 	protected final boolean checkelementExistByClassText(String text) {
// 		WebElement element = driver.findElement(By.className(text));
// 		if (element == null)
// 			return false;
// 		else
// 			return true;
// 	}

// 	/**
// 	 * Methode to find the element by text
// 	 * 
// 	 * @param xPath - element xPath
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static String getElementTextByXPath(String xPath) {

// 		WebElement element = driver.findElement(By.xpath(xPath));
// 		return element.getText().toString();

// 	}
	
// 	/**
// 	 * Methode to find the element by text
// 	 * 
// 	 * @param xPath - element xPath
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static String getElementValueByXPath(String xPath) {

// 		WebElement element = driver.findElement(By.xpath(xPath));
// 		return element.getAttribute("value").toString();

// 	}
		
	
// 	/**
// 	 * Methode to get the element by id
// 	 * 
// 	 * @param CssSelector - element CssSelector
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static String getElementTextByCssSelector(String CssSelector) {
// 		WebElement element = driver.findElement(By.cssSelector(CssSelector));
// 		return element.getText().toString();
// 	}

// 	/**
// 	 * Methode to click on button by id
// 	 * 
// 	 * @param xPath - element xPath
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static void clickButtonByXPath(String xPath) {
// 		WebElement element = driver.findElement(By.xpath(xPath));
// 		element.click();
// 	}
	
// 	/**
// 	 * Methode to click on button by id
// 	 * 
// 	 * @param CssSelector - element CssSelector
// 	 * @author pankaj.upadhyay
// 	 */
// 	public static void clickButtonByCssSelector(String CssSelector) {
// 		WebElement element = driver.findElement(By.cssSelector(CssSelector));
// 		element.click();
// 	}
	
// 	/**
// 	 * Methode to find the element by xPath
// 	 * 
// 	 * @param id - element id
// 	 * @author pankaj.upadhyay
// 	 */
// 	protected final boolean checkelementExistByXPath(String xPath) {
// 		WebElement element = driver.findElement(By.xpath(xPath));
// 		if (element == null)
// 			return false;
// 		else
// 			return true;
// 	}

// 	protected WebElement getElement(String xpath) {
// 		// TODO Auto-generated method stub
// 		WebElement element = driver.findElement(By.xpath(xpath));
// 		if (element == null) {
// 			return element;
// 		} else
// 			return null;
// 	}

// 	protected static String getBrowserTitle() {
// 		return driver.getTitle();
// 	}

// 	protected static void fluentWait(long defaultTimeout) throws InterruptedException {
// 		Thread.sleep(defaultTimeout);
// 	}
// }
