package com.thejavacademy.companie.angajati;

public class Contribuabil implements Taxabil, Incasator{

    private static int counter = 1;

    private int id;

    public Contribuabil() {
        this.id = counter;
        counter++;
    }

    public int getId() {
        return id;
    }


    public void incaseaza(int suma) {

    }

    public void platesteTaxa() {

    }


    @Override
    public String toString() {
        return "Contribuabil{" +
                "id=" + id +
                '}';
    }
}
