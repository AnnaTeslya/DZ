package ru.stqa.Anna.addressbook;

import org.testng.annotations.Test;


public class CroupCreationTest extends TestBase {

    @Test
    public void testCroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupDate("test100", "test", "test"));
        submitGroupCreation();
        returnGroupPage();
    }

}
