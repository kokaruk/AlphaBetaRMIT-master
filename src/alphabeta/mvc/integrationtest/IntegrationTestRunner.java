package alphabeta.mvc.integrationtest;

import alphabeta.mvc.model.CourseDirectory;
import alphabeta.mvc.model.Student;
import alphabeta.mvc.systemDAL.DALHelperFunctions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.Set;

/**
 * @author dimz
 * @since 19/5/17.
 */
public class IntegrationTestRunner {

    private static CourseDirectory courseDirectory = CourseDirectory.getInstance();
    private static Logger logger = LogManager.getLogger();
    public static void main(String[] args) {

        String name = DALHelperFunctions.getRandomName();

        try {
            Student student = courseDirectory.getNewStudent(name, name.replaceAll("\\s","").toLowerCase());
            logger.trace(student.getId());
            Set<Student> allStudents = courseDirectory.getStudentSet();
            logger.trace(allStudents.size());
            Student student1 = courseDirectory.lookupStudentByID("ST0014");
            logger.trace(student1.getUsername());
            Student student2 = courseDirectory.lookupStudentByName("Lorene Bates");
            logger.trace(student2.getId());
        } catch (SQLException e) {
            logger.warn(e.getMessage());
        }

    }
}
