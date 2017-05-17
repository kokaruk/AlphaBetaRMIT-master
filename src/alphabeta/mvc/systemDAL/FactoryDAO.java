package alphabeta.mvc.systemDAL;

/**
 * @author dimz
 * @since 17/5/17.
 */
public class FactoryDAO {

    private static ABConfigRead configRead = ABConfigRead.getInstance();

    public static ICourseOfferingDAO courseOfferingDAO(){
        return isRealDAO("ICourseOfferingDAO")
                ? CourseOfferingDAO.getInstance()
                : CourseOfferingDAO_fake.getInstance();
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
