package ru.stqa.Anna.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTest extends TestBase {
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();

    if (app.contact().all().size()==0) {
      app.contact().create(new ContactDate().
          withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobilePhone("80002221113344").withEmail("Ivanova@ail.ru"));
    }
  }

  @Test
  public void testContactModification() {
    Contacts before = app.contact().all();
    ContactDate modifiedContact = before.iterator().next();
    ContactDate contact = new ContactDate().withId(modifiedContact.getId()).withFirstname("Christina").withLastname("Alekseeva").withAddress("Russia").withMobilePhone("80002221113344").withEmail("Ivanova@ail.ru");
    app.contact().modify(contact);
    assertEquals(before.size(), app.contact().count());
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

  }

}