package model;

import exceptions.MontantInvalidException;
import exceptions.MontantNegatifException;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class Compte {
    private String numeroCompte;
    private double solde;
    private  TypeCompte typeCompte;
    private HashSet<Transaction> historiqueTransactions;

    public Compte(String numeroCompte, double solde, TypeCompte typeCompte) {
        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        this.solde = solde;
        this.historiqueTransactions = new HashSet<>();
    }

    public String getNumeroCompte(){
        return numeroCompte;
    }

    public double getSolde(){
        return solde;
    }

    public TypeCompte getTypeCompte(){
        return typeCompte;
    }

    public Set<Transaction> getHistorique(){
        return historiqueTransactions;
    }

    public double deposer(double montant){
        if (montant <= 0){
            throw new MontantNegatifException();
        }
        this.solde += montant;

        String idtr = UUID.randomUUID().toString();
        Transaction tr = new Transaction(idtr, TypeTransaction.depot, montant, LocalDate.now(), null, this);
        historiqueTransactions.add(tr);
        return solde;
    }

    public double retirer(double montant){
        if (montant <= 0){
            throw new MontantNegatifException();
        }
        else if (montant > solde)
        {
            throw new MontantInvalidException();
        }
        this.solde -= montant;

        String idtr = UUID.randomUUID().toString();
        Transaction tr = new Transaction(idtr, TypeTransaction.retrait, montant, LocalDate.now(), this, null);
        historiqueTransactions.add(tr);
        return solde;
    }

    public boolean virement(Compte destination, double montant){
        if (montant <= 0){
            throw new MontantNegatifException();
        }
        if (montant > solde) {
            throw new MontantInvalidException();
        }
        this.solde -= montant;
        destination.solde += montant;

        String idtr = UUID.randomUUID().toString();
        Transaction tr = new Transaction(idtr, TypeTransaction.virement, montant, LocalDate.now(), this, destination);
        this.historiqueTransactions.add(tr);
        destination.historiqueTransactions.add(tr);

        return true;
    }
}
