package alphabeta.mvc.model;

import org.junit.*;


/**
 * @author dimz
 * @since 8/5/17.
 */
public class AdminTest {

    public static Admin admin;

    @Before
    public void setUp(){
        admin = new Admin("Foo Bar", "foo bar");
    }


}