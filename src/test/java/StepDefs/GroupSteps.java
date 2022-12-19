package StepDefs;

import Pages.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupSteps
{
  private WebDriver driver;
  private static final String DRIVER_NAME = "webdriver.gecko.driver";
  private static final String DRIVER_PATH = "/home/serg/driver/geckodriver";
  private static HomePage homePage;
  private static GroupPage groupPage;
  private static GroupCardWrapper x;

  @Given("user is on home page")
  public void user_is_on_home_page()
  {
    System.setProperty(DRIVER_NAME, DRIVER_PATH);
    driver = new FirefoxDriver();
    new WebDriverWait(driver, Duration.ofSeconds(30));
    driver.manage().window().maximize();
    LoginPage loginPage = new LoginPage(driver);
    homePage = loginPage.typeUsername("technoPol30").typePassword("technoPolis2022").submitLogin();
  }

  @When("user clicks on group button")
  public void userClicksOnGroupButton()
  {
    groupPage = homePage.groupButtonClick();
  }

  @And("user sees first group")
  public void userSeesFirstGroup()
  {
    x = groupPage.enterGroup();
  }

  @And("clicks on enter button")
  public void clicksOnEnterButton()
  {
    x.enter();
  }

  @Then("^(.*) should be seen$")
  public void argShouldBeSeen(String arg)
  {
    Assert.assertEquals(arg, groupPage.getGroupEntranceMessage());
    driver.quit();
  }

  @Then("non-exist message should be visible")
  public void nonExistMessageShouldBeVisible()
  {
    String check = "У Вас нет модерируемых групп.";
    Assert.assertEquals(check, groupPage.getStubEmptyText());
    driver.quit();
  }

  @And("user enter moderate chapter with no moderate group")
  public void userEnterModelChapter()
  {
    groupPage.switchToModerate();
  }

  @And("user clicks on create group button")
  public void userClicksOnCreateGroupButton()
  {
    groupPage.goToCreateMenuButton();
  }

  @And("chooses public page")
  public void choosesPublicPage()
  {
    groupPage.choosePublicPage();
  }

  @And("insert \"123\" in name_field")
  public void insertNameInName_field()
  {
    groupPage.setGroupName("123");
  }

  @And("insert \"Автомойка\" in theme_field")
  public void insertThemeInTheme_field()
  {
    groupPage.setGroupTheme("Автомойка");
  }

  @And("clicks on create button")
  public void clicksOnCreateButton()
  {
    groupPage.createGroup();
  }

  @Then("new group name should be equal to name in name_field and theme should be equal to theme in theme_field")
  public void newGroupNameShouldBeEqualToNameInName_fieldAndThemeShouldBeEqualToThemeInTheme_field()
  {
    Assert.assertTrue("123".equals(groupPage.getNewGroupName()) && "Автомойка".equals(groupPage.getNewGroupTheme()));
    driver.close();
  }
}
