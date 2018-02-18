package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTest extends TestBase {



    @Test
    public void testContactCreation() {
        app.goTo().homePage();
        Set<ContactDate> before = app.contact().all();
        ContactDate contact = new ContactDate()
                .withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobile("80002221113344").withEmail("Ivanova@ail.ru");
        app.contact().create(contact);
        Set<ContactDate> after = app.contact().all();
        Assert.assertEquals(before.size() + 1, after.size());

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before,after);
    }


}
