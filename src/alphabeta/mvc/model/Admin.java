package alphabeta.mvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Last edited by kristin on 14/5/17
 */

public class Admin extends Staff {

    private static Logger logger = LogManager.getLogger();

    private CourseDirectory courseDirectory = ModelHelper.getCourseDirectory();

    public Admin(String name, String password) {
        super(name, password);
    }

    //create a new course offering
    public void addNewCourseOffering(Semester semester, int maxStudents, String lecturerString, String courseString) {
        try {
            Lecturer lecturer = courseDirectory.lookupLecturer(lecturerString);
            Course course = courseDirectory.lookupCourse(courseString);
            CourseOffering courseOffering = courseDirectory.getCourseOffering(semester, maxStudents, lecturer, course);
            System.out.println("Course Offering " + courseOffering.getName()
                    + " in semester " + courseOffering.getMySemester().getSemesterNumber()
                    + " " + courseOffering.getMySemester().getYear() + " created.");
        } catch (UnsupportedOperationException e) {
            logger.error(e.getMessage());
        }
    }

    public void assignLecturerCourse(String lecturerString, String courseOfferingString) {
        try {
            Lecturer lecturer = courseDirectory.lookupLecturer(lecturerString);
            CourseOffering courseOffering = courseDirectory.lookupCourseOffering(courseOfferingString);
            courseOffering.setMyLecturer(lecturer);
            lecturer.addMyCourse(courseOffering.getMyCourse());
        } catch (UnsupportedOperationException e) {
            logger.error(e.getMessage());
        }
    }

    public void advanceSystem() {
        //increment the week by one, unless it is week 12 - in which case increment the semester. If the semester
        // is 02 - increment the year
        int week = courseDirectory.getSemester().getWeek();
        int semesterNumber = courseDirectory.getSemester().getSemesterNumber();
        //prob need to declare a final for max week in a semester
        if (week < 12) {
            courseDirectory.incrementWeek();
        } else {
            if (semesterNumber == 1) {
                courseDirectory.incrementSemester(2, courseDirectory.getSemester().getYear());
            } else {
                courseDirectory.incrementSemester(1, courseDirectory.getSemester().getYear()+1);
            }
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
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

}