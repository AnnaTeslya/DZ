package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {



    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactDate contact = new ContactDate()
                .withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobile("80002221113344").withEmail("Ivanova@ail.ru");
        app.contact().create(contact);
        Contacts after = app.contact().all();
        assertThat(before.size() + 1, equalTo(after.size()));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }


}
