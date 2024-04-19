package CustomExceptions;
import static extentReporter.ExtentLogger.*;

public class CustomException extends Exception {
	public CustomException(String msg){
		super(msg);
		fail(msg);
		
	}

}
