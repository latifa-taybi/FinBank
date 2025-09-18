package model;

public class Gestionnaire extends Personne {
    private String idGestionnaire;

    public Gestionnaire(String nom, String prenom, String email, String motDePasse, String idGestionnaire) {
        super(nom, prenom, email, motDePasse);
        this.idGestionnaire = idGestionnaire;
    }

    public String getidGestionnaire() {
        return idGestionnaire;
    }
    public void setidGestionnaire(String idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }
}
