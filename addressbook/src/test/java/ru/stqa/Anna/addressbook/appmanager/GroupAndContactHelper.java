package ru.stqa.Anna.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.GroupDate;

public class GroupAndContactHelper {
 private FirefoxDriver wd;

  public GroupAndContactHelper(FirefoxDriver wd) {
    this.wd=wd;
  }

  public void returnGroupPage() {
      wd.findElement(By.linkText("group page")).click();
  }

  public void submitGroupCreation() {
      wd.findElement(By.name("submit")).click();
  }

  public void fillGroupForm(GroupDate groupDate) {
      wd.findElement(By.name("group_name")).click();
      wd.findElement(By.name("group_name")).clear();
      wd.findElement(By.name("group_name")).sendKeys(groupDate.getName());
      wd.findElement(By.name("group_header")).click();
      wd.findElement(By.name("group_header")).clear();
      wd.findElement(By.name("group_header")).sendKeys(groupDate.getHeader());
      wd.findElement(By.name("group_footer")).click();
      wd.findElement(By.name("group_footer")).clear();
      wd.findElement(By.name("group_footer")).sendKeys(groupDate.getFooter());
  }

  public void initGroupCreation() {
      wd.findElement(By.name("new")).click();
  }

  public void deleteSelectedGroups() {
      wd.findElement(By.name("delete")).click();
  }

  public void selectGroup() {
      wd.findElement(By.name("selected[]")).click();
  }

  public void returnContactPage() {
      wd.findElement(By.linkText("home page")).click();
  }

  public void submitContactCreation() {
      wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactDate contactDate) {
      wd.findElement(By.name("firstname")).click();
      wd.findElement(By.name("firstname")).clear();
      wd.findElement(By.name("firstname")).sendKeys(contactDate.getFirstname());
      wd.findElement(By.name("lastname")).click();
      wd.findElement(By.name("lastname")).clear();
      wd.findElement(By.name("lastname")).sendKeys(contactDate.getLastname());
      wd.findElement(By.name("address")).click();
      wd.findElement(By.name("address")).clear();
      wd.findElement(By.name("address")).sendKeys(contactDate.getAddress());
      wd.findElement(By.name("theform")).click();
      wd.findElement(By.name("mobile")).click();
      wd.findElement(By.name("mobile")).clear();
      wd.findElement(By.name("mobile")).sendKeys(contactDate.getMobile());
      wd.findElement(By.name("email")).click();
      wd.findElement(By.name("email")).clear();
      wd.findElement(By.name("email")).sendKeys(contactDate.getEmail());
  }

  public void initContactCreation() {
      wd.findElement(By.linkText("add new")).click();
  }
}
