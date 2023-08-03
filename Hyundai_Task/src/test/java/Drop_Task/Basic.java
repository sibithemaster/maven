package Drop_Task;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base_class;
import com.page.hyundai;

public class Basic extends Base_class {
	public static hyundai hyundai;
	public static void main(String[] args) throws InterruptedException {
		getDriver();
		loadUrl("https://clicktobuy.hyundai.co.in/#/bookACar?modelCode=0Y");
		maximize();
		hyundai = new hyundai();

		// Waits for 20 seconds
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputmodel-01")));
	//	selectByIndex(hyundai.getModel(),1);
		List<WebElement> vehicleModel = driver.findElements(By.xpath("//select[@id=\"inputmodel-01\"]/option"));
		Thread.sleep(2000);
		for(WebElement model: vehicleModel) {
			String modelName = model.getText();

			if(modelName.equals(" New Verna")) {
				selectByText(hyundai.getModel(), modelName);
			}
		}
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputfuel-01")));		
		selectByIndex(hyundai.getFuel(),1);
			Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputvrnt-01")));
		selectByIndex(hyundai.getVariant(),1);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputext-01")));
		selectByIndex(hyundai.getExterior(),1);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputinter-01")));
			Thread.sleep(2000);
		selectByIndex(hyundai.getInterior(),1);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("state-01")));
			Thread.sleep(2000);

		//	Thread.sleep(2000);
		List<WebElement> statelist = driver.findElements(By.xpath("//select[@id='state-01']/option"));

		for (WebElement option : statelist) {

			String stateName = option.getText();

			if((!stateName.equals("State"))) {
				selectByText(hyundai.getState(), stateName);
				Thread.sleep(5000);
				List<WebElement> citylist = driver.findElements(By.xpath("//select[@id='dealer-city-01']/option"));
				for (WebElement option1 : citylist) {
					String cityName = option1.getText();
					if((!cityName.equals("City"))) {
						wait.until(ExpectedConditions.elementToBeClickable(By.id("dealer-city-01")));

						selectByText(hyundai.getCity(),cityName);
						//	Thread.sleep(5000);
						try {
							WebElement dealer_dropdown	= wait.until(ExpectedConditions.elementToBeClickable(By.id("bookacardelar")));
							//	 WebElement dealer_dropdown = driver.findElement(By.id("bookacardelar"));
							Select Dealer = new Select(dealer_dropdown);
							List<WebElement> dealerOption=Dealer.getOptions();
							for(WebElement list:dealerOption) {
								String dealerName = list.getText();
								if (!dealerName.isEmpty()&&(!list.equals("Dealer Name"))) {
									list.click();
									System.out.println("------------");
									System.out.println("Selected state: " + stateName + " Selected city: "+cityName);
									System.out.println();
									System.out.println(hyundai.getDealer_name().getText());
									System.out.println("------------");
									System.out.println();

								}}
						}
						catch(org.openqa.selenium.StaleElementReferenceException ex)
						{
							WebElement dealer_dropdown	= wait.until(ExpectedConditions.elementToBeClickable(By.id("bookacardelar")));
							//	 WebElement dealer_dropdown = driver.findElement(By.id("bookacardelar"));
							Select Dealer = new Select(dealer_dropdown);
							List<WebElement> dealerOption=Dealer.getOptions();
							for(WebElement list:dealerOption) {
								String dealerName = list.getText();
								if (!dealerName.isEmpty()&&(!list.equals("Dealer Name"))) {
									list.click();
									System.out.println("------------");
									System.out.println("Selected state: " + stateName + " Selected city: "+cityName);
									System.out.println();
									System.out.println(hyundai.getDealer_name().getText());
									System.out.println("------------");
									System.out.println();

								}
							}
						}

					}
				}
			}
		}
		System.out.println("Automation of state cities dropdown is complete!");

	}
}





