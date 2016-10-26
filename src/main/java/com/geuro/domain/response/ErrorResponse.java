package main.java.com.geuro.domain.response;

public class ErrorResponse implements Response {
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(String msg) {
		this.errorMessage = msg;
	}
}