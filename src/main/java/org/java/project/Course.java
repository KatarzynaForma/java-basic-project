package org.java.project;


import java.text.SimpleDateFormat;
import java.util.*;


public class Course {
    private String nameOfTheCourse;
    private Calendar startDate;
    private double courseLengthInHours;
    private double courseLengthInMinutes;
    String dayNow;

    List<String> startStop = new ArrayList<>();
    Map<String, List<String>> classDates = new TreeMap<>();
    public List<DayClass> classDays;
    List<String> finalDatesList = new ArrayList<>();


    public Course(String nameOfTheCourse, Calendar startDate, double courseLengthInHours,  Map<String, List<String>> classDates, List<DayClass> classDays, List<String> finalDatesList) {
        this.nameOfTheCourse = nameOfTheCourse;
        this.startDate = startDate;
        this.courseLengthInHours = courseLengthInHours;
        this.courseLengthInMinutes = courseLengthInHours * 60;
        this.classDates = classDates;
        this.classDays = classDays;
        this.finalDatesList = finalDatesList;
        GetDayFromDate();

    }


    public List<DayClass> getClassDays() {
        return classDays;
    }

    public Map<String, List<String>> getClassDates() {
        return classDates;
    }

    public String getNameOfTheCourse() {
        return nameOfTheCourse;
    }

    public void setNameOfTheCourse(String nameOfTheCourse) {
        this.nameOfTheCourse = nameOfTheCourse;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public double getCourseLengthInHours() {
        return courseLengthInHours;
    }

    public void setCourseLengthInHours(double courseLengthInHours) {
        this.courseLengthInHours = courseLengthInHours;
    }

    public void setClassDates(String classDate, String hourStart, String hourStop) {
        this.classDates.put(classDate, Arrays.asList(hourStart, hourStop));
    }

    public void GetDayFromDate() {
        Map<Integer, String> weekDaysNum = new HashMap<>();
        weekDaysNum.put(1, "SUNDAY");
        weekDaysNum.put(2, "MONDAY");
        weekDaysNum.put(3, "TUESDAY");
        weekDaysNum.put(4, "WEDNESDAY");
        weekDaysNum.put(5, "THURSDAY");
        weekDaysNum.put(6, "FRIDAY");
        weekDaysNum.put(7, "SATURDAY");

        Calendar cal = (startDate);
        while (courseLengthInMinutes > 0) {
            dayNow = weekDaysNum.get(cal.get(Calendar.DAY_OF_WEEK));

            for (DayClass dayNameObject : classDays) {
                if (dayNow.equals(dayNameObject.day.toUpperCase())) {
                    SimpleDateFormat format1 = new SimpleDateFormat("yyyy MM dd");
                    String classDateString = format1.format(cal.getTime());
                    startStop.add(dayNameObject.getHourStart());
                    setClassDates(classDateString, dayNameObject.getHourStart(), dayNameObject.getHourStop());
                    courseLengthInMinutes = courseLengthInMinutes - dayNameObject.getClassLengthInMinutes();
                }
            }
            cal.add(Calendar.DATE, 1);
        }
    }

    public void createListFinalDatesListFromMapClassDays() {
        for (Map.Entry<String, List<String>> entry : classDates.entrySet()) {
            finalDatesList.add(entry.getKey());

        }
    }

}


