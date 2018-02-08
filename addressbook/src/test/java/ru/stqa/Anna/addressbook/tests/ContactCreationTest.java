package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnContactPage();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(before + 1, after);
    }
}
