package alphabeta.mvc.systemDAL;

import com.sun.rowset.CachedRowSetImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.sql.rowset.CachedRowSet;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author dimz
 * @since 18/5/17.
 */
public class postgreConnection {

    private postgreConnection(){}
    private static Logger logger = LogManager.getLogger();
    private static ABConfigRead configRead = ABConfigRead.getInstance();
    private static final String REGEX_SPLIT_OPTION = ",[ ]*";;

    static int insertStatement(String tableName, String columns, String wildcards, String paramsValues ) throws SQLException {
        String sql =
                "INSERT INTO " + tableName + "(" + columns + ")" +
                        " VALUES (" + wildcards + ")" +
                            " RETURNING id";
        Integer id = 0;
        try(Connection con  = getConnection()){
            con.setAutoCommit(false);
            try(PreparedStatement ps = con.prepareStatement(sql)) {
                fillParameters(ps, paramsValues  );
                ResultSet rs = ps.executeQuery();
                id = rs != null && rs.next() ? rs.getInt(1) : 0;
            } catch (SQLException e) {
                logger.error(e.getMessage());
                con.rollback();
                con.setAutoCommit(true);
            }
            con.commit();
            con.setAutoCommit(true);
        }
        return id;
    }


    static CachedRowSet getData(String tableName, String selectColumns,
                             String whereColumns, String paramsValues ) throws SQLException {
        String sql =
                "SELECT " + selectColumns + " FROM " + tableName +
                        " WHERE " + selectColumnWildCardBuilder(whereColumns);
        ResultSet rs = null;
        CachedRowSetImpl crs = new CachedRowSetImpl();

        try(Connection con  = getConnection()){
            try(PreparedStatement ps = con.prepareStatement(sql)) {
                fillParameters(ps, paramsValues  );
                rs = ps.executeQuery();
                crs.populate(rs);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
        return crs;
    }

    static String selectColumnWildCardBuilder(String columns){
        String[] columnsArray = columns.split(REGEX_SPLIT_OPTION);
        StringBuilder c = new StringBuilder();
        for (int i = 0; i < columnsArray.length; i++){
            c.append(i==0 ? columnsArray[i] + "=? " : "AND " + columnsArray[i] + "=? ");
        }
        return c.toString();
    }

    static String buildWildCards(String paramsValues){
        int wildCards = paramsValues.split(REGEX_SPLIT_OPTION).length;
        StringBuilder w = new StringBuilder();
        for (int i = 0; i<wildCards; i++){
            w.append( i == 0 ? "?" : ",?");
        }
        return w.toString();
    }


    private static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        try {
            props = configRead.getProperties("postgre.properties");
        } catch (IOException e) {
            logger.fatal(e.getMessage());
            System.exit(1);
        }
        return DriverManager.getConnection(props.getProperty("url"), props);
    }

    private static void fillParameters(PreparedStatement ps, String paramsValues ) {
        String[] paramValuesArray = paramsValues.split(REGEX_SPLIT_OPTION);
        for (int i = 0; i < paramValuesArray.length; i++) {
            try {
                ps.setString(i+1, paramValuesArray[i]);
            } catch (SQLException e) {
                logger.error(e.getMessage());
            }
        }
    }





}
