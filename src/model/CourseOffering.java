package model;

/**
 * Created by Bill Thompson on 9/4/17.
 * Course Offering Class
 */

class CourseOffering {
	// Define a Course Offering

        Semester offerSemester;

		// Declare and initialize the class variables
		private String name;
		private int semester;
		private int maxStudents;
		private String lecturer;

		// Declare and initialise the static variables
		public static int numberOfCourseOfferings = 0;
		
		// Construct a default Course Offering
		public CourseOffering(){
			numberOfCourseOfferings++;
		}
		
		// Construct a Course Offering with specific variables
		public CourseOffering(String name, int semester, int maxStudents, String lecturer){
			this.name = name;
			this.semester = semester;
			this.maxStudents = maxStudents;
			this.lecturer = lecturer;
			numberOfCourseOfferings++;
		}

		// Get the name of the Course Offering
		public String getNameOfCourseOffering(){
			return name;
		}
		
		// Set the name of the Course Offering
		public void setName(String newName){
			this.name = newName;
		}
		
		// Get the number of the semester
		public int getSemester(){
			return semester;
		}
		
		// Set the semester of the Course Offering
		public void setSemester(int newSemester){
			this.semester = newSemester;
		}
		
		// Get the maximum number of student
		public int getMaxStudents(){
			return maxStudents;
		}
		
		// Set the maximum number of students
		public void setMaxStudents(int maxNoStudents){
			this.maxStudents = maxNoStudents;
		}
		
		// Get the name of the Lecturer
		public String getNameOfLecturer(){
			return lecturer;
		}
		
		// Assign the Lecturer
		public void assignLecturerCourse(String assignedLecturer){
			this.lecturer = assignedLecturer;
		}

		public String getName() {
			return name;
		}
}
