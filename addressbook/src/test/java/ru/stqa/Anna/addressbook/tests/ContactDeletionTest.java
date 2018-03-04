package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTest extends TestBase{
  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().homePage();
    if (app.contact().all().size()==0){
      app.contact().create(new ContactDate().withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobilePhone("80002221113344").withEmail("Ivanova@ail.ru"));
    }
  }
  @Test
  public void testContactDeletion(){
    Contacts before = app.contact().all();
    ContactDate deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    app.goTo().homePage();
    assertEquals(app.contact().count(),before.size()-1);
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));

    }



}
