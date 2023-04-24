package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import actions.Actions;
import actions.CommonUtils;
import support.CustomisedException;

public class MessageContainerOverlayPageObjects {

	@FindBy(xpath = "//div[@class='message-component message-row']")
	private WebElement messageContainerOverlay;
	@FindBy(xpath = "//button[contains(@class,'btn-primary')]")
	private WebElement btnYesIamHappy;
	@FindBy(xpath = "//iframe[contains(@id,'sp_message_iframe')]")
	private WebElement iFrameForMessageOverlay;

	/**
	 * This method handles the message overlay pop-up and prepares the script for
	 * other actions from the guardian homepage
	 * 
	 * @throws InterruptedException
	 */
	public void verifyNavigatedToHomepage() throws CustomisedException, InterruptedException {
		WebElement iframeWlement = Actions.driver.findElement(By.xpath("//iframe[contains(@id,'sp_message_iframe')]"));
		CommonUtils.switchToIframe(iframeWlement);
//		CommonUtils.switchToIframe(iFrameForMessageOverlay);

		WebElement btnYesIamHappy = Actions.driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]"));
//		Actions.click(btnYesIamHappy);
		Actions.clickIfExists(btnYesIamHappy);
	}

}