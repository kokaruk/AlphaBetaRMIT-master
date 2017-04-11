package alphabeta.mvc.model;

public class Enrollment {

    Student student;
    public Result result;
    public CourseOffering courseOffering;
    boolean passed(){return !result.equals(Result.f);}
}