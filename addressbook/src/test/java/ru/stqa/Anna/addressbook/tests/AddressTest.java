package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddressTest extends  TestBase {
  @Test
  public  void testAddress(){
    app.goTo().homePage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(),equalTo(contactInfoFromEditForm.getAddress()));

  }
}
