package ru.stqa.Anna.addressbook.appmanager;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  FirefoxDriver wd;
  private  SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private  GroupAndContactHelper groupHelper;

  public static boolean isAlertPresent(FirefoxDriver wd) {
      try {
          wd.switchTo().alert();
          return true;
      } catch (NoAlertPresentException e) {
          return false;
      }
  }

  public void init() {
   wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
   wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/index.php");
    groupHelper = new GroupAndContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login("secret", "admin");
  }

  public void stop() {
    wd.quit();
  }

  public GroupAndContactHelper getGroupHelper() {
    return groupHelper;
  }

  public NavigationHelper getNavigationHelper() {
    return navigationHelper;
  }

  public SessionHelper getSessionHelper() {
    return sessionHelper;
  }
}
