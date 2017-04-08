package model;

import java.util.List;

/**
 * Student Class
 */
class Student extends User {

    private Degree degree;
    public Degree getDegree() {
        return degree;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    private List<Enrollment> enrollment;
    public List<Enrollment> getEnrollment() {
        return enrollment;
    }
    public void setEnrollment(List<Enrollment> enrollment) {
        this.enrollment = enrollment;
    }

    private List<Enrollment> waivers;
    public List<Enrollment> getWaivers() {
        return waivers;
    }
    public void setWaivers(List<Enrollment> waivers) {
        this.waivers = waivers;
    }

    private int currentCourseLoad;
    public int getCurrentCourseLoad() {
        return currentCourseLoad;
    }
    public void setCurrentCourseLoad(int currentCourseLoad) {
        this.currentCourseLoad = currentCourseLoad;
    }

    // constructor
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