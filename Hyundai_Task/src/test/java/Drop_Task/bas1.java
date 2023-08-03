package Drop_Task;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class bas1 {
	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			String websiteUrl = "https://clicktobuy.hyundai.co.in/#/bookACar?modelCode=0Y";
			driver.get(websiteUrl);
			Thread.sleep(6000);
			String stateDropdownId = "state-01";
			WebElement stateDropdownElement = driver.findElement(By.id(stateDropdownId));
			Select stateDropdown = new Select(stateDropdownElement);
			java.util.List<WebElement> stateOptions = stateDropdown.getOptions();
			for (WebElement stateOption : stateOptions) {
				String stateName = stateOption.getText();
				if (!stateName.equals("State")) {
					stateDropdown.selectByVisibleText(stateName);
					String cityDropdownId = "dealer-city-01";
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(cityDropdownId)));

					WebElement cityDropdownElement = driver.findElement(By.id(cityDropdownId));
					Select cityDropdown = new Select(cityDropdownElement);
					java.util.List<WebElement> cityOptions = cityDropdown.getOptions();
					for (WebElement cityOption : cityOptions) {
						String cityName = cityOption.getText();
						if (!cityName.equals("City")) {
							cityDropdown.selectByVisibleText(cityName);
							System.out.println("State: " + stateName + ", City: " + cityName);
							String DealerDropdownId = "bookacardelar";
							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(DealerDropdownId)));

							WebElement DealerDropdownElement = driver.findElement(By.id(stateDropdownId));
							Select dealerDropdown = new Select(stateDropdownElement);
							dealerDropdown.selectByIndex(1);
						}
					}
				}
			}

			System.out.println("Automation of state cities dropdown is complete!");

		} catch (Exception e) {
			System.out.println("An error occurred: " + e.getMessage());
		} 
	}
}

//
//WebElement dealer_dropdown = driver.findElement(By.id("bookacardelar"));
//	Select Dealer = new Select(dealer_dropdown);