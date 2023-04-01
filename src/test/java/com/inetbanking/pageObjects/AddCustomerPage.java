package com.inetbanking.pageObjects;
import org.openqa.selenium.support.How;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver ldriver;


	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver= rdriver;
		PageFactory.initElements(ldriver, this);
	}

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkaddnewcustomer;

	@FindBy(name="name")
	WebElement txtname;

	@FindBy(name="rad1")
	WebElement rdGender;

	@FindBy(name="dob")
	WebElement txtdob;

	@FindBy(name="addr")
	WebElement txtaddress;

	@FindBy(name="city")
	WebElement txtcity;

	@FindBy(name="state")
	WebElement txtstate;


	@FindBy(name="pinno")
	WebElement txtpinno;

	@FindBy(name="telephoneno")
	WebElement txttelephoneno;

	@FindBy(name="emailid")
	WebElement txtemailid;

	@FindBy(name="password")
	WebElement txtpassword;

	@FindBy(name="sub")
	WebElement btnsubmit;

	public void ClickAddNewCustomer() {
		lnkaddnewcustomer.click();
	}

	public void custName(String cname) {
	txtname.sendKeys(cname);
	}
	
	public void custGender (String rgender)
	{
		rdGender.sendKeys(rgender);
	}

	public void custdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);;
	}
	public void custCity(String cctiy) {
		txtcity.sendKeys(cctiy);
	}
	public void custState(String cstate) {
		txtstate.sendKeys(cstate);
	}
	public void custPino(String cpino) {
		txtpinno.sendKeys(cpino);
	}
	public void custPhone(String cphone) {
		txttelephoneno.sendKeys(cphone);
	}
	public void custEmail(String cemail) {
		txtemailid.sendKeys(cemail);
	}
	public void custPass(String cpass) {
		txtpassword.sendKeys(cpass);
	}

		public void custSubmit(String csubmit) {
			btnsubmit.click();;
		}
	}