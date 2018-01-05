package ru.stqa.Anna.addressbook;

import org.testng.annotations.Test;

public class GroupDelationTest extends TestBase {

    @Test
    public void testGroupDelation() {

        gotoGroupPage();
        selectGroup();
        deleteSelectedGroups();
        returnGroupPage();
    }

}