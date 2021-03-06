package alphabeta.mvc.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Staff extends User {

    public Staff(String name, String username, int ID) {
        super(name, username, ID);
    }

    public Set<String> viewAllResults(Student student) {
        // TODO - currently view results is only available through the view for lecturers. Needs to be made available for all staff.
        Set<Enrollment> list = student.getEnrollment();
        Set<String> forPrint = new HashSet<>();
        for (Enrollment enrol : list) {
            CourseOffering courseOffering = enrol.getCourseOffering();
            forPrint.add( courseOffering.getName() + "," + enrol.getResult().getDescription());
        }
        return forPrint;
    }

}