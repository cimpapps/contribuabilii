package com.thejavacademy.companie.contribuabili;

public class RegistruContribuabili {

    private static int numarTotal = 0;

    private static Contribuabil[] angajati = new Contribuabil[10];

    public static Contribuabil[] getAngajati() {
        return angajati;
    }

    public static int getIndexContribuabilById(int id) {
        //fara binary search
        //apoi refactorizam cu binary search
        //apoi eficientizam facand in Anagajat un numarDeOrdine
        for (int i = 0; i < numarTotal; i++) {
            if (angajati[i].getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public static void adaugaContribuabil(Contribuabil contribuabil) {
        numarTotal++;
        if (numarTotal > angajati.length) {
            maresteRegistru();
        }
        angajati[numarTotal - 1] = contribuabil;
        System.out.println("A fost contribuabil " + contribuabil);
    }

    public static void stergeContribuabil(Contribuabil contribuabil) {
        //refactorizam sa stergem dintr-un singur pas dupa index
        int indexDeSters = getIndexContribuabilById(contribuabil.getId());
        if (indexDeSters < 0) {
            System.out.println("Acest contribuabil " + contribuabil + " nu exista in registru");
            return;
        }
        for (int i = indexDeSters; i < numarTotal - 1; i++) {
            angajati[i] = angajati[i + 1];
        }
        angajati[numarTotal - 1] = null;
        numarTotal--;
    }


    private static void maresteRegistru() {
        Contribuabil[] nouaLista = new Contribuabil[angajati.length * 2];

        for (int i = 0; i < angajati.length; i++) {
            nouaLista[i] = angajati[i];
        }

        angajati = nouaLista;
    }
}
