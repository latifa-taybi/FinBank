package model;

import exceptions.CompteIntrouvable;

public class Gestionnaire extends Personne {
    private String idGestionnaire;

    public Gestionnaire(String idGestionnaire, String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.idGestionnaire = idGestionnaire;
    }

    public String getIdGestionnaire() {
        return idGestionnaire;
    }

    public void setIdGestionnaire(String idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Client creerClient(String idClient, String nom, String prenom, String email, String motDePasse) {
        return new Client(idClient, nom, prenom, email, motDePasse);
    }

    public boolean creerCompte(Client client, String numeroCompte, TypeCompte typeCompte){
        Compte compte = new Compte(numeroCompte,0, typeCompte);
        client.getComptes().put(compte.getNumeroCompte(), compte);
        return true;
    }

    public void cloturerCompte(Client client, String numeroCompte){
        Compte compte = client.getComptes().get(numeroCompte);
        if(compte == null) throw new CompteIntrouvable();
        client.getComptes().remove(numeroCompte);
    }

    public void modifierClient(Client client, String email, String motDePasse){
        client.setEmail(email);
        client.setMotDePasse(motDePasse);
    }

    @Override
    public String toString() {
        return "Gestionnaire{" +
                "idGestionnaire='" + idGestionnaire + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
