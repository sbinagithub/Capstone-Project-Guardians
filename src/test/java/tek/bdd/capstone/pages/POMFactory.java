package tek.bdd.capstone.pages;

import tek.bdd.capstone.base.BaseSetup;

import tek.bdd.capstone.steps.RetailAccountSteps;
import tek.bdd.capstone.pages.POMFactory;

public class POMFactory extends BaseSetup {

	private RetailHomePage retailHomePage;
	private RetailSignInPage signInPage;
	private RetailAccountPage retailAccountPage;
	private RetailOrderPage retailOrderPage;

	// we create just one constractor
	public POMFactory() {
		this.retailHomePage = new RetailHomePage();
		this.signInPage = new RetailSignInPage();
		this.retailAccountPage = new RetailAccountPage();
		this.retailOrderPage = new RetailOrderPage();
	}

	// then we ceate get methed
	public RetailHomePage retailHomePage() {
		return this.retailHomePage;
	}

	public RetailSignInPage signInPage() {
		return this.signInPage;
	}

	public RetailAccountPage retailAccountPage() {
		return this.retailAccountPage;
	}

	public RetailOrderPage retailOrderPage() {
		return this.retailOrderPage;
	}
}
