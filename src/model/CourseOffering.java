package model;

public class CourseOffering {
	// Define a Course Offering

		// Declare and initialize the class variables
		String name = "Software Engineering Fundamentals";
		int semester = 2017;
		int maxStudents = 30;
		String lecturer = "Sam";
		
		// Declare and initialise the static variables
		static int numberOfCourseOfferings = 0;
		
		// Construct a Course Offering
		CourseOffering(){
			numberOfCourseOfferings++;
		}
		
		// Construct a Course Offering
		CourseOffering(String name, int semester, int maxStudents, String lecturer){
			numberOfCourseOfferings++;
		}

		// Set the namer of the Course Offering
		void setName(String newName){
			name = newName;
		}
		
		// Set the semester of the Course Offering
		void setSemester(int newSemester){
			semester = newSemester;
		}
		
		// Set the maximum number of students
		void setMaxStudents(int maxNoStudents){
			maxStudents = maxNoStudents;
		}
		
		// Assign the Lecturer
		void assignLecturerCourse(String assignedLecturer){
			lecturer = assignedLecturer;
		}
}
