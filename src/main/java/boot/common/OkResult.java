package boot.common;

public class OkResult {
    private final boolean success;
    private final String message;

    public OkResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
