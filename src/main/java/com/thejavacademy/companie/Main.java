package com.thejavacademy.companie;

import com.thejavacademy.companie.view.PanouAdmin;
import com.thejavacademy.companie.contribuabili.Contribuabil;
import com.thejavacademy.companie.contribuabili.RegistruContribuabili;

import javax.swing.*;
import java.util.Arrays;

import static com.thejavacademy.companie.calculator.CalculatorTaxe.*;
import static com.thejavacademy.companie.calculator.CalculatorTaxe.CALCULATOR_CONSTRUCTII;
import static com.thejavacademy.companie.calculator.CalculatorTaxe.CALCULATOR_IT;

/**
 * Se cere sa se dezvolte un program care sa tina evidenta veniturilor cetatenilor si a taxelor pe care le au de platit
 * Orice cetatean care plateste taxe(contribuabil) trebuie sa fie aibe urmatorul comportament:
 *  - isi declare veniturile noi (se adauga la veniturile totale)
 *  - isi plateasca taxele (se scade din taxele totale pe care le are de platit)
 *              *** nu are voie sa plateasca mai mult decat taxele datorate
 *  - sa raspunda la intrebarea ce venituri a avut pana in prezent(suma a tot ce a declarat pana in prezent)
 *  - sa raspunda la intrebarea ce taxe are de platit (double suma taxelor)
 *  - sa raspunda la intrbarea ce taxe a platit pana acum
 *  - sa raspunda la intrebarea ce id are - stim ca idul se vrea sa fie unic si sa fie in ordineea creeari lor.
 *              *** De asemenea idul nu va putea fi schimbat dupa ce a fost asignat unui contribuabil
 *
 * Toti contribuabilii trebuie sa fie adaugati la un registru care expune urmatoarele functionalitati:
 *  - adauga un contribuabil nou
 *  - sterge un contribuabil
 *  - raporteaza evidenta tuturor contribuabililor (ce venituri au, ce taxe au platit, ce taxe mai au de platit)
 *
 * Reigistrul este unic pentru toti contribuabilii
 *
 * *** Solutia initiala nu va fi optima, dar pe masura ce cursul va inainte elevii isi asuma responsabilitatea sa
 * *** Se va folosi doar ce am invatat pana acum
 */

public class Main {


    public static void main(String[] args) {
        Contribuabil a1 = new Contribuabil("Dan Homosexualul",CALCULATOR_CONSTRUCTII);
        Contribuabil a2 = new Contribuabil("Orlando aka Troaca", CALCULATOR_IT);
        Contribuabil a3 = new Contribuabil("Alin Bulenciaga", CALCULATOR_GENERAL);
        Contribuabil a4 = new Contribuabil("Catalin Grasu", CALCULATOR_GENERAL);
        RegistruContribuabili.REGISTRU.adaugaContribuabil(a1);
        RegistruContribuabili.REGISTRU.adaugaContribuabil(a2);
        RegistruContribuabili.REGISTRU.adaugaContribuabil(a3);
        RegistruContribuabili.REGISTRU.adaugaContribuabil(a4);

        a1.declaraVenituri(32432.3);
        a1.platesteTaxa(999);
        a2.declaraVenituri(3242.3);
        a2.platesteTaxa(1111);
        a3.declaraVenituri(52432.3);
        a4.declaraVenituri(82432.3);


        Contribuabil a5 = new Contribuabil("John Doe", CALCULATOR_CONSTRUCTII);

        RegistruContribuabili.REGISTRU.stergeContribuabil(a5);
        System.out.println(Arrays.toString(RegistruContribuabili.REGISTRU.getContribuabili()));
        System.out.println(Arrays.toString(RegistruContribuabili.REGISTRU.getContribuabili()));


        JFrame fereastra = new JFrame();
        fereastra.setContentPane(new PanouAdmin());
        fereastra.pack();
        fereastra.setVisible(true);
        fereastra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
