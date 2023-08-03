package com.StepDefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.Base_class;
import com.page.hyundai;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends Base_class{
	public  hyundai hyu;
	public WebDriverWait wait;
		@Given("User is on hyundai dealer page.")
		public void user_is_on_hyundai_dealer_page() {
			getDriver();
			loadUrl("https://clicktobuy.hyundai.co.in/#/bookACar?modelCode=0Y");
			maximize();
		}
		@When("User clicks the model dropdown and clicks New Verna.")
		public void user_clicks_the_model_dropdown_and_clicks_new_verna() throws InterruptedException {
			hyu  = new hyundai();
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputmodel-01")));
			
			List<WebElement> vehicleModel = driver.findElements(By.xpath("//select[@id='inputmodel-01']/option"));
			Thread.sleep(5000);
			for(WebElement model: vehicleModel) {
				String modelName = model.getText();

				if(modelName.equals(" New Verna")) {
					selectByText(hyu.getModel(), modelName);
				}
			}
			//Thread.sleep(6000);
		}
		@Then("User clicks the Choose the first option in fuel type.")
		public void user_clicks_the_choose_the_first_option_in_fuel_type() throws InterruptedException {
			hyu  = new hyundai();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputvrnt-01")));
			selectByIndex(hyu.getFuel(),1);
			Thread.sleep(2000);
		}
		@Then("User clicks the Choose the first option in Variant.")
		public void user_clicks_the_choose_the_first_option_in_variant() throws InterruptedException {
			hyu  = new hyundai();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputvrnt-01")));
			selectByIndex(hyu.getVariant(),1);
			Thread.sleep(2000);
		}
		@Then("User clicks the Choose the first option in Exterior Color.")
		public void user_clicks_the_choose_the_first_option_in_exterior_color() throws InterruptedException {
			hyu  = new hyundai();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputinter-01")));
			selectByIndex(hyu.getExterior(),1);
			Thread.sleep(2000);

		}
		@Then("User clicks the Choose the first option in Interior Color.")
		public void user_clicks_the_choose_the_first_option_in_interior_color() throws InterruptedException {
			hyu  = new hyundai();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("inputinter-01")));
			selectByIndex(hyu.getInterior(),1);
			Thread.sleep(2000);

		}
		@Then("User clicks the Choose the state city and dealername and verifies all the dealers name in all state and cities.")
		public void user_clicks_the_choose_the_state_city_and_dealername_and_verifies_all_the_dealers_name_in_all_state_and_cities() throws InterruptedException {
			hyu  = new hyundai();
			List<WebElement> statelist = driver.findElements(By.xpath("//select[@id='state-01']/option"));

			for (WebElement option : statelist) {

				String stateName = option.getText();

				if((!stateName.equals("State"))) {
					selectByText(hyu.getState(), stateName);
					Thread.sleep(5000);
					List<WebElement> citylist = driver.findElements(By.xpath("//select[@id='dealer-city-01']/option"));
					for (WebElement option1 : citylist) {
						String cityName = option1.getText();
						if((!cityName.equals("City"))) {
							wait.until(ExpectedConditions.elementToBeClickable(By.id("dealer-city-01")));

							selectByText(hyu.getCity(),cityName);
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
										System.out.println(hyu.getDealer_name().getText());
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
										System.out.println(hyu.getDealer_name().getText());
										System.out.println("------------");
										System.out.println();

									}
								}
							}


						}

					}}}}
	



}
