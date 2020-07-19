package org.java.project;

import org.junit.Assert;
import org.junit.Test;

public class DayClassTest {

    @Test
    public void ShouldReturnLengthClassInMinutes(){

        DayClass dayClass = new DayClass("Monday", "09:00", "10:30");
        int result = dayClass.getClassLengthInMinutes();
        int expectedResult = 90;
        Assert.assertEquals(expectedResult, result);

    }
}
