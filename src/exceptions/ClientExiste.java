package exceptions;

public class ClientExiste extends RuntimeException {
    public ClientExiste() {
        super("le client existe deja");
    }

    public ClientExiste(String message) {
        super(message);
    }
}
