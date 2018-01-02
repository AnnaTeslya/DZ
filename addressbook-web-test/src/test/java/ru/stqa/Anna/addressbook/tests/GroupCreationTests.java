package ru.stqa.Anna.addressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

public class GroupCreationTests extends TestBase {

  @Test
    public void testGroupCreation() {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupDate("test", "testik", "test5"));
        app.submitGroupCreation();
        app.returnToGroupPage();
    }

}
