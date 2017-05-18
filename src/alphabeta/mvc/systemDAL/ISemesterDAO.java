package alphabeta.mvc.systemDAL;

import alphabeta.mvc.model.Semester;

/**
 * @author dimz
 * @since 18/5/17.
 */
public interface ISemesterDAO {
    Semester getCurrentSemester();
    void incrementWeek();
    void incrementSemester(int semNUmber, int year);
}
