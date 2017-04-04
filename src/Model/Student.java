package Model;

import java.util.List;

/**
 * Student Class
 */
class Student extends User implements IStudent {

    public Student(String name, String password) {
        super(name, password);
    }

    private Degree degree;
	private List<Enrollment> course;
	private int currentCourseLoad;

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public List<Enrollment> getCourse() {
        return course;
    }

    public void setCourse(List<Enrollment> course) {
        this.course = course;
    }

    public int getCurrentCourseLoad() {
        return currentCourseLoad;
    }

    public void setCurrentCourseLoad(int currentCourseLoad) {
        this.currentCourseLoad = currentCourseLoad;
    }

    public void viewMyResults() {
		// TODO - implement Model.Student.viewMyResults
		throw new UnsupportedOperationException();
	}

	public boolean enrol() {
		// TODO - implement Model.Student.enrol
		throw new UnsupportedOperationException();
	}

	public boolean withdraw() {
		// TODO - implement Model.Student.withdraw
		throw new UnsupportedOperationException();
	}

}