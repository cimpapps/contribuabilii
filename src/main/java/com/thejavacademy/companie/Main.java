package com.thejavacademy.companie;

import com.thejavacademy.companie.calculator.view.PanouAdmin;
import com.thejavacademy.companie.contribuabili.Contribuabil;
import com.thejavacademy.companie.contribuabili.RegistruContribuabili;

import javax.swing.*;
import java.util.Arrays;

import static com.thejavacademy.companie.calculator.CalculatorTaxeEnum.*;
import static com.thejavacademy.companie.calculator.CalculatorTaxeEnum.CALCULATOR_CONSTRUCTII;
import static com.thejavacademy.companie.calculator.CalculatorTaxeEnum.CALCULATOR_IT;

public class Main {

    public static void main(String[] args) {
        Contribuabil a1 = new Contribuabil("Dan",CALCULATOR_CONSTRUCTII);
        Contribuabil a2 = new Contribuabil("Orlando", CALCULATOR_IT);
        Contribuabil a3 = new Contribuabil("Alin", CALCULATOR_GENERAL);
        Contribuabil a4 = new Contribuabil("Catalin", CALCULATOR_GENERAL);
        RegistruContribuabili.adaugaContribuabil(a1);
        RegistruContribuabili.adaugaContribuabil(a2);
        RegistruContribuabili.adaugaContribuabil(a3);
        RegistruContribuabili.adaugaContribuabil(a4);

        a1.declaraVenituri(32432.3);
        a1.platesteTaxa(999);
        a2.declaraVenituri(3242.3);
        a2.platesteTaxa(1111);
        a3.declaraVenituri(52432.3);
        a4.declaraVenituri(82432.3);


        Contribuabil a5 = new Contribuabil("John Doe", CALCULATOR_CONSTRUCTII);

        RegistruContribuabili.stergeContribuabil(a5);
        System.out.println(Arrays.toString(RegistruContribuabili.getAngajati()));
        System.out.println(Arrays.toString(RegistruContribuabili.getAngajati()));


        JFrame fereastra = new JFrame();
        fereastra.setContentPane(new PanouAdmin());
        fereastra.pack();
        fereastra.setVisible(true);
        fereastra.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
