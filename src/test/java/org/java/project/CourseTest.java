package org.java.project;

import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class CourseTest {

    @Test
    public void shouldGetNameFromTheDate(){
        Map<Integer, String> weekDaysNum = new HashMap<>();
        weekDaysNum.put(1, "SUNDAY");
        weekDaysNum.put(2, "MONDAY");
        weekDaysNum.put(3, "TUESDAY");
        weekDaysNum.put(4, "WEDNESDAY");
        weekDaysNum.put(5, "THURSDAY");
        weekDaysNum.put(6, "FRIDAY");
        weekDaysNum.put(7, "SATURDAY");

        Calendar startDate = Calendar.getInstance();
        int startYear = 2020;
        int startMonth = 07;
        int startDateMonth = 20;
        startDate.set(startYear, startMonth-1, startDateMonth);

        Calendar cal = (startDate);
        String dayNow = weekDaysNum.get(cal.get(Calendar.DAY_OF_WEEK));
        String expectedResult = "MONDAY";
        Assert.assertEquals(expectedResult, dayNow);
    }
}
