package SystemDesignQues.vendingMachine.exceptions;

public class NotFullPaidException extends RuntimeException {

    private String message;
    private long remaining;


    public NotFullPaidException(String message, long remaining){
        this.message = message;
        this.remaining = remaining;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getRemaining() {
        return remaining;
    }

    public void setRemaining(long remaining) {
        this.remaining = remaining;
    }
}
