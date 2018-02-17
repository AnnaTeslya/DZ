package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.List;


public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        app.goTo().GroupPage();
        List<GroupDate> before = app.group().list();
        GroupDate group = new GroupDate().withName("test101");
        app.group().create(group);
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(before.size() + 1, after.size());


        before.add(group);
        Comparator<? super GroupDate> byId=(g1,g2) ->Integer.compare(g1.getId(),g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }



}
