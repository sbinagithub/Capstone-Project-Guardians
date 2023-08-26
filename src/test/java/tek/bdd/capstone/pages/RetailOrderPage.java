package tek.bdd.capstone.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tek.bdd.capstone.base.BaseSetup;

public class RetailOrderPage extends BaseSetup{
	
   public RetailOrderPage() {
	   PageFactory.initElements(getDriver(), this);
   }
   @FindBy(id = "search")
	public WebElement allDepartmentDropdown;
	
	@FindBy(id = "searchInput")
	public WebElement searchInputField;
	
	@FindBy(id = "searchBtn")
	public WebElement searchBttn;
	
	@FindBy(xpath = "//img[@alt='Kasa Outdoor Smart Plug']")
	public WebElement itemkasaoutdoorsmartplug;
	
	@FindBy(xpath = "//select[starts-with(@class,'product')]")
	public WebElement qtyDropdown;
	
	@FindBy(id = "addToCartBtn")
	public WebElement addToCartBttn;
	
	@FindBy(xpath = "//span[@id='cartQuantity']")
	public WebElement cartItemQty;
	
	@FindBy(id = "cartBtn")
	public WebElement cartBttn;
	
	@FindBy(xpath = "//button[@id='proceedBtn']")
	public WebElement proceedToCheckoutBttn;
	
	@FindBy(id = "placeOrderBtn")
	public WebElement placeOrderBttn;
	
	@FindBy(xpath = "//div[text()='Order Placed Successfully']")
	public WebElement orderPlacedSuccessfullyMssg;
	
	@FindBy(xpath = "//img[starts-with(@alt,'Apex Legends')]")
	public WebElement apexLegendsItem;
	
	@FindBy(xpath = "//p[@class='order__header-btn'][normalize-space()='Show Details'])[1]")
	public WebElement showItems;
			
	//Cancel order
	@FindBy(id = "orderLink")
	public WebElement OrderLink;
	
	@FindBy(xpath = "//div[@class='order']//descendant::p[7]")
	public List<WebElement> listOfOrders;
	
	@FindBy(xpath = "//button[text()='Cancel The Order']")
	public List<WebElement> cancelOrderBttn;
	
	@FindBy(id = "reasonInput")
	public WebElement reasonForCancelation;
	
	@FindBy(id = "orderSubmitBtn")
	public WebElement cancelationSubmitBttn;
	
	@FindBy(xpath = "//p[text()='Your Order Has Been Cancelled']")
	public WebElement orderCancelledSuccessMssg;
	
	//Return Order
		@FindBy(xpath= "//div[@class='order']")
		public WebElement firstOrderOnTheList;
		
		@FindBy(id="returnBtn")
		public WebElement returnOrderBttn;

		@FindBy(id="reasonInput")
		public WebElement listOfReturnReason;

		@FindBy(id="dropOffInput")
		public WebElement dropOffOptions;

		@FindBy(id="orderSubmitBtn")
		public WebElement submitReturnOrder;
		
		@FindBy(xpath= "//div[@class='return__confirm-card ']")
		public WebElement returnConfirmMssg;
		
		//review on order place
	    @FindBy(xpath="//button[@id='reviewBtn']") 
	    public WebElement reviewBtn;
	    
	    @FindBy(xpath="//input[@id='headlineInput']") 
	    public WebElement headlineInputField;
	    
	    @FindBy(xpath="//textarea[@name='comment']") 
	    public WebElement commentField;
	    
	    @FindBy(xpath="//button[@id='reviewSubmitBtn']") 
	    public WebElement addReviewBtn;
	    
	    @FindBy(xpath="//div[text()='Your review was added successfully']") 
	    public WebElement reviewAddedSuccessMsg;

}
