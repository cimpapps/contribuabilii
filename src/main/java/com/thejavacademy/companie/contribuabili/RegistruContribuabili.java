package com.thejavacademy.companie.contribuabili;

public class RegistruContribuabili {

    private static int numarTotal = 0;

    private static Contribuabil[] contribuabili = new Contribuabil[3];

    public static Contribuabil[] getContribuabili() {
        return contribuabili;
    }

    public static int getIndexContribuabilById(int id) {
        //fara binary search
        //apoi refactorizam cu binary search
        //apoi eficientizam facand in Anagajat un numarDeOrdine
        for (int i = 0; i < numarTotal; i++) {
            if (contribuabili[i].getId() == id) {
                return i;
            }
        }

        return -1;
    }

    public static void adaugaContribuabil(Contribuabil contribuabil) {
        numarTotal++;
        if (numarTotal > contribuabili.length) {
            maresteRegistru();
        }
        contribuabili[numarTotal - 1] = contribuabil;
        System.out.println("A fost adaugat contribuabilul " + contribuabil);
    }

    public static void stergeContribuabil(Contribuabil contribuabil) {
        //refactorizam sa stergem dintr-un singur pas dupa index
        int indexDeSters = getIndexContribuabilById(contribuabil.getId());
        if (indexDeSters < 0) {
            System.out.println("Acest contribuabil " + contribuabil + " nu exista in registru");
            return;
        }
        for (int i = indexDeSters; i < numarTotal - 1; i++) {
            contribuabili[i] = contribuabili[i + 1];
        }
        contribuabili[numarTotal - 1] = null;
        numarTotal--;
    }


    private static void maresteRegistru() {
        Contribuabil[] nouaLista = new Contribuabil[contribuabili.length * 2];

        for (int i = 0; i < contribuabili.length; i++) {
            nouaLista[i] = contribuabili[i];
        }

        contribuabili = nouaLista;
    }
}
