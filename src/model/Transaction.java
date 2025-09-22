package model;

import java.time.LocalDate;
import java.util.HashSet;

public class Transaction {
    private String idTransaction;
    private TypeTransaction type ;
    private double montant;
    private LocalDate date;
    private Compte compteSource;
    private Compte compteDestination;

    public Transaction(String idTransaction, TypeTransaction type, double montant, LocalDate date, Compte compteSource, Compte compteDestination) {
        this.idTransaction = idTransaction;
        this.type = type;
        this.montant = montant;
        this.date = date;
        this.compteSource = compteSource;
        this.compteDestination = compteDestination;
    }

    public String getIdTransaction() {
        return idTransaction;
    }
    public TypeTransaction getType() {
        return type;
    }
    public double getMontant() {
        return montant;
    }
    public LocalDate getDate() {
        return date;
    }
    public Compte getCompteSource() {
        return compteSource;
    }
    public Compte getCompteDestination() {
        return compteDestination;
    }

    public void setIdTransaction(String idTransaction) {
        this.idTransaction = idTransaction;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setCompteSource(Compte compteSource) {
        this.compteSource = compteSource;
    }

    public void setCompteDestination(Compte compteDestination) {
        this.compteDestination = compteDestination;
    }

    @Override
    public String toString() {
        String src = compteSource.getNumeroCompte();
        String dest = compteDestination.getNumeroCompte();
        return date + " | " + type + " | Montant: " + montant + " | De: " + src + " À: " + dest;
    }
}
