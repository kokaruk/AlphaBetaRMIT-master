package alphabeta.mvc.model;


import alphabeta.mvc.systemDAL.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.*;

/**
 * Last edit by kristin on 13/5/17
 */

public final class CourseDirectory {

    private static Logger logger = LogManager.getLogger();

    // singleton instance
    private static CourseDirectory instance = new CourseDirectory();
    // DAO objects cluster
    private ICourseOfferingDAO courseOfferingDAO = FactoryDAO.courseOfferingDAO();
    private ISemesterDAO semesterDAO = FactoryDAO.semesterDAO();
    private ICourseDAO courseDAO = FactoryDAO.courseDAO();
    private ITopicDAO topicDAO = FactoryDAO.topicDAO();
    private IStudentDAO studentDAO = FactoryDAO.studentDAO();
    private ILecturerDAO lecturerDAO = FactoryDAO.lecturerDAO();

    private Semester semester = semesterDAO.getCurrentSemester();

    // private constructor
    private CourseDirectory() {
    }

    public static CourseDirectory getInstance() {
        return instance;
    }

    /*
     public Course(String name){
        this.name = name;
    }

    public Course(String name, List<Course> prerequisiteList, List<Topic> topics)
     */

    Course getNewCourse(String name) {
        return courseDAO.getNewCourse(name);
    }

    Course getNewCourse(String name, List<Course> prerequisiteList, List<Topic> topics) {
        return courseDAO.getNewCourse(name, prerequisiteList, topics);
    }

    public Set<Course> getCourseSet() {
        return courseDAO.getCourseSet();
    }

    public Set<Topic> getTopicSet() {
        return topicDAO.getTopicSet();
    }

    public void addTopic(Topic topic) {
        topicDAO.addTopic(topic);
    }

    public Set getStudentSet() throws SQLException {
        return studentDAO.getStudentSet();
    }

    public Student getNewStudent(String name, String username) throws SQLException {
        return studentDAO.getNewStudent(name, username);
    }


    Lecturer getNewLecturer(String name, String username) {
        return lecturerDAO.getNewLecturer(name, username);
    }

    public Set getLecturerSet() { return lecturerDAO.getLecturerSet(); }


    Lecturer lookupLectByName(String s){
        return lecturerDAO.lookupLectByName(s);
    }

    CourseOffering getCourseOffering(Semester semester, int maxStudents, Lecturer lecturer, Course course) {
        return courseOfferingDAO.getCourseOffering(semester, maxStudents, lecturer, course);
    }


    public Semester getSemester() {
        return semester;
    }


    public void incrementWeek() {
        semesterDAO.incrementWeek();
    }

    public void incrementSemester(int semNUmber, int year) {
        semesterDAO.incrementSemester(semNUmber, year);
    }


    public Set<CourseOffering> getCourseOfferingSet() {
        return courseOfferingDAO.getCurrentOfferings(semester);
    }

    //Find a topic with a String
    Topic lookUpTopic(String s) {
        return topicDAO.lookUpTopic(s);
    }

    //Find a course with a String
    public Course lookupCourse(String s) {
        return courseDAO.lookupCourse(s);
    }

    //Find a Student with studentID
    public Student lookupStudentByID(String s) throws SQLException, NumberFormatException {
        return studentDAO.lookupStudentByID(s);
    }

    public Student lookupStudentByName(String s) throws SQLException, NumberFormatException {
        return studentDAO.lookupStudentByName(s);
    }

    //Find a CourseOffering with a String
    CourseOffering lookupCourseOffering(String name) throws NoSuchElementException {
        return courseOfferingDAO.lookupCourseOffering(name);
    }


}
