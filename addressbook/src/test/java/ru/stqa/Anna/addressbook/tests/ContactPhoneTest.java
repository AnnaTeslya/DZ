package ru.stqa.Anna.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

public class ContactPhoneTest extends TestBase{
  @Test(enabled = false)
  public void testContactPhones(){
    app.goTo().homePage();
    ContactDate contact = app.contact().all().iterator().next();
  ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

  }
}

