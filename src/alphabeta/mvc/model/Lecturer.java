package alphabeta.mvc.model;


import java.util.NoSuchElementException;
import java.util.Set;

public class Lecturer extends Staff {

    public Lecturer(String name, String username) {
        super(name, username);
        CourseDirectory.addLecturer(this);
    }

    Set<Course> myCourse;

    public boolean upLoadResults(Student student, Result result) throws NoSuchElementException, ItemExistsException{
        boolean uploaded;
        // TODO - implement alphabeta.mvc.model.Lecturer.upLoadResults
        //throw new UnsupportedOperationException();
        //if student not enrolled in course throw new NoSuchElementException()
        //if student already has a result saved for the course, throw ItemExistsException();
        return false;
    }




}