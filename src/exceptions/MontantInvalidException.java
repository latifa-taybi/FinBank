package exceptions;

public class MontantInvalidException extends RuntimeException {
    public MontantInvalidException() {
        super("le montant doit etre inferieur au solde");
    }

    public MontantInvalidException(String message) {
        super(message);
    }
}
