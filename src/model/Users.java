package model;

import exceptions.ClientExiste;

import java.util.HashMap;

public class Users {
    private HashMap<String, Client> clients;
    private HashMap<String, Gestionnaire> gestionnaires;

    public Users(){
        this.gestionnaires = new HashMap<>();
        this.clients = new HashMap<>();
    }

    public void ajoutClient(Client client){
        if(clients.containsKey(client.getEmail())){
            throw new ClientExiste();
        }
        clients.put(client.getEmail(), client);
    }

    public void ajoutGestionnaire(Gestionnaire gestionnaire){
        gestionnaires.put(gestionnaire.getEmail(), gestionnaire);
    }

    public Client authentifierClient(String email, String motDePasse) {
        Client client = clients.get(email);
        if (client != null && client.authentifier(email, motDePasse)) {
            return client;
        }
        return null;
    }

    public Gestionnaire authentifierGestionnaire(String email, String motDePasse) {
        Gestionnaire gestionnaire = gestionnaires.get(email);
        if (gestionnaire != null && gestionnaire.authentifier(email, motDePasse)) {
            return gestionnaire;
        }
        return null;
    }

}
