package service;

class Error{
	public Integer errorCode;
	public String errorMassage;
}

public abstract class Validator {
	Error error;
	public abstract void validate(Object target, Error error);
	public boolean hasError() {
		return error != null;
	}
}
