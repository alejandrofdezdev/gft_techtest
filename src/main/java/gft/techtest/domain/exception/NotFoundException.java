package gft.techtest.domain.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super("Not found");
    }
}
