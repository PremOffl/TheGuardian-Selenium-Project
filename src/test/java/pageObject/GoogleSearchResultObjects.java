package pageObject;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import actions.CommonUtils;
import support.CustomisedException;

public class GoogleSearchResultObjects {

	@FindBy(xpath = "//h3")
	private List<WebElement> listNewsHeadlines;

	@FindBy(xpath = "//span")
	private List<WebElement> listNewsDescriptionsInSpanTag;

	@FindBy(xpath = "//div[@role='heading']")
	private List<WebElement> listNewsDescriptionsInDivTag;

	/**
	 * This method will verify if the news is valid is not by below criteria. If the
	 * search results is more than 2 => Valid Else, Invalid
	 * 
	 * @throws CustomisedException
	 */
	public void verifyIfTheNewsIsValid() throws CustomisedException {
		String searchTerm = System.getProperty("strFirstHeadlineText");

		CommonUtils.verifyIfTheStringIsPresentInAList(listNewsHeadlines, listNewsDescriptionsInSpanTag,
				listNewsDescriptionsInDivTag, searchTerm.substring(0, searchTerm.length() / 2));
	}

}