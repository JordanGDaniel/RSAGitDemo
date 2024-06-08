import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class QAClickJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		String[] depAirport = { "BLR", "AIP", "AMD" };
		String[] arrAirport = { "MAA", "BHO", "GOI" };
		String[] curr = { "INR", "AED", "USD" };
		int[] passNumber = { 3, 4, 5 };

		for (int i = 0; i < depAirport.length; i++) {
			openWebsite(driver);
			selectCountry(driver);
			selectDeparture(driver, depAirport[i], arrAirport[i]);
			selectDate(driver);
			selectAdults(driver, passNumber[i]);
			selectCurrency(driver, curr[i]);
			selectSeniorCitizen(driver);
			selectSearch(driver);
		}
		driver.quit();

	}

	// Opens Website
	public static String openWebsite(WebDriver driver) {
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		return null;
	}

	// Selects the Country India
	public static String selectCountry(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(1000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class=ui-menu-item] a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}
		return null;
	}

	// Selects the Originating and Destination Cities
	public static String selectDeparture(WebDriver driver, String depAirport, String arrAirport)
			throws InterruptedException {
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='" + depAirport + "']"))
				.click();
		// Thread.sleep(2000);
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath(
				"//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='" + arrAirport + "']"))
				.click();
		return null;
	}

	// Selects today's date
	public static String selectDate(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		return null;
	}

	// Select 5 adults
	public static String selectAdults(WebDriver driver, int passNumber) throws InterruptedException {
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int iadults = passNumber;
		for (int i = 1; i < iadults; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		return null;
	}

	// Select Currency
	public static String selectCurrency(WebDriver driver, String curr) throws InterruptedException {
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(curr);
		return null;
	}

	// Select Senior Citizen Checkbox
	public static String selectSeniorCitizen(WebDriver driver) {
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		return null;
	}

	// Select Search button
	public static String selectSearch(WebDriver driver) {
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		return null;
	}

}
