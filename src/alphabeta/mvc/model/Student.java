package alphabeta.mvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dimz on 8/4/17.
 * Student Class
 * Edited by kristin 13/05/17
 */
public final class Student extends User {
    private static Logger logger = LogManager.getLogger();
    private CourseDirectory courseDirectory = ModelHelper.getCourseDirectory();
    // list of currently and previously enrolled subjects
    private Set<Enrollment> enrollment = new HashSet<>();
    // list of mandatory pre-requisites waivers
    private Set<Course> waivers = new HashSet<>();
    private int maxCurrentCourseLoad;

    // constructor
    public Student(String name, String username, int ID) {
        super(name, username, ID);
        //add Student to list of students in Directory
    }

    Set<Enrollment> getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Set<Enrollment> enrollment) {
        this.enrollment.addAll(enrollment);
    }

    Set<Course> getWaivers() {
        return waivers;
    }

    public void setWaivers(Course waiver) {
        this.waivers.add(waiver);
    }

    public int getMaxCurrentCourseLoad() {
        return maxCurrentCourseLoad;
    }

    public void setMaxCurrentCourseLoad(int maxCurrentCourseLoad) {
        this.maxCurrentCourseLoad = maxCurrentCourseLoad;
    }

    /**
     * I think student result should be a struct-class of some description
     * Not 100% on the idea, so converting to string
     */
    public String viewMyResults() throws IllegalArgumentException {
        // check if has eny result
        if (enrollment.isEmpty()) throw new IllegalArgumentException("Student not enrolled in any class");
        StringBuilder results = new StringBuilder();
        for (Enrollment item : enrollment) {
            // course offering name
            results.append(String.format("%s,%s",
                    item.courseOffering.getName(),
                    // if current semester then in progress
                    courseDirectory.getSemester().equals(item.courseOffering.mySemester) ? "In Progress"
                            : item.result.getDescription() + (item.result.equals(Result.f) ? " : Failed" : " : Passed")
                    )
            );
            // append carriage return
            results.append("\r\n");
        }
        return results.toString();
    }

    public void enrol(Enrollment enrollment) throws IndexOutOfBoundsException, PrerequisitesNotMetException {
        logger.trace("enrollment method testing sequence");
        // can enroll?
        if (!(this.enrollment.size() < maxCurrentCourseLoad)) throw new IndexOutOfBoundsException("can't enroll" +
                " reached maximum allowed course loading");
        // see if enrollment has any prerequisites
        if (enrollment.courseOffering.getMyCourse().prerequisiteList != null &&
                enrollment.courseOffering.getMyCourse().prerequisiteList.size() > 0) {

            // build collection of missing required courses
            Set<Course> requiredCourses = enrollment.courseOffering
                    .getMyCourse()
                    .prerequisiteList
                    .stream()
                    .filter(prerequisite -> // filter off required prerequisites
                            !this.waivers.stream().anyMatch(waiver -> waiver.name.equals(prerequisite.name)))
                    .filter(requiredCourse -> // filter off passed courses
                            !this.enrollment
                                    .stream()
                                    .filter(en -> !en.result.equals(Result.f))
                                    .map(en -> en.courseOffering.getMyCourse())
                                    .anyMatch(passedCourse -> passedCourse.name.equals(requiredCourse.name)))
                    .collect(Collectors.toCollection(HashSet::new));
            if (requiredCourses.size() > 0) { // if collection has pre-requisites, throw error
                throw new PrerequisitesNotMetException(requiredCourses);
            }
        }
        this.enrollment.add(enrollment);
        enrollment.student = this;
    }

    public void withdraw() {
        throw new UnsupportedOperationException();
    }

}