package alphabeta.mvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author dimz
 * @since 8/5/17.
 * last edit by kristin 14/5/17
 */
public class UserTest {

    private static Logger logger = LogManager.getLogger();

    @Mock private CourseDirectory courseDirectoryMock;
    @Mock Semester semester;

    private ConcreteUser testUser;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        ModelHelper.setCDMock(courseDirectoryMock);
        testUser = new ConcreteUser();
    }

    @Test
    public void getName_nameEqualsToConcreteImplementationName() {
        assertEquals("Foo Bar", testUser.getName());
    }

    @Test
    public void getUserName_userNameEqualsToConcreteImplementationUserName() {
        assertEquals("foobar", testUser.getUsername());
    }

    @Test
    public void viewCourseOfferings_sizeOfPassedMockEqualsToReturnedValueSize() {
        Integer maxStudents = 50;

        int limit = 10;
        int count = 0;

        while (count < limit) {
            courseDirectoryMock.getCourseOffering(semester, maxStudents, mock(Lecturer.class), mock(Course.class));
            count++;
        }

        assertEquals(courseDirectoryMock.getCourseOfferingSet().size(), testUser.viewCourseOfferings().size() );
    }

    private class ConcreteUser extends User{
        ConcreteUser(){
            super("Foo Bar", "foobar", 123);
        }
    }

}