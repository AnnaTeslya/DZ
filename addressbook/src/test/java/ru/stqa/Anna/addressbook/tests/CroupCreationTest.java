package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.List;


public class CroupCreationTest extends TestBase {

    @Test
    public void testCroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        List<GroupDate> before = app.getGroupHelper().getGroupList();

        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupDate("test101", null,null));
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().returnGroupPage();
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size() + 1, after.size());
    }

}
