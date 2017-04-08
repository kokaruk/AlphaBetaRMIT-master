package model;

class CourseOffering {
	// Define a Course Offering

        Semester offerSemester;

		// Declare and initialize the class variables
		public String name = "Software Engineering Fundamentals";
		public int semester = 2017;
		public int maxStudents = 30;
		public String lecturer = "Sam";
		
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

		// Set the namer of the Course Offering
		public void setName(String newName){
			name = newName;
		}
		
		// Set the semester of the Course Offering
		public void setSemester(int newSemester){
			semester = newSemester;
		}
		
		// Set the maximum number of students
		public void setMaxStudents(int maxNoStudents){
			maxStudents = maxNoStudents;
		}
		
		// Assign the Lecturer
		public void assignLecturerCourse(String assignedLecturer){
			lecturer = assignedLecturer;
		}

		public String getName() {
			return name;
		}
}
