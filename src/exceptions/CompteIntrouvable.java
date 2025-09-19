package exceptions;

public class CompteIntrouvable extends RuntimeException {
    public CompteIntrouvable() {
        super("le compte n existe pas");
    }

    public CompteIntrouvable(String message) {
        super(message);
    }
}
