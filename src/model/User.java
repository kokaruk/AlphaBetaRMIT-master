package model;

/**
 * Created by dimz on 5/4/17.
 * Abstract implementation of user class
 */
abstract class User implements IUser {

    // fields & getters
    // name
    private String name;
    public String getName() {
        return name;
    }

    // username
	private String username;
	public String getUsername() {
		return username;
	}

    //constructor
    User(String name, String username){
        this.name = name;
        this.username = username;
    }


	public void viewCourseOffereings() {

	}

}