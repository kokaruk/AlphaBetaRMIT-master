package alphabeta.mvc.model;

import org.junit.jupiter.api.*;
import org.mockito.*;

import static org.mockito.Mockito.*;


/**
 * @author dimz
 * @since 8/5/17.
 */
class AdminTest {

    private Semester semesterStatic;

    @Mock private CourseDirectory courseDirectoryMock;
    @Mock private Lecturer lecturer;
    @Mock private Course course;
    @Mock private CourseOffering courseOffering;
    private Admin admin;
    private String lecturerName = "blah";
    private Integer maxStudents = 50;
    private String courseName = "blahblah";



    @BeforeEach
    void setUp(){
        int semNum = 1;
        int semYear = 2010;
        int semWeek = 6;
        semesterStatic = new Semester(semNum, semYear, semWeek);
        MockitoAnnotations.initMocks(this);
        when(courseDirectoryMock.lookupLectByName(lecturerName)).thenReturn(lecturer);
        when(courseDirectoryMock.lookupCourse(courseName)).thenReturn(course);
        when(courseDirectoryMock.getCourseOffering(semesterStatic, maxStudents, lecturer, course))
                .thenReturn(courseOffering);
        when(courseDirectoryMock.getSemester()).thenReturn(semesterStatic);
        when(courseOffering.getName()).thenReturn(courseName);
        when(courseOffering.getMySemester()).thenReturn(semesterStatic);
        ModelHelper.setCDMock(courseDirectoryMock);
        admin = new Admin("Foo Bar", "foo bar", 123);
    }

    @AfterEach
    void terDown(){
        //nullify injected seam
        ModelHelper.setCDMock(null);
    }

    @Test
    void addNewCourseOffering_createNewOffering_verifyMethodCall(){
        admin.addNewCourseOffering(semesterStatic, maxStudents, lecturerName, courseName );
        verify(courseDirectoryMock, atLeastOnce()).lookupLectByName(lecturerName);
        verify(courseDirectoryMock, atLeastOnce()).getCourseOffering(semesterStatic, maxStudents, lecturer, course);
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition}/{totalRepetitions}")
    @DisplayName("advance system repeated")
    void advanceSystem_increment(){
        admin.advanceSystem();
        verify(courseDirectoryMock, atLeast(5)).getSemester();
    }




}