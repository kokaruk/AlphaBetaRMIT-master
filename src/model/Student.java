package model;

import java.util.List;

/**
 * Student Class
 */
class Student extends User {

    private Degree myDegree;
    public Degree getMyDegree() {
        return myDegree;
    }
    public void setMyDegree(Degree myDegree) {
        this.myDegree = myDegree;
    }

    private List<Enrollment> myEnrollment;
    public List<Enrollment> getMyEnrollment() {
        return myEnrollment;
    }
    public void setMyEnrollment(List<Enrollment> myEnrollment) {
        this.myEnrollment = myEnrollment;
    }


    private int currentCourseLoad;
    public int getCurrentCourseLoad() {
        return currentCourseLoad;
    }
    public void setCurrentCourseLoad(int currentCourseLoad) {
        this.currentCourseLoad = currentCourseLoad;
    }

    public Student(String name, String username) {
        super(name, username);
    }

    public void viewMyResults() {
        // TODO - implement model.Student.viewMyResults
        throw new UnsupportedOperationException();
    }

    public boolean enrol() {
        // TODO - implement model.Student.enrol
        throw new UnsupportedOperationException();
    }

    public boolean withdraw() {
        // TODO - implement model.Student.withdraw
        throw new UnsupportedOperationException();
    }

}