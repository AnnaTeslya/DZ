package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;


public class CroupCreationTest extends TestBase {

    @Test
    public void testCroupCreation() {

        app.getNavigationHelper().gotoGroupPage();
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        GroupDate group = new GroupDate("test101", null, null);
        app.getGroupHelper().createGroup(group);
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(before.size() + 1, after.size());


        before.add(group);
        Comparator<? super GroupDate> byId=(g1,g2) ->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }



}
