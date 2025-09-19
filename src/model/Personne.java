package model;

public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected String email;
    protected String motDePasse;

    public Personne(String nom, String prenom, String email, String motDePasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public void setPrenom(String prenom){
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse(){
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }


    public boolean authentifier(String email, String motDePasse){
        if(this.email.equals(email) && this.motDePasse.equals(motDePasse)){
            return true;
        }
        return false;
    }

}
