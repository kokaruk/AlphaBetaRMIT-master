package alphabeta.mvc.model;

import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;


/**
 * @author dimz
 * @since 8/5/17.
 */
class AdminTest {

    static private Semester semesterStatic;

    @Mock private CourseDirectory courseDirectoryMock;
    @Mock private Lecturer lecturer;
    @Mock private Course course;
    @Mock private CourseOffering courseOffering;
    @Mock private Semester semester;

    private Admin admin;
    private String lecturerName = "blah";
    private Integer maxStudents = 50;
    private String courseName = "blahblah";

    @BeforeAll
    static void setupSemester(){
        semesterStatic = new Semester(1, 2010, 6);
    }

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);


        when(courseDirectoryMock.lookupLecturer(lecturerName)).thenReturn(lecturer);
        when(courseDirectoryMock.lookupCourse(courseName)).thenReturn(course);
        when(courseDirectoryMock.getCourseOffering(semester, maxStudents, lecturer, course))
                .thenReturn(courseOffering);
        when(courseOffering.getName()).thenReturn(courseName);
        when(courseOffering.getMySemester()).thenReturn(semester);
        when(semester.getSemesterNumber()).thenReturn(1);
        when(semester.getYear()).thenReturn(2001);
        ModelHelper.setCDMock(courseDirectoryMock);
        admin = new Admin("Foo Bar", "foo bar");
    }

    @AfterEach
    void terDown(){
        //nullify injected seam
        ModelHelper.setCDMock(null);
    }

    @Test
    void addNewCourseOffering_createNewOffering_verifyMethodCall(){
        admin.addNewCourseOffering(semester, maxStudents, lecturerName, courseName );
        verify(courseDirectoryMock, atLeastOnce()).lookupLecturer(lecturerName);
        verify(courseDirectoryMock, atLeastOnce()).getCourseOffering(semester, maxStudents, lecturer, course);
    }

    @RepeatedTest(value = 25, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("advance system repeated")
    void advanceSystem_increment(){
        when(courseDirectoryMock.getSemester()).thenReturn(semesterStatic);
        admin.advanceSystem();
        verify(courseDirectoryMock, atLeast(7)).getSemester();
    }




}