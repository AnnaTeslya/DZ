package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();

    if (app.contact().all().size()==0) {
      app.contact().create(new ContactDate().
          withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobile("80002221113344").withEmail("Ivanova@ail.ru"));
    }
  }
  @Test
  public void testContactModification() {
    Set<ContactDate> before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate().withId(modifiedContact.getId()).withFirstname("masha").withLastname("Ivanova").withAddress("Spain").withMobile("80002221113344").withEmail("Ivanova@ail.ru");
    app.contact().modify(contact);
    Set<ContactDate> after = app.contact().all();
    Assert.assertEquals(before.size(), after.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before,after);

  }

}