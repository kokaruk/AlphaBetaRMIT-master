package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.CachedRowSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class StudentDAO implements IStudentDAO {

    private static final String TABLE_NAME = "system_users";
    private static final String VIEW_NAME = "system_user_view";
    private static final String COLUMN_NAMES = "name,username,password,user_type";
    private static Logger logger = LogManager.getLogger();

    // singleton instance
    private static IStudentDAO instance;
    // private constructor
    private StudentDAO() {
    }
    // lazy instantiation
    public static IStudentDAO getInstance() {
        if (instance == null) {
            instance = new StudentDAO();
        }
        return instance;
    }

    @Override
    public Set<Student> getStudentSet() throws SQLException {
        CachedRowSet rs = postgreConnection.getData(TABLE_NAME, "*", "user_type", "student" );
        Set<Student> studentSet = new HashSet<>();

        while (rs != null && rs.next()) {
            studentSet.add(new Student(rs.getString(2), rs.getString(3), rs.getInt(1)));
        }

        return studentSet;
    }

    @Override
    public Student getNewStudent(String name, String username) throws SQLException {
        String paramsVals = name+ ',' + username+ ',' + "secret" + ',' + "student";
        String wildcards = postgreConnection.buildWildCards(paramsVals);
        Integer idNum;
        SQLException error = null;
        try {
            idNum = postgreConnection.insertStatement(TABLE_NAME, COLUMN_NAMES, wildcards, paramsVals); // populate the database
            return new Student(name, username, idNum);
        } catch (SQLException e) {
            logger.error(name + " can't write new student to database. Will throw");
            throw e;
        }
    }

    @Override
    public Student lookupStudentByID(String s) throws SQLException, NumberFormatException {
        CachedRowSet rs = postgreConnection.getData("system_user_view", "*", "id, user_type", s+",student" );


       if (rs != null && rs.next()) {
           return new Student(rs.getString(2), rs.getString(3), rs.getInt(5));
       } else{
           return null;
       }
    }

    @Override
    public Student lookupStudentByName(String s) throws SQLException {
        CachedRowSet rs = postgreConnection.getData("system_user_view", "*", "name", s );
        if (rs != null && rs.next()) {
            return new Student(rs.getString(2), rs.getString(3), rs.getInt(5));
        } else{
            return null;
        }
    }
}
