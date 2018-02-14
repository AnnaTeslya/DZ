package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.List;

public class ContactDeletionTest extends TestBase{
  @Test
  public void testContactDeletion(){
    app.getNavigationHelper().gotoHomePage();

    if (!app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
    }
    List<ContactDate> before = app.getContactHelper().getContactList();
    app.getContactHelper().selectContact(0);
    app.getContactHelper().deleteSelectedContacts();
    app.getContactHelper().closeAlert();
    app.getNavigationHelper().gotoHomePage();
    List<ContactDate> after = app.getContactHelper().getContactList();

    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
      Assert.assertEquals(before,after);
    }




  }
