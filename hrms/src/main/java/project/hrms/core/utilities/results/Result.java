package project.hrms.core.utilities.results;

public class Result {
	private boolean succcess;
	private String message;

	public Result(boolean success) {
		this.succcess = success;
	}

	public Result(boolean success, String message) {
		this(success);
		this.message = message;
	}

	public boolean isSuccess() {
		return this.succcess;
	}

	public String getMessage() {
		return this.message;
	}

}
