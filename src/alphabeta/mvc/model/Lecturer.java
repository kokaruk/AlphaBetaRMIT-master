package alphabeta.mvc.model;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Lecturer extends Staff {
    private static Logger logger = LogManager.getLogger();
    //constructor
    public Lecturer(String name, String username, int ID) {
        super(name, username, ID);
    }

    private Set<Course> myCourses = new HashSet<>();

    void addMyCourse(Course myCourse) {
        myCourses.add(myCourse);
    }

    public void upLoadResults(Student student, Result result, Course course) throws NoSuchElementException {
        if (!myCourses.contains(course)) throw new NoSuchElementException();
        student.getEnrollment().stream()
               .filter( enr -> enr.getCourseOffering().getMyCourse().equals(course))
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .setResult(result);
    }
}