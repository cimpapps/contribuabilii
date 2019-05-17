package com.thejavacademy.companie.contribuabili;

import com.thejavacademy.companie.calculator.ICalculatorTaxe;

public class Contribuabil implements Incasator{

    private static int counter = 1;

    private int id;

    private String nume;

    private double venituri;

    private double taxeDePlatit;

    private double taxePlatite;

    private ICalculatorTaxe calculatorTaxe;

    public Contribuabil(ICalculatorTaxe calculatorTaxe) {
        this.id = counter;
        counter++;
        this.calculatorTaxe = calculatorTaxe;
    }

    public int getId() {
        return id;
    }


    public void declaraVenituri(double suma) {
        this.venituri += suma;
        double taxaPeVenit = calculatorTaxe.calculeazaTaxa(suma);
        this.taxeDePlatit += taxaPeVenit;
        System.out.println(this);
    }

    public void platesteTaxa(double suma) {
        this.taxeDePlatit -= suma;
        this.taxePlatite += suma;
        System.out.println(this);
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
