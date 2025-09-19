package model;

import exceptions.CompteIntrouvable;

public class Gestionnaire extends Personne {
    private String idGestionnaire;

    public Gestionnaire(String idGestionnaire, String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.idGestionnaire = idGestionnaire;
    }

    public String getidGestionnaire() {
        return idGestionnaire;
    }

    public void setidGestionnaire(String idGestionnaire) {
        this.idGestionnaire = idGestionnaire;
    }

    public Client creerClient(String nom, String prenom, String email, String motDePasse, String idClient) {
        Client client = new Client(nom, prenom, email, motDePasse, idClient);
        return client;
    }

    public boolean creeCompte(Client client, Compte compte){
        client.getComptes().put(compte.getNumeroCompte(), compte);
        return true;
    }

    public boolean cloturerCompte(Client client, Compte compte){
        if(compte ==null){
            throw new CompteIntrouvable();
        }
        client.getComptes().remove(compte.getNumeroCompte(), compte);
        return true;
    }

    public boolean modifierClient(Client client, String email, String motDePasse){
        client.setEmail(email);
        client.setMotDePasse(motDePasse);
        return true;
    }


}
