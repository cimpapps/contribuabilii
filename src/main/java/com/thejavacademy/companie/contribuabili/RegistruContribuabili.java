package com.thejavacademy.companie.contribuabili;

public enum RegistruContribuabili {

    REGISTRU;

    private int numarTotal = 0;

    private IContribuabil[] contribuabili = new Contribuabil[3];

    public IContribuabil[] getContribuabili() {
        return contribuabili;
    }

    public int getIndexContribuabilById(int id) {
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

    public void adaugaContribuabil(Contribuabil contribuabil) {
        if (numarTotal + 1 > contribuabili.length) {
            maresteRegistru();
        }
        contribuabili[numarTotal] = contribuabil;
        numarTotal++;
        System.out.println("A fost adaugat contribuabilul " + contribuabil);
    }

    public void stergeContribuabil(Contribuabil contribuabil) {
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


    private void maresteRegistru() {
        IContribuabil[] nouaLista = new IContribuabil[contribuabili.length * 2];

        for (int i = 0; i < contribuabili.length; i++) {
            nouaLista[i] = contribuabili[i];
        }

        contribuabili = nouaLista;
    }
}
