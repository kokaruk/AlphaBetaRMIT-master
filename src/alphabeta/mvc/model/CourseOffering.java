package alphabeta.mvc.model;

/**
 * Created by Bill Thompson on 9/4/17.
 * Course Offering Class
 * Last edited by kristin on 13/5/17
 */
public class CourseOffering {

    Semester mySemester;
    String name;
    private int maxStudents;
    private Lecturer myLecturer;
    private Course myCourse;


    // Construct a Course Offering with specific variables, same as above plus course
    public CourseOffering(Semester mySemester, int maxStudents, Lecturer myLecturer, Course myCourse) {
        this.mySemester = mySemester;
        this.maxStudents = maxStudents;
        this.myLecturer = myLecturer;
        this.myCourse = myCourse;
        CourseDirectory.addCourseOffering(this);
    }

    public String getName() {
        if (this.name == null)
            this.name = String.format("%d %d %s", mySemester.year, mySemester.semesterNumber, myCourse.name);
        return name;
    }

    Course getMyCourse() {
        return myCourse;
    }

    public void setMyCourse(Course myCourse) {
        this.myCourse = myCourse;
    }

    Semester getMySemester() {
        return mySemester;
    }

    public void setMySemester(Semester mySemester) {
        this.mySemester = mySemester;
    }

    int getMaxStudents() {
        return maxStudents;
    }

    void setMaxStudents(int maxStudents) {
        this.maxStudents = maxStudents;
    }

    public Lecturer getMyLecturer() {
        return myLecturer;
    }

    public void setMyLecturer(Lecturer myLecturer) {
        this.myLecturer = myLecturer;
    }
}
