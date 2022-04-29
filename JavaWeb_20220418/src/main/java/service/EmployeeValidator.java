package service;

class Error{
	public Integer errorCode;
	public String errorMassage;
}

public class EmployeeValidator {
	private static final EmployeeValidator instance = new EmployeeValidator();
	private Error error;
	private EmployeeValidator() {
	}
	
	public static EmployeeValidator getInstance() {
		return instance;
	}
	
	public void name() {
		
	}
	
	public boolean hasError() {
		return error == null ? true : false;
	}
	
}
