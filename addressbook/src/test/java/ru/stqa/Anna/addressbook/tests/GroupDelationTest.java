package ru.stqa.Anna.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;

import java.util.List;

public class GroupDelationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().GroupPage();

        if( app.group().list().size()==0){
            app.group().create(new GroupDate().withName("test101"));
        }
    }
    @Test
    public void testGroupDelation() {
        List<GroupDate> before = app.group().list();
        int index =before.size()-1;
        app.group().delete(index);
        List<GroupDate> after = app.group().list();
        Assert.assertEquals(after.size(),before.size()-1);


        before.remove(index);
        Assert.assertEquals(before,after);
    }




}