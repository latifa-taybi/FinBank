import exceptions.ClientExiste;
import exceptions.MontantInvalidException;
import exceptions.MontantNegatifException;
import model.*;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.UUID;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Users users = new Users();

        Gestionnaire g1 = new Gestionnaire("1", "latifa", "taybi", "taybilatifa46@gmail.com", "1111");
        users.ajoutGestionnaire(g1);

        boolean quitter = false;
        int choix;

        while(!quitter){
            System.out.println("*******MENU*******");
            System.out.println("1. je suis Client");
            System.out.println("2. je suis Gestionnaire");
            System.out.println("3. Quitter");
            System.out.println("********************");
            System.out.println("saisir votre choix");

            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix){
// ___________________________________________CLIENT_________________________________________________
                case 1:
                    System.out.println("***************CLIENT****************");
                    System.out.println("entrer votre email : ");
                    String email = scanner.nextLine();
                    System.out.println("entrer votre password : ");
                    String motDePasse = scanner.nextLine();
                    Client client = users.authentifierClient(email, motDePasse);
                    if(client == null){
                        System.out.println("le client n'existe pas");
                        continue;
                    }else{
                        System.out.println("vous etes connecté avec succes");
                    }
                    boolean CQuitter = false;
                    while(!CQuitter){
                        int choixClient;
                        System.out.println("*******MENU CLIENT**********");
                        System.out.println("1. consulter mon solde");
                        System.out.println("2. deposer un montant");
                        System.out.println("3. retirer un montant");
                        System.out.println("4. effectuer un virement");
                        System.out.println("5. quitter");
                        System.out.println("************************");
                        System.out.println("saisir votre choix");
                        choixClient = scanner.nextInt();
                        scanner.nextLine();
                        switch (choixClient){
                            case 1:
                                System.out.println("Saisir le numero de compte");
                                String numCompte = scanner.nextLine();
                                try {
                                    double solde = client.consulterSolde(numCompte);
                                    System.out.println("votre solde est : " + solde);
                                }catch (Exception e){
                                    System.out.println("compte introuvable");
                                }
                                break;
                            case 2:
                                System.out.println("Saisir le numero de compte");
                                String numeroDep = scanner.nextLine();
                                Compte compteDep = client.getComptes().get(numeroDep);
                                if (compteDep == null) {
                                    System.out.println("compte introuvable");
                                    break;
                                }
                                System.out.println("saisir le montant a deposer : ");
                                double montantDepot = scanner.nextDouble();
                                scanner.nextLine();
                                try {
                                    compteDep.deposer(montantDepot);
                                    System.out.println("vous avez deposer "+ montantDepot);
                                } catch (MontantNegatifException e) {
                                    System.out.println("Erreur : le montant doit être positif.");
                                }
                                break;
                            case 3:
                                System.out.println("Saisir le numero de compte");
                                String numeCompteRet = scanner.nextLine();
                                Compte compteRet = client.getComptes().get(numeCompteRet);
                                if (compteRet == null) {
                                    System.out.println("compte introuvable");
                                    break;
                                }
                                System.out.println("saisir le montant a retirer : ");
                                double montantRetirer = scanner.nextDouble();
                                try {
                                    compteRet.retirer(montantRetirer);
                                    System.out.println("vous avez retirer "+ montantRetirer);
                                } catch (MontantInvalidException e) {
                                    System.out.println("le montant doit etre superieur au solde");
                                }catch (MontantNegatifException e){
                                    System.out.println("le montant doit etre positif");
                                }
                                break;
                            case 4:
                                System.out.println("Saisir votre numero de compte");
                                String numcompteSrc = scanner.nextLine();
                                Compte compteSrc = client.getComptes().get(numcompteSrc);
                                if (compteSrc == null) {
                                    System.out.println("compte introuvable");
                                    break;
                                }
                                System.out.println("Saisir le numero de compte de destination");
                                String numcompteDest = scanner.nextLine();
                                Compte compteDest = client.getComptes().get(numcompteDest);
                                if (compteDest == null) {
                                    System.out.println("compte introuvable");
                                    break;
                                }
                                System.out.println("saisir le montant a virer : ");
                                double montantVirement = scanner.nextDouble();
                                try {
                                    compteSrc.virement(compteDest, montantVirement);
                                    System.out.println("le virement est effectuer avec succes");
                                } catch (MontantNegatifException e) {
                                    System.out.println("le montant doit etre positif");
                                } catch (MontantInvalidException e) {
                                    System.out.println("le montant doit etre superieur au solde ");
                                }
                                break;
                            case 5:
                                CQuitter = true;
                                break;
                            default:
                                System.out.println("choix non valide");
                        }
                    }
                    break;
// ___________________________________________GESTIONNAIRE_________________________________________________
                case 2:
                    System.out.println("**************GESTIONNAIRE***********");
                    System.out.println("entrer votre email : ");
                    String emailGest = scanner.nextLine();
                    System.out.println("entrer votre mot de passe : ");
                    String motDePasseGest = scanner.nextLine();
                    Gestionnaire gestionnaire = users.authentifierGestionnaire(emailGest, motDePasseGest);
                    if(gestionnaire == null){
                        System.out.println("le gestionnaire n'existe pas");
                        break;
                    }
                    System.out.println("vous etes connecté avec succes");
                    boolean GQuitter = false;
                    while(!GQuitter) {
                        System.out.println("*******MENU GESTIONNAIRE**********");
                        System.out.println("1. creer un client");
                        System.out.println("2. creer un compte");
                        System.out.println("3. cloturer compte");
                        System.out.println("4. modifier client");
                        System.out.println("5. quitter");
                        System.out.println("************************");
                        System.out.println("saisir votre choix");
                        int choixGestinnaire = scanner.nextInt();
                        scanner.nextLine();
                        switch (choixGestinnaire) {
                            case 1:
                                System.out.println("entrer le nom du client : ");
                                String nomClient = scanner.nextLine();
                                System.out.println("entrer le prenom du client: ");
                                String prenomClient = scanner.nextLine();
                                System.out.println("entrer l email du client : ");
                                String emailClient = scanner.nextLine();
                                System.out.println("entrer le mot de passe du client : ");
                                String mdpClient = scanner.nextLine();
                                String idClient = UUID.randomUUID().toString();
                                try {
                                    users.ajoutClient(new Client(idClient, nomClient, prenomClient, emailClient, mdpClient));
                                    System.out.println("le client cree avec succes");
                                } catch (ClientExiste e) {
                                    System.out.println("le client existe deja");
                                }
                                break;
                            case 2:
                                System.out.println("saisir l email du client: ");
                                String emailDuClient = scanner.nextLine();
                                Client clientCompte = users.clientParEmail(emailDuClient);
                                if(clientCompte ==null) {
                                    System.out.println("client introuvable");
                                    break;
                                }
                                System.out.println("saisir le numero du compte:");
                                String numCompte = scanner.nextLine();
                                System.out.println("choisir le type du compte:");
                                String typeCpt = scanner.nextLine().toUpperCase();
                                TypeCompte typeCompte;
                                try {
                                    typeCompte = TypeCompte.valueOf(typeCpt);
                                } catch (IllegalArgumentException ex) {
                                    System.out.println("type de compte n existe pas");
                                    break;
                                }
                                gestionnaire.creerCompte(clientCompte,numCompte, typeCompte);
                                System.out.println("client cree avec succes");
                                break;
                            case 3:
                                System.out.println("saisir l email su client a cloturer:");
                                String emailClo = scanner.nextLine();
                                Client clientClo = users.clientParEmail(emailClo);
                                if(clientClo == null) {
                                    System.out.println("le client introuvable");
                                    break;
                                }
                                System.out.println("saisir le numero de compte a cloturer:");
                                String numCptClo = scanner.nextLine();
                                gestionnaire.cloturerCompte(clientClo,numCptClo);
                                System.out.println("le compte est cloturer");
                                break;
                            case 4:
                                System.out.println("saisir l email du client a modifier:");
                                String emailMod = scanner.nextLine();
                                Client clientMod = users.clientParEmail(emailMod);
                                if(clientMod == null) {
                                    System.out.println("le client introuvable");
                                    break;
                                }
                                System.out.println("saisir le nouveau email: ");
                                String nouvelEmail = scanner.nextLine();
                                System.out.println("saisir le nouveau mot de passe: ");
                                String nouvelMotDePasse = scanner.nextLine();
                                gestionnaire.modifierClient(clientMod, nouvelEmail, nouvelMotDePasse);
                                System.out.println(" client modifier avec succes");
                                break;
                            case 5:
                                GQuitter = true;
                                break;
                            default:
                                System.out.println("choix non valide");
                        }
                    }
                    break;
// ___________________________________________QUITTER_________________________________________________
                case 3:
                    quitter = true;
                    break;
                default:
                    System.out.println("choix invalide");
            }
        }
    }
}