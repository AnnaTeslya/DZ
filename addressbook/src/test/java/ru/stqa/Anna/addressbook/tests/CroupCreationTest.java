package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;


public class CroupCreationTest extends TestBase {

    @Test
    public void testCroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupDate("test100", null,null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupPage();
    }

}
