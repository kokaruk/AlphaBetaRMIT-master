package alphabeta.mvc.systemDAL;

/**
 * @author dimz
 * @since 17/5/17.
 */
public class FactoryDAO{


    private static ABConfigRead configRead = ABConfigRead.getInstance();

    public static ICourseOfferingDAO courseOfferingDAO(){
        return isRealDAO("ICourseOfferingDAO")
                ? CourseOfferingDAO.getInstance()
                : CourseOfferingDAO_fake.getInstance();
    }

    public static ISemesterDAO semesterDAO(){
        return isRealDAO("ISemesterDAO")
                ? SemesterDAO.getInstance()
                : SemesterDAO_fake.getInstance();
    }

    public static ICourseDAO courseDAO(){
        return isRealDAO("ICourseDAO")
                ? CourseDAO.getInstance()
                : CourseDAO_fake.getInstance();
    }

    public static ITopicDAO topicDAO(){
        return isRealDAO("ITopicDAO")
                ? TopicDAO.getInstance()
                : TopicDAO_fake.getInstance();
    }

    public static IStudentDAO studentDAO(){
        return isRealDAO("IStudentDAO")
                ? StudentDAO.getInstance()
                : StudentDAO_fake.getInstance();
    }

    public static ILecturerDAO lecturerDAO(){
        return isRealDAO("ILecturerDAO")
                ? LecturerDAO.getInstance()
                : LecturerDAO_fake.getInstance();
    }



    private static boolean isRealDAO(String methodReturnType){
        try {
            return Boolean.parseBoolean(configRead
                    .getConfigString(methodReturnType, "FactoryDAO.properties"));
        } catch (Exception e) {
            return false;
        }

    }
}
