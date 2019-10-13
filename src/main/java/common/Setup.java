// package common;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.InputStream;
// import java.net.MalformedURLException;
// import java.net.URL;
// import java.util.Properties;

// import org.openqa.selenium.Platform;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.BeforeSuite;

// public class Setup {
// 	public static WebDriver driver;
// 	public static String CONFIG_FILE = "src/main/resources/config.properties";
	
// 	@BeforeSuite(alwaysRun = true)

// 	public static void setupSuite() throws InterruptedException, MalformedURLException {
// 		//File chromeFile = new File("C:\\Workspace\\IRESS\\Selenium\\Drivers\\chromedriver.exe");
		
// 		String runOnDocker = lookupProperty(CONFIG_FILE, "runOnDocker");
		
// 		if(runOnDocker.equalsIgnoreCase("yes")) {
// 			//Test to run in docker
// 			DesiredCapabilities cap= DesiredCapabilities.chrome();
// 			cap.setPlatform(Platform.WINDOWS);
// 			cap.setVersion("");		
			
// 			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444/wd/hub"),cap);
// 		}
// 		else {
// 			//Test to run in local machine
// 			File chromeFile = new File("drivers\\chromedriver.exe");
// 			System.setProperty("webdriver.chrome.driver", chromeFile.getAbsolutePath());	
// 			driver = new ChromeDriver();			
// 		}	
		
// 	}

// 	@BeforeMethod(alwaysRun = true)
// 	public static void lauchApp() throws InterruptedException {		

// 		// Get the environment URL
// 		String getEnvironment = lookupProperty(CONFIG_FILE, "environment");
// 		String anzURL;
// 		if (getEnvironment.equalsIgnoreCase("staging"))
// 			anzURL = lookupProperty(CONFIG_FILE, "stagingURL");
// 		else
// 			anzURL = lookupProperty(CONFIG_FILE, "anzDevURL");
// 		driver.get(anzURL);
// 		Thread.sleep(2000);
// 	}

// 	public static String lookupProperty(String propFileName, String nameOfProperty) {
// 		InputStream inputStream = null;
// 		Properties properties = null;
// 		properties = new Properties();
// 		try {
// 			inputStream = new FileInputStream(propFileName);
// 			properties.load(inputStream);
// 			inputStream.close();
// 			if (properties != null) {
// 				return properties.getProperty(nameOfProperty);
// 			}
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 		return null;
// 	}

// 	@AfterSuite(alwaysRun = true)
// 	public void tearDown() {
		
// 		if(driver!=null)
// 		{
// 			System.out.println("Tear down the drivers");
// 			driver.close();
// 			driver.quit();
// 		}
// 	}

// }
