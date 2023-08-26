package tek.bdd.capstone.steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import tek.bdd.capstone.pages.POMFactory;
import tek.bdd.capstone.utilities.CommonUtility;

public class HomeSteps extends CommonUtility {

	POMFactory pomFactory = new POMFactory();

	@When("User click on All section")
	public void userClickOnAllSection1() {
		click(pomFactory.retailHomePage().allOptions);
		logger.info("All Options dropdown was clicked");
	}

	@Then("below options are present in Shop by Department sidebar")
	public void belowOptionsArePresentInShopByDepartmentSidebar(DataTable dataTable) {
		List<List<String>> departmentOption = dataTable.asLists(String.class);
		for (int i = 0; i < departmentOption.get(0).size(); i++) {
			Assert.assertTrue(isElementDisplayed(getDriver().findElement(By.xpath(
			"//div[@class='sidebar__content']//span[text()='" + departmentOption.get(0).get(i) + "']"))));
			logger.info("Option " + departmentOption.get(0).get(i) + "is displayed");
		}
	}
	@When("User on {string}")
	public void userOnDepartment(String department) {
		List<WebElement> departments = pomFactory.retailHomePage().sidebarAllOption;
		for (int i = 0; i < departments.size(); i++) {
			if (departments.get(i).getText().equalsIgnoreCase(department)) {
				departments.get(i).click();
				break;

			}
		}
	}

	@Then("below options are present in department")
	public void belowOptionsArePresentInDepartment(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> departmentOption = dataTable.asLists(String.class);
		List<WebElement> option = pomFactory.retailHomePage().sidebarAllOption;
		for (int i = 0; i < option.size(); i++) {
			for (WebElement element : option) {
				if (element.getText().equalsIgnoreCase(departmentOption.get(0).get(i))) {
					Assert.assertTrue(element.isDisplayed());
					logger.info("All option" + option + "is displayed");
				}

			}

		}
	}
}
