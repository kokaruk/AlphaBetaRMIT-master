package alphabeta.mvc.systemDAL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author dimz
 * @since 19/5/17.
 */
public class DALHelperFunctions {

    private static List<String> randomNames;
    private static final String REGEX_SPLIT_OPTION;
    private static Logger logger = LogManager.getLogger();
    static {
        REGEX_SPLIT_OPTION = ",[ ]*";
        randomNames = new LinkedList<>();
    }


    public static String getRandomName() {
        //see if random names list has names, return any
        if (randomNames.size() > 0) {
            int randomArrayIndex = getRandomNumberInRange(0, randomNames.size() - 1);
            String randomName = randomNames.get(randomArrayIndex);
            randomNames.remove(randomArrayIndex); //remove name to avoid duplicates
            return randomName;
        } else {   // looks like run out of names, lets repopulate
            // read names list and recursive call to self
            try {
                randomNames = new LinkedList<>(Arrays.asList(
                        getConfigReader().getConfigString("names", "names.properties")
                                .split(REGEX_SPLIT_OPTION))
                );
            } catch (IOException err) {
                logger.fatal(err.getMessage());
                return null;
            }
            return getRandomName();
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    private static ABConfigRead getConfigReader() {
        return ABConfigRead.getInstance();
    }

}
