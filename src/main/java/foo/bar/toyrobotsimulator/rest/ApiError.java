package foo.bar.toyrobotsimulator.rest;

import java.time.ZonedDateTime;

class ApiError {

    private final int httpStatus;
    private final String message;
    private final ZonedDateTime timestamp = ZonedDateTime.now();

    ApiError(int httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public int getHttpStatus() {
        return httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
