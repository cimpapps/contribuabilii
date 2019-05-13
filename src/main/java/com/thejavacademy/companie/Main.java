package com.thejavacademy.companie;

import com.thejavacademy.companie.angajati.Contribuabil;
import com.thejavacademy.companie.angajati.RegistruContribuabili;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Contribuabil a1 = new Contribuabil();
        Contribuabil a2 = new Contribuabil();
        Contribuabil a3 = new Contribuabil();
        Contribuabil a4 = new Contribuabil();
        RegistruContribuabili.adaugaAngajat(a1);
        RegistruContribuabili.adaugaAngajat(a2);
        RegistruContribuabili.adaugaAngajat(a3);
        RegistruContribuabili.adaugaAngajat(a4);


        Contribuabil a5 = new Contribuabil();

        RegistruContribuabili.stergeAngajat(a5);
        System.out.println(Arrays.toString(RegistruContribuabili.getAngajati()));
        RegistruContribuabili.stergeAngajat(a1);
        RegistruContribuabili.stergeAngajat(a2);
        RegistruContribuabili.stergeAngajat(a3);
        RegistruContribuabili.stergeAngajat(a4);

        System.out.println(Arrays.toString(RegistruContribuabili.getAngajati()));
    }
}
