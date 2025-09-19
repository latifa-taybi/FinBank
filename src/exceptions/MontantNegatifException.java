package exceptions;

public class MontantNegatifException extends RuntimeException {
    public MontantNegatifException() {
        super("le montant doit etre positif");
    }

    public MontantNegatifException(String message) {
        super(message);
    }
}
