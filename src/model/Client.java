package model;

public class Client extends Personne {
    private String idClient;

    public Client(String nom, String prenom, String email, String motDePasse, String idClient) {
        super(nom, prenom, email, motDePasse);
        this.idClient = idClient;
    }

    public String getIdClient() {
        return idClient;
    }
    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

}
