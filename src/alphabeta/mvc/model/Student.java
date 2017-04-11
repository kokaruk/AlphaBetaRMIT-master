package alphabeta.mvc.model;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by dimz on 8/4/17.
 * Student Class
 */
public final class Student extends User {

    // degree. OK to be null. Student can exist without enrollment
    private Degree degree;
    public Degree getDegree() {
        return degree;
    }
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    // list of currently and previously enrolled subjects
    private Set<Enrollment> enrollment = new HashSet<>();
    Set<Enrollment> getEnrollment() {
        return enrollment;
    }
    public void setEnrollment(Set<Enrollment> enrollment) {
        this.enrollment.addAll(enrollment);
    }
    // list of mandatory pre-requisites waivers
    private Set<Course> waivers = new HashSet<>();
    Set<Course> getWaivers() {
        return waivers;
    }
    public void setWaivers(Set<Course> waivers) {
        this.waivers = waivers;
    }

    private int maxCurrentCourseLoad;
    public int getMaxCurrentCourseLoad() {
        return maxCurrentCourseLoad;
    }
    public void setMaxCurrentCourseLoad(int maxCurrentCourseLoad) {
        this.maxCurrentCourseLoad = maxCurrentCourseLoad;
    }

    // constructor
    public Student(String name, String username) {
        super(name, username);
    }

    /**
     * I think student result should be a struct-class of some description
     * Not 100% on the idea, so converting to string
     */
    public String viewMyResults() throws IllegalStateException {
        // check if has eny result
        if (enrollment.isEmpty()) throw new IllegalStateException("Student not enrolled in any class");
        StringBuilder results = new StringBuilder();
        for (Enrollment item : enrollment){
            // course offering name
            results.append(String.format("%s,%s",
                    item.courseOffering.getName(),
                    degree.currentSemester != item.courseOffering.offerSemester ? item.result.getDescription() + (item.passed ? " : Passed" : ": Failed")
                            : "In Progress"
                    )
            );
            // append carriage return
            results.append("\r\n");
        }
        return results.toString();
    }

    public void enrol(Enrollment enrollment) throws IndexOutOfBoundsException, PrerequisitesNotMetException {
        // can enroll?
        if (!(this.enrollment.size() < maxCurrentCourseLoad)) throw new IndexOutOfBoundsException("can't enroll" +
                " reached maximum allowed course loading");

        // TODO implement checker and throw error if fails
        // see if new enrollment has prerequisites
        if (enrollment.courseOffering.getCourse().prerequisiteList != null &&
                enrollment.courseOffering.getCourse().prerequisiteList.size() > 0) {
            // build new collection of previously passed courses
            Set<Course>passedCourses = this.enrollment
                    .stream()
                    .filter(en -> en.passed)
                    .map(en -> en.courseOffering.getCourse())
                    .collect(Collectors.toCollection(HashSet::new));

            // build collection of missing required courses
            Set<Course> requiredCourse = enrollment.courseOffering
                    .getCourse()
                    .prerequisiteList
                    .stream()
                    .filter(c -> !this.waivers.contains(c))
                    .filter( c -> !passedCourses.contains(c))
                    .collect(Collectors.toCollection(HashSet::new));
            if (requiredCourse.size() > 0) {
                throw new PrerequisitesNotMetException(requiredCourse);
            }
        }
          this.enrollment.add(enrollment);
    }

    public void withdraw() {
        throw new UnsupportedOperationException();
    }

}