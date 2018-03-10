package ru.stqa.Anna.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.Contacts;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    type(By.name("mobile"), contactDate.getMobilePhone());
    type(By.name("email"), contactDate.getEmail());
    attache(By.name("photo"), contactDate.getPhoto());
  }

  public void initContactCreation() {click(By.linkText("add new"));}

  public void selectContact(int index) {wd.findElements(By.name("selected[]")).get(index).click();}
  public void selectContactById(int id) {wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();}

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }



  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void create(ContactDate contact) {
    initContactCreation();
    fillContactForm(contact);
    submitContactCreation();
    contactCache = null;
    returnContactPage();
  }

  public void delete(ContactDate contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
    closeAlert();
  }
  public void modify(ContactDate contact) {
    initContactModificationById(contact.getId());
    fillContactForm(contact);
    submitContactModification();
    contactCache = null;
    returnContactPage();
  }


    public void initContactModification(int id) { click(By.tagName("edit"));}


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;
  public Contacts all() {
    if(contactCache!=null){
      return new Contacts(contactCache);
    }
   contactCache= new Contacts();


    //List<WebElement> elements = wd.findElements(By.name("entry"));
    //for (WebElement element : elements) {
     // String firstname = element.findElements(By.tagName("td")).get(2).getText();
     // String lastname = element.findElements(By.tagName("td")).get(1).getText();
    //  int id =Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      //contactCache.add(new ContactDate().withId(id).withFirstname(firstname).withLastname(lastname));
    //}

  List<WebElement> rows = wd.findElements(By.name("entry"));
    for(WebElement row: rows) {
      List<WebElement> cells= row.findElements(By.tagName("td"));
    int id =Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));

      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String allphones = cells.get(5).getText();
      String allemails=cells.get(4).getText();
      contactCache.add(new ContactDate().withId(id).withFirstname(firstname).withLastname(lastname).withAllPhones(allphones).withAllEmails(allemails));
  }
    return new Contacts(contactCache);
}

  public ContactDate infoFromEditForm(ContactDate contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lasttname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("vaue");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    return new ContactDate().withId(contact.getId()).withFirstname(firstname).withLastname(lasttname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address)
            .withEmail(email).withEmail(email).withEmail2(email2).withEmail3(email3);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value ='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

}
