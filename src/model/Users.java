package model;

import exceptions.ClientExiste;

import java.util.HashMap;
import java.util.Map;

public class Users {
    private Map<String, Client> clients;
    private Map<String, Gestionnaire> gestionnaires;

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

    public Client clientParEmail(String email){
        return clients.get(email);
    }
    public Map<String, Client> getClients(){
        return clients;
    }

    public Map<String, Gestionnaire> getGestionnaires() {
        return gestionnaires;
    }
}
