package ru.stqa.Anna.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelationTest extends TestBase {

    @Test
    public void testGroupDelation() {

        app.gotoGroupPage();
        app.selectGroup();
        app.deleteSelectedGroups();
        app.returnGroupPage();
    }

}