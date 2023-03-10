package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage
{
  @FindBy(xpath = "//*[@data-l = 't,userAltGroup']")
  protected static WebElement GROUP_PAGE_BUTTON;
  @FindBy(xpath = "//*[@data-l = 't,userPage']")
  protected static WebElement USERNAME_FIELD;

  private final WebDriver driver;

  public HomePage(WebDriver driver)
  {
    this.driver = driver;
    PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
  }

  public GroupPage groupButtonClick()
  {
    GROUP_PAGE_BUTTON.click();
    return new GroupPage(driver);
  }

  public String getUserName()
  {
    return USERNAME_FIELD.getText();
  }
}
