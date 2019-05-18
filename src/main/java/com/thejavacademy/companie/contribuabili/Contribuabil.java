package com.thejavacademy.companie.contribuabili;

import com.thejavacademy.companie.calculator.ICalculatorTaxe;

public class Contribuabil implements IContribuabil {

    private static int counter = 1;

    private int id;

    private String nume;

    private double venituri;

    private double taxeDePlatit;

    private double taxePlatite;

    private ICalculatorTaxe calculatorTaxe;
    

    public Contribuabil(String nume, ICalculatorTaxe calculatorTaxe) {
        this.id = counter;
        counter++;
        this.nume = nume;
        this.calculatorTaxe = calculatorTaxe;
    }

    public int getId() {
        return id;
    }


    public void declaraVenituri(double suma) {
        this.venituri += suma;
        double taxaPeVenit = calculatorTaxe.calculeazaTaxa(suma);
        this.taxeDePlatit += taxaPeVenit;
        System.out.println("Situatie contribuabil dupa ce a DECLARAT VENITUL " + suma +": " + this);
    }

    public void platesteTaxa(double suma) {
        if (suma > this.taxeDePlatit) {
            System.out.println("Ati incercat sa platiti suma de " + suma +
                    " - este mai mare decat taxa pe care o aveti de platit: " + this.taxeDePlatit);
            return;
        }
        this.taxeDePlatit -= suma;
        this.taxePlatite += suma;
        System.out.println("Situatie contribuabil dupa ce a PLATIT TAXA " + suma +": " + this);
    }

    public String getNume() {
        return nume;
    }

    public double getVenituri() {
        return venituri;
    }

    public double getTaxeDePlatit() {
        return taxeDePlatit;
    }

    public double getTaxePlatite() {
        return taxePlatite;
    }


    @Override
    public String toString() {
        return "Contribuabil{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", venituri=" + venituri +
                ", taxeDePlatit=" + taxeDePlatit +
                ", taxePlatite=" + taxePlatite +
                '}';
    }
}
