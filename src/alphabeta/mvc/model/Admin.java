package alphabeta.mvc.model;

import alphabeta.mvc.systemDAL.FactoryDAO;
import alphabeta.mvc.systemDAL.ICourseOfferingDAO;

/**
 * Last edited by kristin on 14/5/17
 */

public class Admin extends Staff {

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();

    public Admin(String name, String password) {
        super(name, password);
    }

    //create a new course offering
    public void addNewCourseOffering(Semester semester, int maxStudents, String lecturerString, String courseString) {
        try {
            Lecturer lecturer = courseDirectory.lookupLecturer(lecturerString);
            Course course = courseDirectory.lookupCourse(courseString);
            CourseOffering courseOffering = courseDirectory.getCourseOffering(semester, maxStudents, lecturer, course);
            System.out.println("Course Offering " + courseOffering.getName() + " in semester " + courseOffering.getMySemester().getSemesterNumber()
                    + " " + courseOffering.getMySemester().getYear() + " created.");
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void assignLecturerCourse(String lecturerString, String courseOfferingString) {
       try {
           Lecturer lecturer = courseDirectory.lookupLecturer(lecturerString);
           CourseOffering courseOffering = courseDirectory.lookupCourseOffering(courseOfferingString);
           courseOffering.setMyLecturer(lecturer);
       }
       catch (UnsupportedOperationException e) {
           System.out.println(e.getMessage());
       }
    }

    public void advanceSystem() {
        //increment the week by one, unless it is week 12 - in which case increment the semester. If the semester
        // is 02 - increment the year
        int year = courseDirectory.getSemester().getYear();
        int week = courseDirectory.getSemester().getWeek();
        int semesterNumber = courseDirectory.getSemester().getSemesterNumber();
        //prob need to declare a final for max week in a semester
        if (week > 11) {
            if (semesterNumber > 01) {
                year++;
                courseDirectory.getSemester().setYear(year);
            }
            else {
                semesterNumber++;
                courseDirectory.getSemester().setSemesterNumber(semesterNumber);
            }
        }
        else {
            week++;
            courseDirectory.getSemester().setWeek(week);
        }
        System.out.println("Semester advanced. It is now week " + courseDirectory.getSemester().getWeek() +
                " in semester " + courseDirectory.getSemester().getSemesterNumber() + " in " +
                courseDirectory.getSemester().getYear() + ".");
    }

    public void setMaxStudents(int maxStudents, String courseOfferingString) {
        try {
            CourseOffering courseOffering = courseDirectory.lookupCourseOffering(courseOfferingString);
            courseOffering.setMaxStudents(maxStudents);
            System.out.println("Max number of students is: " + courseOffering.getMaxStudents() +
                    " for " + courseOffering.getName());
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

}