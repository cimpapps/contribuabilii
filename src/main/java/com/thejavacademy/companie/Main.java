package com.thejavacademy.companie;

import com.thejavacademy.companie.contribuabili.Contribuabil;
import com.thejavacademy.companie.contribuabili.RegistruContribuabili;

import java.util.Arrays;

import static com.thejavacademy.companie.calculator.CalculatorTaxeEnum.*;
import static com.thejavacademy.companie.calculator.CalculatorTaxeEnum.CALCULATOR_CONSTRUCTII;
import static com.thejavacademy.companie.calculator.CalculatorTaxeEnum.CALCULATOR_IT;

public class Main {

    public static void main(String[] args) {
        Contribuabil a1 = new Contribuabil(CALCULATOR_CONSTRUCTII);
        Contribuabil a2 = new Contribuabil(CALCULATOR_IT);
        Contribuabil a3 = new Contribuabil(CALCULATOR_GENERAL);
        Contribuabil a4 = new Contribuabil(CALCULATOR_GENERAL);
        RegistruContribuabili.adaugaContribuabil(a1);
        RegistruContribuabili.adaugaContribuabil(a2);
        RegistruContribuabili.adaugaContribuabil(a3);
        RegistruContribuabili.adaugaContribuabil(a4);

        a1.declaraVenituri(32432.3);
        a2.declaraVenituri(3242.3);
        a3.declaraVenituri(52432.3);
        a4.declaraVenituri(82432.3);


        Contribuabil a5 = new Contribuabil(CALCULATOR_CONSTRUCTII);

        RegistruContribuabili.stergeContribuabil(a5);
        System.out.println(Arrays.toString(RegistruContribuabili.getAngajati()));
        RegistruContribuabili.stergeContribuabil(a1);
        RegistruContribuabili.stergeContribuabil(a2);
        RegistruContribuabili.stergeContribuabil(a3);
        RegistruContribuabili.stergeContribuabil(a4);

        System.out.println(Arrays.toString(RegistruContribuabili.getAngajati()));
    }
}
