package ru.stqa.Anna.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.Anna.addressbook.model.GroupDate;
import ru.stqa.Anna.addressbook.model.Groups;

import java.util.Set;

public class GroupDelationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().GroupPage();

        if( app.group().all().size()==0){
            app.group().create(new GroupDate().withName("test101"));
        }
    }
    @Test

    public void testGroupDelation() {
        Groups before = app.group().all();
        GroupDate deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(),before.size()-1);
        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(deletedGroup)));



    }




}