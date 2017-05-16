package alphabeta.mvc.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dimz
 * @since 8/5/17.
 * last edit by kristin 14/5/17
 */
public class UserTest {

    private static Logger logger = LogManager.getLogger();

    private CourseDirectory courseDirectory = CourseDirectory.getInstance();
    @Mock
    private Degree degreeMock;
    @Mock
    private Set<CourseOffering> coursesMock;
    private ConcreteUser testUser;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        when(degreeMock.getCourses()).thenReturn(coursesMock);
        when(coursesMock.size()).thenReturn(10);
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
        int limit = 10;
        int count = 0;

        while (count < limit) {
            courseDirectory.addCourseOffering(mock(CourseOffering.class));
            count++;
        }

        assertEquals(degreeMock.getCourses().size(), testUser.viewCourseOfferings().size() );
    }

    private class ConcreteUser extends User{
        ConcreteUser(){
            super("Foo Bar", "foobar");
        }
    }

}