package alphabeta.mvc.model;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * @author dimz
 * @since 8/5/17.
 */
public class AdminTest {


    @Mock private CourseDirectory courseDirectory;
    @Mock private Course course;
    @Mock private Lecturer lecturer;
    @Mock private Semester semester;
    @Mock private CourseOffering courseOffering;
    private Integer maxStudents = 50;
    private String lecturerName = "blah";
    private static Admin admin;
    private String courseName = "blahblah";

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);

        when(courseDirectory.lookupLecturer(lecturerName)).thenReturn(lecturer);
        when(courseDirectory.lookupCourse(courseName)).thenReturn(course);
        when(courseDirectory.getCourseOffering(semester, maxStudents, lecturer, course )).thenReturn(courseOffering);
        MockitoAnnotations.initMocks(this);
        admin = new Admin("Foo Bar", "foo bar");
    }

    @Test
    public void addNewCourseOffering_createNewOffering_verifyMethodCall(){
        admin.addNewCourseOffering(semester, maxStudents, lecturerName, courseName );

        verify(courseDirectory, atLeastOnce()).getCourseOffering(semester, maxStudents, lecturer, course);
    }

}