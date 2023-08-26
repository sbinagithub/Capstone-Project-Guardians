
package tek.bdd.capstone.steps;

import java.util.List;


import java.util.Map;

import org.junit.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.capstone.utilities.CommonUtility;
import tek.bdd.capstone.pages.POMFactory;

public class SignInSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@Given("User is on retail website homepage")
	public void userIsOnRetailWebsiteHomepage() {
		// here i am Verifying if TEKTEKSCHOOL logo is displayed
		Assert.assertTrue(pomFactory.signInPage().tekschoolLogo.isDisplayed());
		logger.info("TEKTEKSCHOOL logo is displayed");
	}

	@When("User click on the login link")
	public void userClickOnTheLoginLink() {
		click(pomFactory.signInPage().signInLink);
		logger.info("Login link was clicked successfully");
	}

	@When("User enter email {string} and password {string}")
	public void userEnterEmailAndPassword(String email, String password) {
		sendText(pomFactory.signInPage().emailField, email);
		sendText(pomFactory.signInPage().passwordField, password);
		logger.info("Email and password were entered successfully");
	}

	@When("User click on login button")
	public void userClickOnLoginButton() {
		click(pomFactory.signInPage().loginBttn);
		logger.info("Login button was clicked successfully");
	}

	@Then("User should be logged in into Account")
	public void userShouldBeLoggedInIntoAccount() {
		Assert.assertTrue(pomFactory.retailAccountPage().accountLink.isDisplayed());
		logger.info("Login button was clicked successfully");
	}

	// createAccount
	@When("User click on Create New Account button")
	public void userClickOnCreateNewAccountButton() {
		click(pomFactory.signInPage().newAccountBttn);
		logger.info("New Account Button is clicked");

	}

	@When("User fill the signUp information with below data")
	public void userFillTheSignUpInformationWithBelowData(DataTable dataTable) {
		List<Map<String, String>> signUpData = dataTable.asMaps(String.class, String.class);
		// here i am trying to Fill the sign-up information with data from the DataTable
		sendText(pomFactory.signInPage().nameInputField, signUpData.get(0).get("name"));
		sendText(pomFactory.signInPage().emailInputField, signUpData.get(0).get("email"));
		sendText(pomFactory.signInPage().passwordInputField, signUpData.get(0).get("password"));
		sendText(pomFactory.signInPage().confirmPassInputField, signUpData.get(0).get("confirmPassword"));
		logger.info("Sign-up information is entered successfully");

	}

	@When("User click on SignUp button")
	public void userClickOnSignUpButton() {
		// Click on the SignUp button
		click(pomFactory.signInPage().signupBttn);
		logger.info("Sign-up button is clicked successfully");
	}

	@Then("User should be logged into account page")
	public void userShouldBeLoggedIntoAccountPage() {
		// Verify if "Your Profile" text is displayed to confirm successful account
		// creation
		Assert.assertTrue(pomFactory.signInPage().yourProfileText.isDisplayed());
		logger.info("Your account is created successfully");

	}
}
