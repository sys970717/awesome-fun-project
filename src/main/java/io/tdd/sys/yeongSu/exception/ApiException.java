package io.tdd.sys.yeongSu.exception;

public class ApiException extends RuntimeException {
    private String message;
    private int resultCode;

    public ApiException(int resultCode, String message) {
        super();
        this.resultCode = resultCode;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage() {
        this.message = message;
    }

    public int getStatus() {
        return resultCode;
    }

    public void setStatus(int resultCode) {
        this.resultCode = resultCode;
    }
}
