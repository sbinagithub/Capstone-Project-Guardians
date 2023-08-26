package tek.bdd.capstone.steps;

import java.util.List;

import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.capstone.base.BaseSetup;
import tek.bdd.capstone.pages.POMFactory;
import tek.bdd.capstone.pages.RetailAccountPage;
import tek.bdd.capstone.utilities.CommonUtility;
import tek.bdd.capstone.utilities.DataGenerator;

public class RetailAccountSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@When("User click on Account option")
	public void userClickOnAccountOption1() {
		clickElementWithJS(pomFactory.retailAccountPage().accountLink);
		logger.info("Account page was clicked successfully");
	}

	@When("User update Name {string} and Phone {string}")
	public void userUpdateNameTabanAndPhone(String name, String phoneNumber) {
		clearTextUsingSendKeys(pomFactory.signInPage().nameInputField);
		
		sendText(pomFactory.signInPage().nameInputField, DataGenerator.addressGenerator("fullnameValue"));
		logger.info("Name was entered successfully");
		clearTextUsingSendKeys(pomFactory.signInPage().phoneField);
		sendText(pomFactory.signInPage().phoneField, phoneNumber);
		logger.info("PhoneNumber was entered successfully");

	}

	@And("User click on Update button")
	public void userClickOnUpdateButton() {
		hardWait(6000);
		click(pomFactory.retailAccountPage().accountUpdateBtn);
		logger.info("User click on update button successfully");
	}

	@Then("user profile information should be updated")
	public void userProfileInformationShouldBeUpdated() {
		waitTillPresence(pomFactory.signInPage().personalInfoUpdateSuccessMssg);
		String expectedMsg = "Personal Information Updated Successfully";
		String actualMsg = pomFactory.signInPage().personalInfoUpdateSuccessMssg.getText();
		Assert.assertEquals(expectedMsg, actualMsg);
		logger.info("Updated information seccessfully");
	}

	// Add Payment
	@When("User click on Add a payment method link")
	public void userClickOnAddAPaymentMethodLink() {
		clickElementWithJS(pomFactory.retailAccountPage().addAPaymentMethodLink);
		logger.info("User cliced on add a payment method link successfully");

	}

	@When("User fill Debit or credit card information")
	public void userFillDebitOrCreditCardInformation(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		sendText(pomFactory.retailAccountPage().cardNumberField, paymentInfo.get(0).get("cardNumber"));
		sendText(pomFactory.retailAccountPage().nameOnCardField, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationMonthField,
				paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expireationYearField,
				paymentInfo.get(0).get("expirationYear"));
		sendText(pomFactory.retailAccountPage().securityCodeField, paymentInfo.get(0).get("securityCode"));
		logger.info("Payment Information was entered successfully");

	}

	@When("User click on Add your card button")
	public void userClickOnAddYourCardButton() {
		click(pomFactory.retailAccountPage().paymentSubmitBtn);
		logger.info("Payment Method Submit bttn clicked successfully");
	}

	@Then("a message should be displayed {string}")
	public void aMessageShouldBeDisplayed(String expectedMssg) {
		if (expectedMssg.contains("Payment Method added")) {
			waitTillPresence(pomFactory.retailAccountPage().paymentMethodSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().paymentMethodSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		} else if (expectedMssg.contains("Address Added")) {
			waitTillPresence(pomFactory.retailAccountPage().addressSuccessMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailAccountPage().addressSuccessMssg.getText());
			logger.info("Expected Message: " + expectedMssg);
		} else if (expectedMssg.contains("Order Placed")) {
			waitTillPresence(pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg);
			Assert.assertEquals(expectedMssg, pomFactory.retailOrderPage().orderPlacedSuccessfullyMssg.getText());
		}
		// it passed until here

	}

//Edit Card
	@When("User click on Edit option of card section")
	public void userClickOnEditOptionOfCardSection() {
		click(pomFactory.retailAccountPage().clickOnCard);
		click(pomFactory.retailAccountPage().editCrdeBttn);
		logger.info("Edit button clicked sucessfully");
	}

	@When("user edit information with below data")
	public void userEditInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> paymentInfo = dataTable.asMaps(String.class, String.class);
		clearTextUsingSendKeys(pomFactory.retailAccountPage().cardNumberFiled);
		sendText(pomFactory.retailAccountPage().cardNumberFiled, paymentInfo.get(0).get("cardNumber"));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().nameOnCardNFiled);
		sendText(pomFactory.retailAccountPage().nameOnCardNFiled, paymentInfo.get(0).get("nameOnCard"));
		selectByVisibleText(pomFactory.retailAccountPage().expairationMonthFiled,
				paymentInfo.get(0).get("expirationMonth"));
		selectByVisibleText(pomFactory.retailAccountPage().expirationYearFiled,
				paymentInfo.get(0).get("expirationYear"));
		clearTextUsingSendKeys(pomFactory.retailAccountPage().securityCodeFiled);
		sendText(pomFactory.retailAccountPage().securityCodeFiled, paymentInfo.get(0).get("securityCode"));
		logger.info("Information has been edited");
	}

	@When("user click on Update Your Card button")
	public void userClickOnUpdateYourCardButton() {
		click(pomFactory.retailAccountPage().updatePaymentBttn);
		logger.info("Update Card button clicked");
	}

	@Then("message should be displayed {string}")
	public void messageShouldBeDisplayed(String actualmssg) {
		waitTillPresence(pomFactory.retailAccountPage().updatePaymentSuccessMsg);
		Assert.assertTrue(pomFactory.retailAccountPage().updatePaymentSuccessMsg.isDisplayed());
		actualmssg = pomFactory.retailAccountPage().updatePaymentSuccessMsg.getText();
		logger.info("Messge is: " + actualmssg);
	}

	// Remove Card
	@When("User click on remove option of card section")
	public void userClickOnRemoveOptionOfCardSection() {
		click(pomFactory.retailAccountPage().clickOnCard);
		click(pomFactory.retailAccountPage().removeCard);
		logger.info("Remove button clicked");
	}

	@Then("payment details should be removed")
	public void paymentDetailsShouldBeRemoved() {
		Assert.assertTrue(pomFactory.retailAccountPage().addCardBoxHeader.isDisplayed());
		logger.info("Payment details removed");
		// it passed till here
	}

	// Add Address
	@When("User click on Add address option")
	public void userClickOnAddAddressOption() {
		click(pomFactory.retailAccountPage().addAddressLink);
		logger.info("User clicked on add address button");
	}

	@When("user fill new address form with below information")
	public void userFillNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps();
		selectByVisibleText(pomFactory.retailAccountPage().addressCountryDropDown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.retailAccountPage().addressNameF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().addressPhoneF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().addressStreetF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().addressCityF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pomFactory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().addressZipCode,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
		logger.info("Address form wass filled");
	}

	@When("User click Add Your Address button")
	public void userClickAddYourAddressButton() {
		click(pomFactory.retailAccountPage().addressAddBttn);
		logger.info("Add Address Button was clicked successfully");
	}

	// Edit address
	@When("user update new address form with below information")
	public void userupdateNewAddressFormWithBelowInformation(DataTable dataTable) {
		List<Map<String, String>> addressInfo = dataTable.asMaps(String.class, String.class);
		selectByVisibleText(pomFactory.retailAccountPage().addressCountryDropDown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("country")));
		sendText(pomFactory.retailAccountPage().addressNameF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("fullName")));
		sendText(pomFactory.retailAccountPage().addressPhoneF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("phoneNumber")));
		sendText(pomFactory.retailAccountPage().addressStreetF,
				DataGenerator.addressGenerator(addressInfo.get(0).get("streetAddress")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("apt")));
		sendText(pomFactory.retailAccountPage().addressApartmentNum,
				DataGenerator.addressGenerator(addressInfo.get(0).get("city")));
		selectByVisibleText(pomFactory.retailAccountPage().addressStateDropdown,
				DataGenerator.addressGenerator(addressInfo.get(0).get("state")));
		sendText(pomFactory.retailAccountPage().addressZipCode,
				DataGenerator.addressGenerator(addressInfo.get(0).get("zipCode")));
	}

	@When("User click update Your Address button")
	public void userClickUpdateYourAddressButton() {
		click(pomFactory.retailAccountPage().updateAddressBtn);
		logger.info("Update button was clicked");

	}

	@Then("messages should be displayed {string}")
	public void messagesShouldBeDisplayed(String actualmssg) {
		waitTillPresence(pomFactory.retailAccountPage().addressUpdatedSuccessfully);
		Assert.assertTrue(pomFactory.retailAccountPage().addressUpdatedSuccessfully.isDisplayed());
		actualmssg = pomFactory.retailAccountPage().addressUpdatedSuccessfully.getText();
		logger.info("Message is: " + actualmssg);

	}

//	 
	@And("User click on remove option of Address section")
	public void userClickOnRemoveOptionOfAddressSection() {
		clickElementWithJS(pomFactory.retailAccountPage().removeAddressBtn);
		logger.info("remove button clicked");
	}

	@Then("Address details should be removed")
	public void addressDetailsShouldBeRemoved() {
		if (!isElementDisplayed(pomFactory.retailAccountPage().removeAddressBtn)) {
			logger.info("address details removed");
		}
	}
	
	@When("User click on edit address option")
	public void userClickOnEditAddressOption() {
    click(pomFactory.retailAccountPage().editAddressLink);
	}
//	  @Then("Address details should be removed")
//	  public void addressDetailsShouldBeRemoved() {
//	  	
//	  	if(!isElementDisplayed(pomFactory.retailAccountPage().addressBr));
//	  	
//	  	  logger.info("Address removed successfully");
//	  		
//	  }
}
