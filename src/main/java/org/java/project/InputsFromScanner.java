package org.java.project;

import org.apache.commons.collections4.list.TreeList;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputsFromScanner {


    Scanner scanner = new Scanner(System.in);
    List<ParticipantData> participantsList = new TreeList<>();

    List<DayClass> classDays = new ArrayList<>();
    Calendar startDate = Calendar.getInstance();



    public void provideParticipantsData() {
        while (true) {
            System.out.println("Provide a name (If there are no other participants press ENTER):");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.println("Provide a Phone Number:");
            String phoneNumber = scanner.nextLine();

            System.out.println("Provide an e-mail:");
            String email = scanner.nextLine();

            participantsList.add(new ParticipantData(name, phoneNumber, email));

        }
    }
     public List<String> getNameOfParticipant() {
         return participantsList.stream()
                 .map(ParticipantData::getName)
                 .collect(Collectors.toList());
     }

     public String getNameOfTheCourse(){
        System.out.println("Enter name of the course:");
        String nameOfTheCourse = scanner.nextLine();
        return nameOfTheCourse;

     }

     public double getCourseLengthInHours(){
        System.out.println("Enter duration of the Course in hours:");
        double courseLengthInHours = scanner.nextDouble();
        return courseLengthInHours;
     }

     public List<DayClass> provideTheDaysAndHoursOfLessons(){
        while(true) {
            System.out.println("Enter day of week (If there are no other days press ENTER):");
            String classDay = scanner.nextLine();
            if (classDay.equals("")) {
                break;
            }
            System.out.println("Enter start hour in format hh:mm");
            String hourStart = scanner.nextLine();

            System.out.println("Enter end hour in format hh:mm");
            String hourStop = scanner.nextLine();

            classDays.add(new DayClass(classDay, hourStart, hourStop));
        }
        return classDays;
     }

     public Calendar provideStartDateOfCourse(){
        System.out.println("Please provide the first day of the course. Enter the Year in format YYYY: ");
        int startYear = scanner.nextInt();
        System.out.println("Enter the Month in format MM: ");
        int startMonth = scanner.nextInt()- 1;
        System.out.println("Enter the Day in format DD: ");
        int startDayMonth = scanner.nextInt();

        startDate.set(startYear, startMonth, startDayMonth);
        return startDate;
     }


}








