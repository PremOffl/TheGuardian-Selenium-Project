package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import support.CustomisedException;

public class TheGuardianHomePageObjects {

	@FindBy(xpath = "(//*[contains(@class,'headline-text')])[1]")
	private WebElement LblFirstHeadlineText;

	/**
	 * This method will get the text in String format for First Headline news
	 * article
	 */
	public void getFirstHeadlineText() throws CustomisedException {
		String strFirstHeadlineText = LblFirstHeadlineText.getText();
		System.setProperty("strFirstHeadlineText", strFirstHeadlineText);
	}

}