package org.java.project;

import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<String> finalDatesList  =  new ArrayList<>();
        Map<String, List<String>> classDates = new TreeMap<>();
        InputsFromScanner inputsFromScanner = new InputsFromScanner();
        ExcelGenerator excelGenerator = new ExcelGenerator();

        inputsFromScanner.provideParticipantsData();
        List<String> participants = inputsFromScanner.getNameOfParticipant();

        String nameOfTheCourse = inputsFromScanner.getNameOfTheCourse();
        List<DayClass> classDays = inputsFromScanner.provideTheDaysAndHoursOfLessons();
        Calendar startDate = inputsFromScanner.provideStartDateOfCourse();
        double courseLengthInHours =inputsFromScanner.getCourseLengthInHours();

        Course course = new Course(nameOfTheCourse,  startDate, courseLengthInHours, classDates, classDays, finalDatesList);
        course.createListFinalDatesListFromMapClassDays();


        Workbook workbook = new XSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();

        Sheet sheet1 = workbook.createSheet("Attendance");
        Sheet sheet2 = workbook.createSheet("Course Information");

        excelGenerator.generateHeaderRowOfAttendanceSheet(workbook, sheet1, finalDatesList );
        excelGenerator.generateNamesInFirstCellsOfAttendanceSheet( workbook, participants, sheet1);
        excelGenerator.generateFirstTableOfCourseInformation(sheet2, nameOfTheCourse, courseLengthInHours, finalDatesList);
        excelGenerator.generateSecondTableOfCourseInformation(sheet2, classDates);

        for(int i = 0; i <= finalDatesList.size()+1; i++) {
            sheet1.autoSizeColumn(i);
        }
        for(int i = 0; i <= 3; i++) {
            sheet2.autoSizeColumn(i);
        }

        try (OutputStream fileOut = new FileOutputStream("project.xlsx")) {
            workbook.write(fileOut);
        }


    }
}
