package alphabeta.mvc.model;


import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author dimz
 * @since 11/5/17.
 */
public class ProgramCoordinatorTest {

    private ProgramCoordinator programCoordinator;
    private String fakeStudentID = "232323";
    private String fakeWaiverString = "fake waiver";

    @Mock private CourseDirectory courseDirectoryMock;
    @Mock Student studentMock;
    @Mock Course courseMock;

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
    public void addNewCourse() {
        assertFalse(true);
    }

    @Test
    public void grantWaivers() throws Exception {
        programCoordinator.grantWaivers(fakeStudentID, fakeWaiverString);

        verify(studentMock).setWaivers(courseArgumentCaptor.capture());
        assertEquals(courseMock, courseArgumentCaptor.getValue());
    }

    @Test
    public void increaseLoad()  {
        programCoordinator.increaseLoad(fakeStudentID, 10);
        doNothing().when(studentMock).setMaxCurrentCourseLoad(10);
        verify(studentMock, atLeastOnce()).setMaxCurrentCourseLoad(10);
    }

}