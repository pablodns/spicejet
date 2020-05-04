package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	@FindBy(id = "btn-one-way")
	WebElement rb_oneWay;

	@FindBy(id = "btn-round-trip")
	WebElement rb_roundTrip;

	@FindBy(xpath = "//*[@id='BookingEngineOlyFlight']/div[2]/div[1]/div[1]/button[2]")
	WebElement dd_origin;

	@FindBy(xpath = "//*[@id=\"BookingEngineOlyFlight\"]/div[2]/div[2]/div[1]/div[1]/button[2]")
	WebElement dd_destination;

	@FindBy(xpath = "//*[@id=\"BookingEngineOlyFlight\"]/div[2]/div[3]")
	WebElement dd_passengers;

	@FindBy(id = "SearchAvailabilityButton")
	WebElement btn_search;

	@FindBy(id = "input-origin")
	WebElement txt_origin;

	@FindBy(id = "input-destination")
	WebElement txt_destination;

	@FindBy(xpath = "//*[@id='ADTPax']/div/p[2]/button[2]")
	WebElement btn_addAdult;

	@FindBy(xpath = "//*[@id='CHDPax']/div/p[2]/button[2]")
	WebElement btn_addChild;
	
	@FindBy(xpath = "//*[@id='INFPax']/div/p[2]/button[2]")
	WebElement btn_addInfant;

	public MainPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

	public boolean setRadioButton(String option) {
		boolean result = false;

		if (option.equals("One way")) {
			rb_oneWay.click();
			result = true;
		} else if (option.equals("Round trip")) {
			rb_roundTrip.click();
			result = true;
		}

		return result;
	}

	public boolean writeOrigin(String origin) {
		boolean result = false;
		try {
			txt_origin.sendKeys(origin);
			return result = true;
		} catch (Exception e) {
			return result;
		}
	}

	public boolean writeDestination(String destionation) {
		boolean result = false;
		try {
			txt_destination.sendKeys(destionation);
			return result = true;
		} catch (Exception e) {
			return result;
		}
	}

	public boolean clickOrigin() {
		boolean result = false;
		try {
			dd_origin.click();
			return result = true;
		} catch (Exception e) {
			return result;
		}
	}

	public boolean clickDestination() {
		boolean result = false;
		try {
			dd_destination.click();
			return true;
		} catch (Exception e) {
			return result;
		}
	}

	public boolean clickPassengers() {
		try {
			dd_passengers.click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean clickAddAdult(int count) {
		try {
			for (int i = 1; i < count; i++) {
				btn_addAdult.click();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean clickAddChild(int count) {
		try {
			for (int i = 0; i < count; i++) {
				btn_addChild.click();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean clickAddInfant(int count) {
		try {
			for (int i = 0; i < count; i++) {
				btn_addInfant.click();
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
