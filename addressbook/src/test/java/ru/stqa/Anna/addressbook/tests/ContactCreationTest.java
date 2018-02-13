package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.List;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        List<ContactDate> before = app.getContactHelper().getContactList();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnContactPage();
        List<ContactDate> after = app.getContactHelper().getContactList();
        Assert.assertEquals(before.size() + 1, after.size());
    }
}
