package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import actions.Actions;
import actions.CommonUtils;
import support.CustomisedException;
import support.FileHandling;

public class GoogleHomePageObjects {

//================================================================================ 
// Objects for "Accept All Cookies" pop-up
//================================================================================
	
	@FindBy(id = "L2AGLb")
	private WebElement btnAcceptAllCookies;
	

//================================================================================ 
// Objects for "Google Home Page"
//================================================================================	

	@FindBy(xpath = "//textarea[@title='Search']")
	private WebElement txtSearch;
	@FindBy(xpath = "(//input[@value='Google Search'])[2]")
	private WebElement btnSearch;

	/**
	 * This method will click on "Accept All" button from the pop-up => which is a
	 * one time pop-up when we open google.com for the first time
	 */
	public void clickAcceptAllCookies() throws CustomisedException {
		Actions.clickIfExists(btnAcceptAllCookies);
	}

	/**
	 * This method opens 'Google.com' in a new tab/window
	 * 
	 * @throws Exception
	 */
	public void openGoogleHomePage() throws Exception {
		CommonUtils.openURLInSameTab(FileHandling.getProperty("googleUrl"));
	}

	/**
	 * This method enters the previously stored 'strFirstHeadlineText' in the search
	 * box and clicks search button
	 * 
	 * @throws CustomisedException
	 */
	public void enterFirstNewsTitleInSearchBox() throws CustomisedException {
		Actions.enterText(txtSearch, System.getProperty("strFirstHeadlineText"));
		Actions.click(btnSearch);
	}

}