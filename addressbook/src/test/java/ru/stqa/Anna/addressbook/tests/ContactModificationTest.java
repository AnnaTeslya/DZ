package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();

    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
    }
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(before.size()-1);
    app.getContactHelper().initContactModification();
    ContactDate contact = new ContactDate(before.get(before.size()-1).getId(),"masha", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru");
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnContactPage();
    List<ContactDate> after = app.getContactHelper().getContactList();
    Assert.assertEquals(before.size(), after.size());
    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactDate> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }
}