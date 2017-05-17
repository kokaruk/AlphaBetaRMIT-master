package alphabeta.mvc.model;


import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Lecturer extends Staff {

    public Lecturer(String name, String username) {
        super(name, username);
    }

    Set<Course> myCourses = new HashSet<>();

    void addMyCourse(Course myCourse) {
        myCourses.add(myCourse);
    }

    void upLoadResults(Student student, Result result, Course course) throws NoSuchElementException {
        if (!myCourses.contains(course)) throw new NoSuchElementException();

        Enrollment enrollment = student.getEnrollment()
                .stream()
                .filter( (enr) -> enr.getCourseOffering().getMyCourse().equals(course))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
        enrollment.setResult(result);
    }




}