package model;

import exceptions.CompteIntrouvable;

import java.util.HashMap;
import java.util.Map;

public class Client extends Personne {
    private String idClient;
    private HashMap<String, Compte> comptes;

    public Client( String idClient, String nom, String prenom, String email, String motDePasse) {
        super(nom, prenom, email, motDePasse);
        this.idClient = idClient;
        this.comptes = new HashMap<>();
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public Map<String, Compte> getComptes(){
        return comptes;
    }

    public double consulterSolde(String numeroCompte){
        Compte compte = comptes.get(numeroCompte);
        if(compte ==null){
            throw new CompteIntrouvable();
        }
        return compte.getSolde();
    }




}
