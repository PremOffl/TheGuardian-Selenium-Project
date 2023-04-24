package stepDefinition;

import org.openqa.selenium.support.PageFactory;

import actions.Actions;
import actions.CommonUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.GoogleHomePageObjects;
import pageObject.GoogleSearchResultObjects;
import pageObject.MessageContainerOverlayPageObjects;
import pageObject.TheGuardianHomePageObjects;
import support.CustomisedException;
import support.DriverSupplier;

public class TheGuardianStepDef {

	static String URL;
	MessageContainerOverlayPageObjects messageContainerOverlay;
	TheGuardianHomePageObjects theGuardianHome;
	GoogleHomePageObjects googlePage;
	GoogleSearchResultObjects googleSearchResultPage;

	@Given("^I launch the url and navigate to (.*) section$")
	public void i_launch_the_url_and_navigate_to_tone_news_section(String path) throws Exception {
		messageContainerOverlay = PageFactory.initElements(Actions.driver, MessageContainerOverlayPageObjects.class);

		CommonUtils.setBrowserAndUrlDetails();
		DriverSupplier.launchUrl(System.getProperty("browser"), System.getProperty("url") + path);
		messageContainerOverlay.verifyNavigatedToHomepage();
	}

	@When("I select the first news in the guardians portal")
	public void i_select_the_first_news_in_the_guardians_portal() throws CustomisedException {
		theGuardianHome = PageFactory.initElements(Actions.driver, TheGuardianHomePageObjects.class);

		theGuardianHome.getFirstHeadlineText();
	}

	@When("^Search in (.*) with the first news$")
	public void search_in_google_with_the_first_news(String source) throws Exception {
		if (source.equalsIgnoreCase("google")) {
			googlePage = PageFactory.initElements(Actions.driver, GoogleHomePageObjects.class);

			googlePage.openGoogleHomePage();
			googlePage.clickAcceptAllCookies();
			googlePage.enterFirstNewsTitleInSearchBox();
		}
	}

	@Then("I verify whether the first news article is valid or invalid")
	public void i_should_see_two_or_more_article_on_same_topic_getting_displayed() throws CustomisedException {
		googleSearchResultPage = PageFactory.initElements(Actions.driver, GoogleSearchResultObjects.class);

		googleSearchResultPage.verifyIfTheNewsIsValid();
	}

}
