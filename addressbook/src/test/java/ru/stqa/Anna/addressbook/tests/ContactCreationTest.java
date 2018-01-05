package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.ContactDate;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {

        app.getGroupHelper().initContactCreation();
        app.getGroupHelper().fillContactForm(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
        app.getGroupHelper().submitContactCreation();
        app.getGroupHelper().returnContactPage();
    }
}
