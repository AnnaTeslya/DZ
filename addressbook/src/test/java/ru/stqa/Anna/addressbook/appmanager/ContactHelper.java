package ru.stqa.Anna.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.ArrayList;
import java.util.List;

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
    type(By.name("firstname"), contactDate.getFirstname());
    type(By.name("lastname"), contactDate.getLastname());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("email"), contactDate.getEmail());

  }

  public void initContactCreation() {
    click(By.linkText("add new"));

  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();

  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void createContact(ContactDate contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    returnContactPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactDate> getContactList() {
List <ContactDate> contacts= new ArrayList<ContactDate>();
    List<WebElement> elements = wd.findElements(By.cssSelector("td.entry"));

    for (WebElement element : elements) {
      String firstname = element.findElement(By.cssSelector("firstname")).getText();
      String lastname = element.findElement(By.cssSelector("lastname")).getText();
      int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactDate contact = new ContactDate(id, firstname, lastname, null,null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
