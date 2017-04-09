package alphabeta.mvc.model;

import java.util.HashSet;
import java.util.Set;

public abstract class Staff extends User {

    public Staff(String name, String password) {
        super(name, password);
    }

    public Set<String> viewAllResults(Student student) {
        // TODO - implement alphabeta.mvc.model.Staff.viewAllResults
    	Set<Enrollment> list = student.getEnrollment();
    	Set<String> forPrint = new HashSet<String>();
    	for (Enrollment enrol : list)
    	{
    		CourseOffering courseOffering = enrol.courseOffering;
    		String name = courseOffering.getName();
    		String result = enrol.result.getDescription();
    		String fullResult = "Course: " + name + ", Result: " + result.toString();
    		System.out.println(fullResult);
    		forPrint.add(fullResult);
    	}
    	return forPrint;
    }

}