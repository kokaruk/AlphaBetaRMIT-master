package alphabeta.mvc.model;
/**
  * Last edited by kristin on 13/5/17
 */

public class Semester {
    public int semesterNumber;
    public int year;
    public int week;

    public Semester(int semesterNumber, int year, int week) {
        this.semesterNumber = semesterNumber;
        this.year = year;
        this.week = week;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }

    public void setSemesterNumber(int semesterNumber) {
        this.semesterNumber = semesterNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Semester)) return false;

        Semester semester = (Semester) o;

        if (getSemesterNumber() != semester.getSemesterNumber()) return false;
        return (getYear() == semester.getYear());
    }

    @Override
    public int hashCode() {
        int result = getSemesterNumber();
        result = 31 * result + getYear();
        result = 31 * result + getWeek();
        return result;
    }
}