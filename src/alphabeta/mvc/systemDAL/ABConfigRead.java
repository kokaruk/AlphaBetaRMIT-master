package alphabeta.mvc.systemDAL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Properties;

/**
 * Reads Config Files. Implements singleton pattern to avoid sharing violation with lazy field instantiation.
 * @author dimz
 * @since 18/3/17
 */
public final class ABConfigRead {

    private static Logger logger = LogManager.getLogger();

    // singleton instance
    private static ABConfigRead instance;
    // private constructor
    private ABConfigRead() {
    }
    // lazy instantiation
    public static ABConfigRead getInstance() {
        if (instance == null) {
            instance = new ABConfigRead();
        }
        return instance;
    }

    /**
     * Get int from config file. Interface implementation.
     * @param myPropertyName property name string
     * @param myPropFile property
     * @return integer from
     */
    public int getConfigInt(String myPropertyName, String myPropFile) {
        int configInt = 0;
        try {
            configInt = Integer.parseInt(getConfigString(myPropertyName, myPropFile));
        } catch (NumberFormatException e) {
            logger.fatal(String.format("%s\r\nInvalid string to int casting format. Exiting ...", e.getMessage()));
            System.err.println();
            System.err.println(e.toString());
            System.exit(0);
        } catch (IOException err) {
            logger.fatal(err.getMessage());
            System.exit(0);
        }
        return configInt;
    }

    /**
     * Get string from config file. Interface implementation.
     * @param myPropertyName property name string
     * @param myPropFile path to property file
     * @return string of property value
     * @throws IOException if passed URI doesn't exist
     */
    public String getConfigString(String myPropertyName, String myPropFile) throws IOException {
        Properties myProp = new Properties();

        String myPropertyString;
        try (InputStream in = getClass().getResourceAsStream(myPropFile) ){
            myProp.load(in);
            myPropertyString = myProp.getProperty(myPropertyName);
        } catch (IOException ex) {
            logger.fatal(ex.getMessage());
            throw new IOException(String.format("Unknown issue accessing config file. See if %s exist in " +
                    "OzLympicGames/OzLympicGamesMVC/OzlModel", myPropFile));

        }
        return myPropertyString;
    }

}