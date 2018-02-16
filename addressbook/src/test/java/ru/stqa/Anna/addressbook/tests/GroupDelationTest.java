package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.List;

public class GroupDelationTest extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
        app.getNavigationHelper().gotoGroupPage();

        if( ! app.getGroupHelper().isThereAGroup()){
            app.getGroupHelper().createGroup(new GroupDate("test101", null,null));
        }
    }
    @Test
    public void testGroupDelation() {
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size()-1);
        app.getGroupHelper().deleteSelectedGroups();
        app.getGroupHelper().returnGroupPage();
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(),before.size()-1);


        before.remove(before.size()-1);
        Assert.assertEquals(before,after);
    }


}