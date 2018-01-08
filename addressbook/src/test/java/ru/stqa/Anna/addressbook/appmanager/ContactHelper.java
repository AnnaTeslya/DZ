package ru.stqa.Anna.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.Anna.addressbook.model.ContactDate;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }
  public void returnContactPage() {
    click(By.linkText("home page"));
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactDate contactDate) {
    type(By.name("firstname"),contactDate.getFirstname());
    type(By.name("lastname"),contactDate.getLastname());
    type(By.name("address"),contactDate.getAddress());
    type(By.name("mobile"),contactDate.getMobile());
    type(By.name("email"),contactDate.getEmail());

  }

  public void initContactCreation() {
    click(By.linkText("add new"));

  }

  public void selectContact() {
    click(By.id("20"));

  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[5]/td[8]/a/img"));

  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

}
