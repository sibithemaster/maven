package com.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_class;

public class hyundai extends Base_class {
	public  hyundai() {
		PageFactory.initElements(driver,this);
	}
@FindBy(id = "inputmodel-01")
private WebElement model;

@FindBy(id = "inputfuel-01")
private WebElement fuel;

@FindBy(id="inputvrnt-01")
private WebElement variant;

@FindBy(id="inputext-01")
private WebElement exterior;

@FindBy(id="inputinter-01")
private WebElement interior;

@FindBy(id="state-01")
private WebElement state;

@FindBy(id="dealer-city-01")
private WebElement city;

@FindBy(id="bookacardelar")
private WebElement dealer_name;





public WebElement getModel() {
	return model;
}


public WebElement getFuel() {
	return fuel;
}


public WebElement getVariant() {
	return variant;
}


public WebElement getExterior() {
	return exterior;
}


public WebElement getInterior() {
	return interior;
}

public WebElement getState() {
	return state;
}


public WebElement getCity() {
	return city;
}


public WebElement getDealer_name() {
	return dealer_name;
}

}