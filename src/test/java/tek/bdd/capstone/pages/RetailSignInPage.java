package tek.bdd.capstone.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.capstone.base.BaseSetup;

public class RetailSignInPage extends BaseSetup {
	
	public RetailSignInPage() {
		PageFactory.initElements(getDriver(), this);
	}
	//Login
	@FindBy(xpath = "//*[contains(text(),'TEKSCHOOL')]") 
    public WebElement tekschoolLogo;

	@FindBy(linkText = "Sign in")
   public WebElement signInLink;

    @FindBy(id= "email")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath ="//button[@id='loginBtn']")
    public WebElement loginBttn;
    
    @FindBy(id = "logoutBtn")
    public WebElement logoutBttn;

    //createaccount

    @FindBy(id = "newAccountBtn")
   public WebElement newAccountBttn;

    @FindBy(id = "nameInput")
    public WebElement nameInputField;
    
   @FindBy(id = "emailInput")
    public WebElement emailInputField;

   @FindBy(id = "passwordInput")
   public WebElement passwordInputField;

   @FindBy(id = "confirmPasswordInput")
    public WebElement confirmPassInputField;

    @FindBy(id = "signupBtn")
    public WebElement signupBttn;

    @FindBy(xpath = "//h1[text()='Your Profile']")
    public WebElement yourProfileText;
  
    @FindBy( id = "personalPhoneInput")
    public WebElement phoneField;
    
    @FindBy( id = "personalUpdateBtn")
    public WebElement updateBttn;
    
    @FindBy(xpath ="//div[text()='Personal Information Updated Successfully']")
    public WebElement personalInfoUpdateSuccessMssg;

    }



