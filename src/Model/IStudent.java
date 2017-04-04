package Model;

import java.util.List;

/**
 * Created by dimz on 5/4/17.
 */
public interface IStudent {

    Degree getDegree();

    void setDegree(Degree degree);

    List<Enrollment> getCourse();

    void setCourse(List<Enrollment> course);

    int getCurrentCourseLoad();

    void setCurrentCourseLoad(int currentCourseLoad);

    // method should return something, probably a struct
    void viewMyResults();

    // enroll should return true if enroll successful
    boolean enrol();

    // same as enroll, method should return true if enroll successful
    boolean withdraw();

}
