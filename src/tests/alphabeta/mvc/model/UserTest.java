package alphabeta.mvc.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

/**
 * @author dimz
 * @since 8/5/17.
 * last edit by kristin 14/5/17
 */
public class UserTest {

    private ConcreteUser testUser;
    @Mock
    Degree degreeMock;
    @Mock
    Set<CourseOffering> coursesMock;

    @Before
    public void setup(){
        testUser = new ConcreteUser();
        MockitoAnnotations.initMocks(this);
        when(degreeMock.getCourses()).thenReturn(coursesMock);
        when(coursesMock.size()).thenReturn(50);
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
        assertEquals(degreeMock.courses.size(), testUser.viewCourseOfferings().size() );
    }

    private class ConcreteUser extends User{
        ConcreteUser(){
            super("Foo Bar", "foobar");
        }
    }


}