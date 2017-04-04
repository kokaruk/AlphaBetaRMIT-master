package Model;

import java.util.List;

class Lecturer extends Staff {

    public Lecturer(String name, String password) {
        super(name, password);
    }

    private List<CourseOffering> courses;

	public void upLoadResults() {
		// TODO - implement Model.Lecturer.upLoadResults
		throw new UnsupportedOperationException();
	}

}