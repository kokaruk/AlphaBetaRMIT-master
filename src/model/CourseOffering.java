package model;

class CourseOffering {
	// Define a Course Offering

        Semester offerSemester;

		// Declare and initialize the class variables
		private String name = "Software Engineering Fundamentals";
		private int semester = 2017;
		private int maxStudents = 30;
		private String lecturer = "Sam";
		
		// Declare and initialise the static variables
		public static int numberOfCourseOfferings = 0;
		
		// Construct a Course Offering
		public CourseOffering(){
			numberOfCourseOfferings++;
		}
		
		// Construct a Course Offering
		public CourseOffering(String name, int semester, int maxStudents, String lecturer){
			numberOfCourseOfferings++;
		}

		// Get the name of the Course Offering
		public String getNameOfCourseOffering(){
			return name;
		}
		
		// Set the name of the Course Offering
		public void setName(String newName){
			name = newName;
		}
		
		// Get the number of the semester
		public int getSemester(){
			return semester;
		}
		
		// Set the semester of the Course Offering
		public void setSemester(int newSemester){
			semester = newSemester;
		}
		
		// Get the maximum number of student
		public int getMaxStudents(){
			return maxStudents;
		}
		
		// Set the maximum number of students
		public void setMaxStudents(int maxNoStudents){
			maxStudents = maxNoStudents;
		}
		
		// Get the name of the Lecturer
		public String getNameOfLecturer(){
			return lecturer;
		}
		
		// Assign the Lecturer
		public void assignLecturerCourse(String assignedLecturer){
			lecturer = assignedLecturer;
		}

		public String getName() {
			return name;
		}
}
