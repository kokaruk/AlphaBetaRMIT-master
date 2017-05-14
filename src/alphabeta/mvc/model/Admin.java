package alphabeta.mvc.model;

/**
 * Last edited by kristin on 14/5/17
 */

public class Admin extends Staff {

    public Admin(String name, String password) {
        super(name, password);
    }

    //create a new course offering
    public void addNewCourseOffering(Semester semester, int maxStudents, String lecturerString, String courseString) {
        try {
            Lecturer lecturer = CourseDirectory.lookupLecturer(lecturerString);
            Course course = CourseDirectory.lookupCourse(courseString);
            CourseOffering courseOffering = new CourseOffering(semester, maxStudents, lecturer, course);
            System.out.println("Course Offering " + courseOffering.getName() + " in semester " + courseOffering.getMySemester().getSemesterNumber()
                    + " " + courseOffering.getMySemester().getYear() + " created.");
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void assignLecturerCourse(String lecturerString, String courseOfferingString) {
       try {
           Lecturer lecturer = CourseDirectory.lookupLecturer(lecturerString);
           CourseOffering courseOffering = CourseDirectory.lookupCourseOffering(courseOfferingString);
           courseOffering.setMyLecturer(lecturer);
       }
       catch (UnsupportedOperationException e) {
           System.out.println(e.getMessage());
       }
    }

    public void advanceSystem() {
        //increment the week by one, unless it is week 12 - in which case increment the semester. If the semester
        // is 02 - increment the year
        int year = CourseDirectory.getSemester().getYear();
        int week = CourseDirectory.getSemester().getWeek();
        int semesterNumber = CourseDirectory.getSemester().getSemesterNumber();
        //prob need to declare a final for max week in a semester
        if (week > 11) {
            if (semesterNumber > 01) {
                year++;
                CourseDirectory.getSemester().setYear(year);
            }
            else {
                semesterNumber++;
                CourseDirectory.getSemester().setSemesterNumber(semesterNumber);
            }
        }
        else {
            week++;
            CourseDirectory.getSemester().setWeek(week);
        }
        System.out.println("Semester advanced. It is now week " + CourseDirectory.getSemester().getWeek() +
                " in semester " + CourseDirectory.getSemester().getSemesterNumber() + " in " +
                CourseDirectory.getSemester().getYear() + ".");
    }

    public void setMaxStudents(int maxStudents, String courseOfferingString) {
        try {
            CourseOffering courseOffering = CourseDirectory.lookupCourseOffering(courseOfferingString);
            courseOffering.setMaxStudents(maxStudents);
            System.out.println("Max number of students is: " + courseOffering.getMaxStudents() +
                    " for " + courseOffering.getName());
        }
        catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }

}