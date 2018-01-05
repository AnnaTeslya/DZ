package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;


public class CroupCreationTest extends TestBase {

    @Test
    public void testCroupCreation() {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupDate("test100", "test", "test"));
        app.submitGroupCreation();
        app.returnGroupPage();
    }

}
