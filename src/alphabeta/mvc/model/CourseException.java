package alphabeta.mvc.model;


public class CourseException extends Exception {

	private String reason;
			
		public CourseException(String reason)
		{
			this.reason = reason;
		}
			
		public String getReason()
		{
			return reason;
		}
	}



