package ru.stqa.Anna.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {


    @Test
    public void testContactCreation() {

        initContactCreation();
        fillContactForm(new ContactDate("Anna", "Ivanova", "Spain", "80002221113344", "Ivanova@ail.ru"));
        submitContactCreation();
        returnContactPage();
    }
}
