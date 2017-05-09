package alphabeta.mvc.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Staff extends User {

    public Staff(String name, String username) {
        super(name, username);
    }

    public Set<String> viewAllResults(Student student) {
        Set<Enrollment> list = student.getEnrollment();
        Set<String> forPrint = new HashSet<>();
        for (Enrollment enrol : list) {
            CourseOffering courseOffering = enrol.getCourseOffering();
            String name = courseOffering.getName();
            String result = enrol.getResult().getDescription();
            String fullResult = name + "," + result;
            forPrint.add(fullResult);
        }
        return forPrint;
    }

}