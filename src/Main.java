import model.Client;
import model.Compte;
import model.Gestionnaire;
import model.Users;

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
//                CLIENT
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
                                double solde = client.consulterSolde(numCompte);
                                System.out.println("votre solde est : "+ solde);
                                break;
                            case 2:
                                System.out.println("Saisir le numero de compte");
                                String numeroCompte = scanner.nextLine();
                                System.out.println("saisir le montant a deposer : ");
                                double montant = scanner.nextDouble();
                                Compte compte = client.getComptes().get(numeroCompte);
                                compte.deposer(montant);
                                System.out.println("vous avez deposer "+ montant);
                                break;
                            case 3:
                                System.out.println("Saisir le numero de compte");
                                String numeCompte = scanner.nextLine();
                                System.out.println("saisir le montant a retirer : ");
                                double montantRetirer = scanner.nextDouble();
                                Compte c = client.getComptes().get(numeCompte);
                                c.retirer(montantRetirer);
                                System.out.println("vous avez retirer "+ montantRetirer);
                                break;
                            case 4:
                                System.out.println("Saisir votre numero de compte");
                                String numcompteSrc = scanner.nextLine();
                                System.out.println("Saisir le numero de compte de destination");
                                String numcompteDest = scanner.nextLine();
                                System.out.println("saisir le montant a retirer : ");
                                double montantVirement = scanner.nextDouble();
                                Compte compteSrc = client.getComptes().get(numcompteSrc);
                                Compte compteDest = client.getComptes().get(numcompteDest);
                                compteSrc.virement(compteDest, montantVirement);
                                System.out.println("le virement est effectuer avec succes");
                                break;
                            case 5:
                                CQuitter = true;
                                break;
                            default:
                                System.out.println("choix non valide");
                        }
                    }
                    break;
                case 2:
                    System.out.println("**************GESTIONNAIRE***********");
                    System.out.println("entrer votre email : ");
                    String emailGest = scanner.nextLine();
                    System.out.println("entrer votre password : ");
                    String motDePasseGest = scanner.nextLine();
                    Gestionnaire gestionnaire = users.authentifierGestionnaire(emailGest, motDePasseGest);
                    if(gestionnaire == null){
                        System.out.println("le gestionnaire n'existe pas");
                        continue;
                    }else{
                        System.out.println("vous etes connecté avec succes");
                    }
                    boolean GQuitter = false;
                    while(!GQuitter) {
                        int choixGestinnaire;
                        System.out.println("*******MENU CLIENT**********");
                        System.out.println("1. creer un client");
                        System.out.println("2. creer un compte");
                        System.out.println("3. cloturer compte");
                        System.out.println("4. modifier client");
                        System.out.println("5. quitter");
                        System.out.println("************************");
                        System.out.println("saisir votre choix");
                        choixGestinnaire = scanner.nextInt();
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
                            case 2:

                                break;
                            case 3:

                                break;
                            case 4:

                                break;
                            case 5:
                                CQuitter = true;
                                break;

                        }
                    }
                case 3:

                    break;

            }

        }
    }
}