package systemDAL;

/**
 * @author dimz
 * @since 17/5/17.
 */
public class FactoryDAO {
    private static boolean devMode = true;

    public static ICourseOfferingDAO courseOfferingDAO(){
        return devMode ? CourseOfferingDAO_fake.getInstance() : CourseOfferingDAO.getInstance();
    }

}
