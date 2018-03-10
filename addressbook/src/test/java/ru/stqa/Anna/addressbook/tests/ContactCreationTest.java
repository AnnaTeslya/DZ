package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {
    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/BgIvhERNKJg.jpg");
        ContactDate contact = new ContactDate().withFirstname("Anna").withLastname("Ivanova").withAddress("Spain")
                .withMobilePhone("80002221113344").withEmail("Ivanova@ail.ru").withPhoto(photo);
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(app.contact().count(), equalTo(before.size()+1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }
    @Test(enabled = false)
    public void testBadContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactDate contact = new ContactDate().withFirstname("Anna'").withLastname("Ivanova").withAddress("Spain")
                .withMobilePhone("80002221113344").withEmail("Ivanova@ail.ru");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));
    }


}
