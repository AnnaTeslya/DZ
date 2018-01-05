package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelationTest extends TestBase {

    @Test
    public void testGroupDelation() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
    }

}