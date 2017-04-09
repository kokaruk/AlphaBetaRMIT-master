package alphabeta.mvc.model;

/**
 * Created by dimz on 9/4/17.
 */
public enum Result {
    hd("High Distinction"),
    d("Distinction"),
    p("Pass"),
    f("Fail");

    // accessors
    private final String description;

    // constructor
    Result(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}