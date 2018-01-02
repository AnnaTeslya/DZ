package ru.stqa.Anna.addressbook;


import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase{

  @Test
    public void testGroupCreation() {

        gotoGroupPage();
        initGroupCreation();
        fillGroupForm(new GroupDate("test", "testik", "test5"));
        submitGroupCreation();
        returnToGroupPage();
    }

}
