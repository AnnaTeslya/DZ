package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();

    if (app.contact().list().size()==0) {
      app.contact().create(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
    }
  }
  @Test(enabled = false)
  public void testContactModification() {
    List<ContactDate> before = app.contact().list();
    int index = before.size()-1;
    ContactDate contact = new ContactDate(before.get(index).getId(),"masha", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru");
    app.contact().modify(index, contact);
    List<ContactDate> after = app.contact().list();
    Assert.assertEquals(before.size(), after.size());
    
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactDate> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }

}