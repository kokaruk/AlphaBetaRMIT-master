package alphabeta.mvc.model;


import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author dimz
 * @since 11/5/17.
 */
class ProgramCoordinatorTest {

    private ProgramCoordinator programCoordinator;
    private String fakeStudentID = "232323";
    private String fakeWaiverString = "fake waiver";

    @Mock private CourseDirectory courseDirectoryMock;
    @Mock private Student studentMock;
    @Mock private Course courseMock;

    ArgumentCaptor<Course> courseArgumentCaptor;

    @BeforeEach
    void setup() throws CourseException {
        MockitoAnnotations.initMocks(this);
        courseArgumentCaptor = ArgumentCaptor.forClass(Course.class);
        when(courseDirectoryMock.lookupStudent(fakeStudentID)).thenReturn(studentMock);
        when(courseDirectoryMock.lookupCourse(fakeWaiverString)).thenReturn(courseMock);
        doNothing().when(studentMock).setWaivers(courseArgumentCaptor.capture());

        // inject fake dependency
        ModelHelper.setCDMock(courseDirectoryMock);
        programCoordinator = new ProgramCoordinator("Foo Bar", "foo bar");
    }

    @AfterEach
    void terDown(){
        //nullify injected seam
        ModelHelper.setCDMock(null);
    }

    @Disabled
    @Test
    @DisplayName("addNewCourse. Ignoring test due to planned refactoring of method")
    void addNewCourse() {
        assertFalse(true);
    }

    @Test
    @DisplayName("addNewCourse int Week = 9 throws CourseException")
    void addNewCourse_Week9_throwsCourseException() throws CourseException {
        assertThrows(CourseException.class, () ->  programCoordinator.addNewCourse(null,null,null,9));
    }


    @Test
    void grantWaivers() throws Exception {
        programCoordinator.grantWaivers(fakeStudentID, fakeWaiverString);

        verify(studentMock).setWaivers(courseArgumentCaptor.capture());
        assertEquals(courseMock, courseArgumentCaptor.getValue());
    }

    @Test
    void increaseLoad()  {
        programCoordinator.increaseLoad(fakeStudentID, 10);
        doNothing().when(studentMock).setMaxCurrentCourseLoad(10);
        verify(studentMock, atLeastOnce()).setMaxCurrentCourseLoad(10);
    }

}