package alphabeta.mvc.model;

/**
 * @author dimz
 * @since 17/5/17.
 */
class ModelHelper {

    private static CourseDirectory cdMock;

    // get instance of directory, can extract and override for testin purposes
    static CourseDirectory getCourseDirectory() {
        return cdMock != null ? cdMock : CourseDirectory.getInstance();
    }

    // inject mock dependency
    static void setCDMock(CourseDirectory cdMock){
        ModelHelper.cdMock = cdMock;
    }
}
