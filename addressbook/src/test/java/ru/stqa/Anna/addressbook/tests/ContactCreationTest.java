package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase {



    @Test(enabled = false)
    public void testContactCreation() {
        app.goTo().homePage();
        List<ContactDate> before = app.contact().list();
        ContactDate contact = new ContactDate()
                .withFirstname("Anna").withLastname("Ivanova").withAddress("Spain").withMobile("80002221113344").withEmail("Ivanova@ail.ru");
        app.contact().create(contact);
        List<ContactDate> after = app.contact().list();
        Assert.assertEquals(before.size() + 1, after.size());

        before.add(contact);
        Comparator<? super ContactDate> byId = (c1,c2) -> Integer.compare(c1.getId(),c2.getId());
        before.sort(byId);
        after.sort(byId);
       Assert.assertEquals(before,after);
    }


}
