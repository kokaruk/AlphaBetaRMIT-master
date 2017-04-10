package alphabeta.mvc.model;

/**
 * Created by Bill Thompson on 9/4/17.
 * Course Offering Class
 */

public class CourseOffering {
    // Define a Course Offering

    // TODO refactor Semester offerSemester to semester, remove int semester
    Semester offerSemester;
    // Declare and initialize the class variables
    private int semester;
    private int maxStudents;

    // TODO value of name should be a derived value of:
    // TODO Semester.Year + Semester.number + Course name
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //TODO change lecturer type String<>Lecturer
    private String lecturer;

    // course
    private Course course;

    public Course getCourse() {
        return course;
    }

    // TODO 	remove numberOfCourseOfferings integer and all calls to it.
    // TODO		total count of objects should be drawn from collection size
    // Declare and initialise the static variables
    public static int numberOfCourseOfferings = 0;

    // Construct a default Course Offering
    public CourseOffering() {
        numberOfCourseOfferings++;
    }

    // Construct a Course Offering with specific variables
    public CourseOffering(String name, int semester, int maxStudents, String lecturer) {
        this();
        this.name = name;
        this.semester = semester;
        this.maxStudents = maxStudents;
        this.lecturer = lecturer;
    }

    // Construct a Course Offering with specific variables, same as above plus course
    public CourseOffering(String name, int semester, int maxStudents, String lecturer, Course course) {
        this(name, semester, maxStudents, lecturer);
        this.course = course;
    }

    // Get the number of the semester
    public int getSemester() {
        return semester;
    }

    // Set the semester of the Course Offering
    public void setSemester(int newSemester) {
        this.semester = newSemester;
    }

    // Get the maximum number of student
    public int getMaxStudents() {
        return maxStudents;
    }

    // Set the maximum number of students
    public void setMaxStudents(int maxNoStudents) {
        this.maxStudents = maxNoStudents;
    }

    // Get the name of the Lecturer
    public String getNameOfLecturer() {
        return lecturer;
    }

    // Assign the Lecturer
    public void assignLecturerCourse(String assignedLecturer) {
        this.lecturer = assignedLecturer;
    }

}
