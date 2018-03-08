package ru.stqa.Anna.addressbook.tests;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase{
  @Test
  public void testContactPhones(){
    app.goTo().homePage();
    ContactDate contact = app.contact().all().iterator().next();
    ContactDate contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(),equalTo(mergePhones(contactInfoFromEditForm)));
  }

  private  String mergePhones(ContactDate contact) {
    return  Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(),contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals("")).map(ContactPhoneTest::cleaned).collect(Collectors.joining("\n"));
  }

  public static  String cleaned(String phone){
    return phone.replaceAll("\\s","").replaceAll("[-()]","");
  }
}

