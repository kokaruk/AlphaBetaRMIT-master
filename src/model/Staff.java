package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

abstract class Staff extends User {

    public Staff(String name, String password) {
        super(name, password);
    }

    public List viewAllResults(Student student) {
        // TODO - implement model.Staff.viewAllResults
    	Set<Enrollment> list = student.getEnrollment();
    	List<String> forPrint = new ArrayList<String>();
    	for (Enrollment enrol : list)
    	{
    		CourseOffering courseOffering = enrol.courseOffering;
    		String name = courseOffering.getName();
    		String result = enrol.result.getDescription();
    		String fullResult = "Course: " + name + ", Result: " + result;
    		System.out.println(fullResult);
    		forPrint.add(fullResult);
    	}
    	return forPrint;
    }

}